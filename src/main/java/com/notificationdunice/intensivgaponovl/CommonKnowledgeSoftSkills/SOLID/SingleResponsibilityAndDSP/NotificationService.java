package com.notificationdunice.intensivgaponovl.CommonKnowledgeSoftSkills.SOLID.SingleResponsibilityAndDSP;

public class NotificationService {
    private final MessageSender sender;

    public NotificationService(MessageSender sender) {
        this.sender = sender;
    }

    public void notifyUser(User user, String message) {
        sender.send(user.getEmail(), message);
    }
}
