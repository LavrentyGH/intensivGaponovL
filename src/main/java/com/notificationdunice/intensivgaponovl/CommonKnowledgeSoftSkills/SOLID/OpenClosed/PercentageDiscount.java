package com.notificationdunice.intensivgaponovl.CommonKnowledgeSoftSkills.SOLID.OpenClosed;

class PercentageDiscount implements DiscountStrategy {
    private final double percent;

    public PercentageDiscount(double percent) {
        this.percent = percent;
    }

    public double applyDiscount(double price) {
        return price * (1 - percent / 100);
    }
}
