package ru.skillbox.notification;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class SmsNotification implements Notification {
    public List<String> notofocationList = new ArrayList<>();

    @Override
    public String formattedMessage() {
        String message = "Спасибо за регистрацию на сервисе!";
        return message;
    }



//    public List<String> notificationList(){
//        List<String> notificationList = new ArrayList<>(){{
//            add("Успешная регистрация");
//            add("заходите ко мне на сайт");
//            add("Весенняя распродажа");
//            add("Как дела?");
//        }};
//        return notificationList;
//    }
}
