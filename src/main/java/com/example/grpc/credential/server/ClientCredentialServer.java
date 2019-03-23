package com.example.grpc.credential.server;

import com.example.grpc.Message;
import com.example.grpc.generated.MessageApiRpcGrpc;
import com.example.grpc.generated.MessageResponseRpc;
import com.example.grpc.generated.MessageRpc;
import io.grpc.*;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.UUID;

import static com.example.grpc.GrpcConstants.CRED_AUTH;

@SpringBootApplication
public class ClientCredentialServer {
    public static void main(String[] args) {
        SpringApplication.run(ClientCredentialServer.class, args);
    }
}

@GRpcService(interceptors = {OwnerInterceptor.class})
class ClientCredentialApiService extends MessageApiRpcGrpc.MessageApiRpcImplBase {
    @Override
    public void sendMessage(MessageRpc request, StreamObserver<MessageResponseRpc> responseObserver) {
        System.out.printf("Server side: %s", Message.ofRpc(request));

        String uuid = UUID.randomUUID().toString();
        System.out.println("Uuid : " + uuid);

        responseObserver.onNext(MessageResponseRpc.newBuilder().setUuid(uuid).build());
        responseObserver.onCompleted();
    }
}

@Component
class OwnerInterceptor implements ServerInterceptor {
    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call, Metadata headers, ServerCallHandler<ReqT, RespT> next) {
        String cred = headers.get(CRED_AUTH);
        if (cred != null && !cred.equals("John Doe")) {
            throw new RuntimeException("User incorrect");
        }
        return next.startCall(new ForwardingServerCall.SimpleForwardingServerCall<ReqT, RespT>(call) {
        }, headers);
    }
}

