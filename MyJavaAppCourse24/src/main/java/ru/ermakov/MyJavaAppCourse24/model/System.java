package ru.ermakov.MyJavaAppCourse24.model;

public enum System {
    ERP("Enterprise Resource Planning"),
    CRM("Customer Relationship Management"),
    WMS("Warehouse Management System");



    private final String name;
    System(String name) {
        this.name = name;

    }
}
