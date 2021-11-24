package com.ordersystem.entity;

import java.io.Serializable;

/**
 * (Notice)实体类
 *
 * @author makejava
 * @since 2021-07-25 01:09:05
 */
public class Notice implements Serializable {
    private static final long serialVersionUID = 566163925648719184L;

    private String id;

    private String text;



    private String publisher;


    private int status;

    public Notice(String id, String text, String publisher, int status) {
        this.id = id;
        this.text = text;
        this.publisher = publisher;
        this.status = status;
    }

    public Notice(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
