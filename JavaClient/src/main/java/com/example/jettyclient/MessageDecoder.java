package com.example.jettyclient;

import com.google.gson.Gson;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class MessageDecoder implements Decoder.Text<Message> {

    private static Gson gson = new Gson();

    @Override
    public Message decode(String s) throws DecodeException {
        System.out.println("STRING ON DECODE " + s);
        Message message = null;
        try {
            message = gson.fromJson(s, Message.class);
        } catch (com.google.gson.JsonSyntaxException exception) {
            System.out.println("Other type of format received");
            Message errorMessage = new Message();
            errorMessage.setType(MessageType.UNDEFINED);
            return errorMessage;
        }
        return message;
    }

    @Override
    public boolean willDecode(String s) {
        return (s != null);
    }

    @Override
    public void init(EndpointConfig endpointConfig) {
        // Custom initialization logic
    }

    @Override
    public void destroy() {
        // Close resources
    }
}