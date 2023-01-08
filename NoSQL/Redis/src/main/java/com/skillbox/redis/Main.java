package com.skillbox.redis;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Random;

public class Main {
    // Запуск докер-контейнера:
    // docker run --rm --name skill-redis -p 127.0.0.1:6379:6379/tcp -d redis

    //количество новых пользователей
    private static final int USERS_COUNT = 20;

    //формат даты
    private static final SimpleDateFormat DF = new SimpleDateFormat("HH:mm:ss");

    private static void log(int newUser) {
        String log = String.format("[%s] На главной странице показываем пользователя: %d",
                DF.format(new Date()), newUser);
        System.out.println(log);
    }

    private static void logPremium(int premiumUser) {
        String logPremium = String.format("[%s] >Пользователь %d оплатил платную услугу",
                DF.format(new Date()), premiumUser);
        System.out.println(logPremium);
    }

    public static void main(String[] args) throws InterruptedException {
        RedisStorage redis = new RedisStorage();
        redis.init();

        while (true) {
            int step = 1;
            for (int i = 1; i <= USERS_COUNT; i++) {
                redis.logNewUser(i);
                step++;

                if (step == 10) {
                    int premium_id = new Random().nextInt(USERS_COUNT);
                    redis.logNewUser(premium_id);
                    step = 1;
                }
            }

            for (String user : redis.getUsers()) {
                log(Integer.parseInt(user));
                Thread.sleep(500);
            }

            Thread.sleep(1000);
        }
    }
}
