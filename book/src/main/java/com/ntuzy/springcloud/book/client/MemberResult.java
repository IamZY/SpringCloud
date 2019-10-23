package com.ntuzy.springcloud.book.client;

public class MemberResult {

    private String code;
    private String message;
    private MemberDTO data;

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

    public MemberDTO getData() {
        return data;
    }

    public void setData(MemberDTO data) {
        this.data = data;
    }
}
