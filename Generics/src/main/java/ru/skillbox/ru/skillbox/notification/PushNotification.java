package ru.skillbox.notification;

import ru.skillbox.notification.Notification;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PushNotification implements Notification {
    public List<String> notofocationList = new ArrayList<>();

    public String formattedMessage() {

        String message = "Спасибо за регистрацию на сервисе!";
        return "\uD83D\uDC4B" + message;
    }
}
