package com.example.grpc.stream.client;

import com.example.grpc.ConsoleClient;
import com.example.grpc.Message;
import com.example.grpc.generated.MessageApiRpcGrpc;
import com.example.grpc.generated.MessageRpc;
import io.grpc.stub.StreamObserver;

import static com.example.grpc.ChannelProvider.channel;
import static com.example.grpc.ExceptionPrinter.printError;


public class StreamStubClientApplication {

    public static void main(String[] args) throws InterruptedException {
        MessageApiRpcGrpc.MessageApiRpcStub stub = MessageApiRpcGrpc.newStub(channel());

        StreamObserver<MessageRpc> responseStream = stub.messageStream(new StreamObserver<MessageRpc>() {
            @Override
            public void onNext(MessageRpc value) {
                System.out.printf("\nClient side: %s\n", Message.ofRpc(value));
            }

            @Override
            public void onError(Throwable t) {
                printError(t, "Client");
            }

            @Override
            public void onCompleted() {
                System.out.println("Reqeust was completed ");
            }
        });

        ConsoleClient consoleClient = ConsoleClient.of(responseStream, "Client");
        Thread thread = new Thread(consoleClient);
        thread.start();
        thread.join();
    }

}