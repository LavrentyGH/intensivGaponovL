package com.notificationdunice.intensivgaponovl.CommonKnowledgeSoftSkills;

public final class PersonImmutable {

    private final String name;
    private final int age;

    public PersonImmutable(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String greet() {
        return "Привет, меня зовут " + name + " и мне " + age + " лет.";
    }
}
