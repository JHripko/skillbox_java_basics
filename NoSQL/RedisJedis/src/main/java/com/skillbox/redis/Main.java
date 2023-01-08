package com.skillbox.redis;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    //количество пользователей
    private static final int USERS_COUNT = 20;
    //формат даты логов
    private static final SimpleDateFormat DF = new SimpleDateFormat("HH:mm:ss");

    //лог отображения пользователя на главной странице
    private static void log(int user_id) {
        String log = String.format("[%s] На главной странице показываем пользователя: %d",
                DF.format(new Date()), user_id);
        System.out.println(log);
    }

    //лог приобретения пользователем платной услуги
    private static void logPurchase(int user_id) {
        String log = String.format(">Пользователь %s оплатил платную услугу", user_id);
        System.out.println(log);
    }

    public static void main(String[] args) throws InterruptedException {
        RedisStorage redis = new RedisStorage();

        //бесконечный цикл
        while (true) {
            //счетчик шагов
            int step = 1;

            for (int i = 1; i <= USERS_COUNT; i++) {
                //на каждый 10 шаг генерируем покупку услуги случайным пользователем
                if (step == 10) {
                    int premium_id =(int) (Math.random() * (USERS_COUNT - 1) + 1);
                    //добавляем его id в базу redis
                    redis.logNewUser(premium_id);
                    //отображаем его id в логе приобретения платной услуги
                    logPurchase(premium_id);
                    //отображаем пользователя в логе отображения на главной страцице
                    log(premium_id);
                    //сбрасываем счетчик
                    step = 1;
                    Thread.sleep(500);
                } else {
                    //проверяем, если пользователь с таким id ранее уже отображался при покупке платной подписки,
                    // то не отображаем его повторно
                    if (!redis.isRegister(i)) {
                        redis.logNewUser(i);
                        log(i);
                        step++;
                        Thread.sleep(500);
                    }
                }
            }
            //очистка базы
            redis.shutdown();
            Thread.sleep(1000);
        }
    }
}
