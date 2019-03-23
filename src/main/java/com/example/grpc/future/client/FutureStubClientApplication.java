package com.example.grpc.future.client;

import com.example.grpc.Message;
import com.example.grpc.generated.MessageApiRpcGrpc;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import com.example.grpc.generated.MessageResponseRpc;

import javax.annotation.Nullable;

import static com.example.grpc.ChannelProvider.channel;
import static com.example.grpc.ExceptionPrinter.printError;
import static com.google.common.util.concurrent.Futures.addCallback;

public class FutureStubClientApplication {

    public static void main(String[] args) throws InterruptedException {
        MessageApiRpcGrpc.MessageApiRpcFutureStub stub = MessageApiRpcGrpc.newFutureStub(channel());

        ListenableFuture<MessageResponseRpc> future = stub.sendMessage(Message.of("Client", "Hello!").toRpc());

        addCallback(future, new FutureCallback<MessageResponseRpc>() {
            @Override
            public void onSuccess(@Nullable MessageResponseRpc result) {
                System.out.println("Response: " + result);
            }

            @Override
            public void onFailure(Throwable t) {
                printError(t, "Client");
            }
        });

        System.out.println("Request sent");

        Thread.sleep(15_000);
    }
}