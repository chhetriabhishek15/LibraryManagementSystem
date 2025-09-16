package service;

import interfaces.Notification;
import models.Patron;

public class NotificationService implements Notification {
    @Override
    public void sendNotification(Patron patron, String message) {
        System.out.println("THE NOTIFICATION");
        System.out.println("To: " + patron.getPatronName());
        System.out.println("Message: " + message);
        System.out.println("------------------------");
    }
}
