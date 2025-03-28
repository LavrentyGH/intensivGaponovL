package com.notificationdunice.intensivgaponovl.CommonKnowledgeSoftSkills.SOLID.SingleResponsibilityAndDSP;

public class EmailService {

    public void sendEmail(String to, String message) {
        System.out.println("Отправка письма на " + to + ": " + message);
    }
}
