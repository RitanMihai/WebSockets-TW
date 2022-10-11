package com.example.jettyclient;

import com.google.gson.annotations.SerializedName;

public class Message {
    @Override
    public String toString() {
        return "Message{" +
                "from='" + from + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    private String from;
    private String content;
    @SerializedName("type")
    private MessageType type = MessageType.CONTENT; /* Default value */

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