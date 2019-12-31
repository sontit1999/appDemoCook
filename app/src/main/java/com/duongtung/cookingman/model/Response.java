package com.duongtung.cookingman.model;

public class Response {
    String status;
    String link;

    public Response(String status, String link) {
        this.status = status;
        this.link = link;
    }

    public Response() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
