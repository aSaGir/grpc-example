package com.example.grpc.error.handling.server;

import com.example.grpc.Message;
import com.example.grpc.generated.ExceptionDetails;
import com.example.grpc.generated.MessageApiRpcGrpc;
import com.example.grpc.generated.MessageResponseRpc;
import com.example.grpc.generated.MessageRpc;
import com.google.protobuf.Any;
import com.google.rpc.Status;
import io.grpc.protobuf.StatusProto;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ErrorHandlingServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ErrorHandlingServerApplication.class, args);
    }
}

@GRpcService
class MessageApiService extends MessageApiRpcGrpc.MessageApiRpcImplBase{

    @Override
    public void sendMessage(MessageRpc request, StreamObserver<MessageResponseRpc> responseObserver) {
        System.out.printf("%s", Message.ofRpc(request));

        ExceptionDetails exception = ExceptionDetails.newBuilder()
                .setStatus(404)
                .setCode("resource.not.found")
                .addParams("first param")
                .addParams("second param")
                .build();

        Status status = Status.newBuilder()
                .setCode(2)
                .setMessage("Email or password malformed")
                .addDetails(Any.pack(exception))
                .build();

        responseObserver.onError(StatusProto.toStatusRuntimeException(status));
        responseObserver.onCompleted();
    }
}
