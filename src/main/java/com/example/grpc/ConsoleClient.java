package com.example.grpc;

import com.example.grpc.generated.MessageRpc;
import io.grpc.stub.StreamObserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleClient implements Runnable {
    private StreamObserver<MessageRpc> streamObserver;
    private String user;

    private ConsoleClient(StreamObserver<MessageRpc> streamObserver, String user) {
        this.streamObserver = streamObserver;
        this.user = user;
    }

    public static ConsoleClient of(StreamObserver<MessageRpc> streamObserver, String user) {
        return new ConsoleClient(streamObserver, user);
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        do {
            try {
                String message = reader.readLine();
                streamObserver.onNext(Message.of(user, message).toRpc());
            } catch (IOException e) {
                streamObserver.onError(e);
            }
        } while (true);
    }
}