package com.example.webscokets.model;

import com.google.gson.annotations.SerializedName;

public class Message {
    private String from;
    private String content;
    @SerializedName("type")
    private MessageType type;

    @Override
    public String toString() {
        return super.toString();
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }


    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}