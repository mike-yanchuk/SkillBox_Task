package ru.skillbox.notification_sender;

import lombok.Getter;
import ru.skillbox.notification.SmsNotification;

import java.util.ArrayList;
import java.util.List;

public class SmsNotificationSender implements NotificationSender<SmsNotification> {

    @Override
    public void send(SmsNotification notification) {
        String notificationSms = notification.formattedMessage();
        System.out.println("message: " + notificationSms);
    }

    @Override
    public void send(List<SmsNotification> notifications) {

        for (int i = 0; i < notifications.size(); i++) {
            System.out.println(notifications.get(i).notofocationList);
        }

    }
}
