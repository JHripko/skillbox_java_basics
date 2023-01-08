package com.skillbox.redis;

import org.redisson.Redisson;
import org.redisson.api.RKeys;
import org.redisson.api.RScoredSortedSet;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisConnectionException;
import org.redisson.config.Config;

import java.util.Collection;
import java.util.Date;

public class RedisStorage {
    //объект для работы с Redis
    private RedissonClient redissonClient;

    //объект для работы с ключами
    private RKeys rKeys;

    //объект для работы с Sorted Set'ом
    private RScoredSortedSet<String> newUsers;

    private final static String KEY = "NEW_USERS";

    private double getTs() {
        return new Date().getTime() / 1000;
    }

    //пример вывода всех ключей
    public void listKeys() {
        Iterable<String> keys = rKeys.getKeys();
        for (String key : keys) {
            System.out.println("KEY: " + key + " , type: " + rKeys.getType(key));
        }
    }

    void init() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        try {
            redissonClient = Redisson.create(config);
        } catch (RedisConnectionException exception) {
            System.out.println("Не удалось подключиться к Redis");
            System.out.println(exception.getMessage());
        }
        rKeys = redissonClient.getKeys();
        newUsers = redissonClient.getScoredSortedSet(KEY);
        rKeys.delete(KEY);
    }

    void shutdown() {
        redissonClient.shutdown();
    }

    //фиксирует регистрацию пользователя
    void logNewUser(int user_id) {
        //ZADD NEW_USERS
        newUsers.add(getTs(), String.valueOf(user_id));
    }

    Collection<String> getUsers() {
        return newUsers.valueRange(0, 100000);
    }
}
