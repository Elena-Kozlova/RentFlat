package com.rentflat.controller.model.response;

/**
 * Error Enum.
 */
public enum ErrorEnum {

    //Runtime exception
    E0001("Runtime Exception");

    private String message;

    ErrorEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
