package com.example.grpc;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ResponseStatus(value = NOT_FOUND, reason = "message.not.found")
public class MessageNotFound extends RuntimeException {

    private String reason;

    public MessageNotFound(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return reason;
    }
}
