package ru.ermakov.MyJavaAppCourse22.exception;

public class ValidationFailedException extends Exception {
    public ValidationFailedException(String message){
        super(message);
    }
}
