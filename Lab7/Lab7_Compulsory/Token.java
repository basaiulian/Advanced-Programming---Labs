package com.company.lab7.compulsory;

public class Token {
    private int value;

    public Token(int value) {
        this.value = value;

    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Token{" +
                "value=" + value +
                '}';
    }
}
