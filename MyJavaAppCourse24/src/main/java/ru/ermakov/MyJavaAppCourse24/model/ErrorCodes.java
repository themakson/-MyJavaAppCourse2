package ru.ermakov.MyJavaAppCourse24.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ErrorCodes {

    EMPTY(""),
    VALIDATON_EXCEPTION("ValidatonException"),
    UNKNOWN_EXCEPTION("UnknownException"),
    UNSUPPORTED_EXCEPTION("UnsupportedException");

    private final String name;

    ErrorCodes(String name) {
        this.name = name;
    }

    @JsonValue
    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}