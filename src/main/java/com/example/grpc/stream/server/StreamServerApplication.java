package com.example.grpc.stream.server;

import com.example.grpc.ConsoleClient;
import com.example.grpc.Message;
import com.example.grpc.generated.MessageApiRpcGrpc;
import com.example.grpc.generated.MessageRpc;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.example.grpc.ExceptionPrinter.printError;

@SpringBootApplication
public class StreamServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(StreamServerApplication.class, args);
    }
}

@GRpcService
class ProfileApiService extends MessageApiRpcGrpc.MessageApiRpcImplBase {

    @Override
    public StreamObserver<MessageRpc> messageStream(StreamObserver<MessageRpc> responseObserver) {
        StreamObserver<MessageRpc> responseStream = new StreamObserver<MessageRpc>() {
            @Override
            public void onNext(MessageRpc value) {
                System.out.printf("\nServer side: %s\n", Message.ofRpc(value));
            }

            @Override
            public void onError(Throwable t) {
                printError(t, "Server");
            }

            @Override
            public void onCompleted() {
                System.out.println("Reqeust was completed ");
            }
        };

        ConsoleClient consoleClient = ConsoleClient.of(responseObserver, "Server");

        new Thread(consoleClient).start();

        return responseStream;
    }
}


