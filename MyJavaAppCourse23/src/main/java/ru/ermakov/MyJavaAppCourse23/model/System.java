package ru.ermakov.MyJavaAppCourse23.model;

public enum System {
    ERP("Enterprise Resource Planning"),
    CRM("Customer Relationship Management"),
    WMS("Warehouse Management System");



    private final String name;
    System(String name) {
        this.name = name;

    }
}
