package com.example.grpc.error.handling.client;

import com.example.grpc.Message;
import com.example.grpc.generated.MessageApiRpcGrpc;

import static com.example.grpc.ChannelProvider.channel;
import static com.example.grpc.ExceptionPrinter.printError;

public class InterceptorClientApplication {

    public static void main(String[] args) {
        Message message = Message.of("Client", "Hello!");
        MessageApiRpcGrpc.MessageApiRpcBlockingStub stub = MessageApiRpcGrpc.newBlockingStub(channel());

        try {
            stub.sendMessage(message.toRpc());
        } catch (Throwable t) {
            printError(t, "Client");
        }
    }
}