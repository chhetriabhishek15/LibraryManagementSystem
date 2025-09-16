package interfaces;

import models.Patron;

public interface Notification {
    void sendNotification(Patron patron, String message);
}
