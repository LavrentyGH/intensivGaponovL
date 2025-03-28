package com.notificationdunice.intensivgaponovl.CommonKnowledgeSoftSkills.SOLID.ISP;

public class Document implements Printable, Exportable{
    @Override
    public void export() {
        System.out.println("Exporting Document");
    }

    @Override
    public void print() {
        System.out.println("Printing Document");
    }
}
