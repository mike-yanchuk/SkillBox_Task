package ru.skillbox.notification_sender;

import ru.skillbox.notification.EmailNotification;

import java.util.List;

public class EmailNotificationSender implements NotificationSender<EmailNotification> {
    @Override
    public void send(EmailNotification notification) {
        System.out.println(notification.formattedMessage());
    }

    @Override
    public void send(List<EmailNotification> notifications) {
        for (int i = 0; i < notifications.size(); i++) {
            System.out.println(notifications.get(i).notofocationList);
        }
    }
}
