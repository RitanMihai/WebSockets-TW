package com.example.jettyclient;

import com.google.gson.annotations.SerializedName;

public enum MessageType {
    @SerializedName("content")
    CONTENT("content"),
    @SerializedName("disconnect")
    DISCONNECT("disconnect"),
    @SerializedName("undefined")
    UNDEFINED("undefined");


    private String text;

    MessageType(String text) {
        this.text = text;
    }
}
