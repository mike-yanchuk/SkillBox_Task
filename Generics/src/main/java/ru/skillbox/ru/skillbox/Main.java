package ru.skillbox;

import ru.skillbox.notification.EmailNotification;
import ru.skillbox.notification.Notification;
import ru.skillbox.notification.PushNotification;
import ru.skillbox.notification.SmsNotification;
import ru.skillbox.notification_sender.EmailNotificationSender;
import ru.skillbox.notification_sender.PushNotificationSender;
import ru.skillbox.notification_sender.SmsNotificationSender;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            System.out.println("Введите куда вы хотите получать рассылку");
            String user = new Scanner(System.in).nextLine();
            if(user.equals("poka") || user.isEmpty()){
                break;
            }
            char proverka = 0;
            for (int i = 0; i < user.length(); i++) {
                proverka = user.charAt(i);
                if (proverka == '+') {
                    break;
                } else if (proverka == '@') {
                    break;
                }
            }
            String welcome = "Успешная регистрация";
            if (proverka == '+') {
                SmsNotification smsNotification = new SmsNotification();
                SmsNotificationSender smsNotificationSender = new SmsNotificationSender();

                System.out.println("SMS");
                System.out.println("receivers: " + user);
                smsNotificationSender.send(smsNotification);
            } else if (proverka == '@') {
                EmailNotification emailNotification = new EmailNotification();
                EmailNotificationSender emailNotificationSender = new EmailNotificationSender();

                System.out.println("EMAIL");
                System.out.println("subject: " + welcome);
                System.out.println("receivers: " + user);
                emailNotificationSender.send(emailNotification);
            } else {
                PushNotification pushNotification = new PushNotification();
                PushNotificationSender pushNotificationSender = new PushNotificationSender();

                System.out.println("PUSH");
                System.out.println("subject: " + welcome);
                System.out.println("receivers: " + user);
                pushNotificationSender.send(pushNotification);
            }
        }


//        List<SmsNotification> testList = new ArrayList<>();
//        testList.add(smsNotification);
//        smsNotificationSender.send(testList);






    }
}