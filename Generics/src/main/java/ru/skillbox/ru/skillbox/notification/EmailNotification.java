package ru.skillbox.notification;

import ru.skillbox.notification.Notification;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class EmailNotification implements Notification {
    public List<String> notofocationList = new ArrayList<>();
    @Override
    public String formattedMessage() {
        String message = "Спасибо за регистрацию на сервисе!";
        return "<p>" + message + "</p>";
    }
}
