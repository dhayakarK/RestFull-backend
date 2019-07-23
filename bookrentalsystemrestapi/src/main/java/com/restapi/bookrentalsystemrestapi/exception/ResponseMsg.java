package com.restapi.bookrentalsystemrestapi.exception;

public class ResponseMsg {
    private int statuscode;
    private String message;

    public ResponseMsg() {
        super();
    }

    public ResponseMsg(int statuscode, String message) {
        this.statuscode = statuscode;
        this.message = message;
    }

    public int getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(int statuscode) {
        this.statuscode = statuscode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
