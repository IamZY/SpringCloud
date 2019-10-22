package com.ntuzy.springcloud.member.client;

public class RestResult {
    private String code;
    private String message;
    private BookDTO data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BookDTO getData() {
        return data;
    }

    public void setData(BookDTO data) {
        this.data = data;
    }
}
