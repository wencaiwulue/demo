package com.test.demo.model;

/**
 * @author naison
 * @since 3/3/2020 15:01
 */
public class CResponse<T> {
    private Integer code;
    private String message;
    private T data;

    public CResponse(T data) {
        this.data = data;
        this.code = 200;
    }

    public CResponse(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> CResponse<T> of(T data) {
        return new CResponse<>(data);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
