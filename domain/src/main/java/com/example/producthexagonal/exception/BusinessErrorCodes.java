package com.example.producthexagonal.exception;

public enum BusinessErrorCodes {

    PRODUCT_NOT_FOUND("PRODUCT_NOT_FOUND", "PRODUCT not found"),
    ;


    private final String code;
    private final String message;

    BusinessErrorCodes(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String code() {
        return code;
    }

    public String message() {
        return message;
    }
}
