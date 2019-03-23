package com.example.grpc.future.server;

import com.example.grpc.Message;
import com.example.grpc.generated.MessageApiRpcGrpc;
import com.example.grpc.generated.MessageResponseRpc;
import com.example.grpc.generated.MessageRpc;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class FutureServer {

    public static void main(String[] args) {
        SpringApplication.run(FutureServer.class, args);
    }

}

@GRpcService
class FutureApiService extends MessageApiRpcGrpc.MessageApiRpcImplBase {

    @Override
    public void sendMessage(MessageRpc request, StreamObserver<MessageResponseRpc> responseObserver) {
        System.out.printf("%s", Message.ofRpc(request));

        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String uuid = UUID.randomUUID().toString();
        System.out.printf("Uuid : %s", uuid);

        responseObserver.onNext(MessageResponseRpc.newBuilder().setUuid(uuid).build());
        responseObserver.onCompleted();
    }

}
