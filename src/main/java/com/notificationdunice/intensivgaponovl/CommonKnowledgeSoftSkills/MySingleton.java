package com.notificationdunice.intensivgaponovl.CommonKnowledgeSoftSkills;

public class MySingleton {
    private static MySingleton instance;

    private MySingleton() {
        System.out.println("create object");
    }

    public static MySingleton getInstance() {
        if (instance == null) {
            instance = new MySingleton();
        }
        return instance;
    }
}
