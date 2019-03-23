package com.example.grpc;

import com.example.grpc.generated.MessageRpc;

import java.util.Formattable;
import java.util.Formatter;

public class Message implements Formattable {

    private String user;
    private String message;

    private Message(String user, String message) {
        this.user = user;
        this.message = message;
    }

    public static Message ofRpc(MessageRpc rpc) {
        return new Message(rpc.getUser(), rpc.getMessage());
    }

    public static Message of(String user, String message) {
        return new Message(user, message);
    }

    public String getUser() {
        return user;
    }

    public String getMessage() {
        return message;
    }

    public MessageRpc toRpc() {
        return MessageRpc.newBuilder().setUser(user).setMessage(message).build();
    }

    @Override
    public void formatTo(Formatter formatter, int flags, int width, int precision) {
        formatter.format("Retrieved message: %s from: %s", message, user);
    }
}
