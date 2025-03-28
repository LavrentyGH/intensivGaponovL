package com.notificationdunice.intensivgaponovl.CommonKnowledgeSoftSkills.SOLID.SingleResponsibilityAndDSP;

class EmailSender implements MessageSender {
    public void send(String recipient, String content) {
        System.out.println("Email to " + recipient + ": " + content);
    }
}
