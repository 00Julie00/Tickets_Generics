package ru.netology.javaqa.javaqamvn.generics.exeptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String s) {
        super(s);
    }
}
