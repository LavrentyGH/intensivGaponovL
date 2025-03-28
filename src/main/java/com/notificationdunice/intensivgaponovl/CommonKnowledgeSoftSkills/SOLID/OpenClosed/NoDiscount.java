package com.notificationdunice.intensivgaponovl.CommonKnowledgeSoftSkills.SOLID.OpenClosed;

class NoDiscount implements DiscountStrategy {
    public double applyDiscount(double price) {
        return price;
    }
}
