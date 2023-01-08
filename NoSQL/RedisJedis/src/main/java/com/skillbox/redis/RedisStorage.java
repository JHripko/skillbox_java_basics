package com.skillbox.redis;

import redis.clients.jedis.JedisPooled;
import java.util.Date;

public class RedisStorage {
    //создаем экземпляр хранилища с параметрами подключения к базе redis
    private final JedisPooled redisStorage = new JedisPooled("localhost", 6379);

    //создаем ключ
    private final String KEY = "NEW_USERS";

    //создаем score на основе времени запроса
    private double getTS() {
        return new Date().getTime() / 1000;
    }

    //добавление пользователя в базу
    void logNewUser(int user_id) {
        redisStorage.zadd(KEY, getTS(), String.valueOf(user_id));
    }

    //проверка наличия пользователя в базе
    boolean isRegister(int user_id) {
        return redisStorage.zscore(KEY, String.valueOf(user_id)) != null;
    }

    //очистка базы
    void shutdown() {
        redisStorage.del(KEY);
    }
}
