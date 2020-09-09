package com.wynlo.wrappers;

import java.util.Date;
import java.sql.Timestamp;

public class ResponseEntityModelWrapper<E> {

    private String timestamp = new Timestamp(new Date().getTime()).toString();
    private E data;

    public ResponseEntityModelWrapper(E data) {
        this.data = data;
    }

    public ResponseEntityModelWrapper(E data, String timestamp) {
        this.data = data;
        this.timestamp = timestamp;
    }

    public static <E> ResponseEntityModelWrapper<E> build(E data) {
        return new ResponseEntityModelWrapper<E>(data);
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
