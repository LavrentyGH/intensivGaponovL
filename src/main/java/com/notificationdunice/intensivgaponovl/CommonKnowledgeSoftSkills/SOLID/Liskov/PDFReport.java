package com.notificationdunice.intensivgaponovl.CommonKnowledgeSoftSkills.SOLID.Liskov;

class PDFReport extends Report {
    @Override
    public String generate() {
        return "PDF Report";
    }
}