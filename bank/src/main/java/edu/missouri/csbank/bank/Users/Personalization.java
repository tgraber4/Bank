package edu.missouri.csbank.bank.Users;

public class Personalization {
    private NotificationLevel notificationLevel;

    public Personalization(NotificationLevel notifications) {

        this.notificationLevel = notifications;
    }

    public NotificationLevel getNotifications() {

        return this.notificationLevel;
    }

    public void setNotifications(NotificationLevel notifications) {

        this.notificationLevel = notifications;
    }
}
