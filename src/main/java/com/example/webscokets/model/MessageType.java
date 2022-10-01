package com.example.webscokets.model;

import com.google.gson.annotations.SerializedName;

public enum MessageType {
    @SerializedName("content")
    CONTENT("content"),
    @SerializedName("disconnect")
    DISCONNECT("disconnect");

    private String text;

    MessageType(String text) {
        this.text = text;
    }
}
