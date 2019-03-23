package com.example.grpc.interceptor.server;

import com.example.grpc.GrpcConstants;
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

import static com.example.grpc.GrpcConstants.LOCALE_METADATA_KEY;

@SpringBootApplication
public class InterceptorServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(InterceptorServerApplication.class, args);
    }
}

@GRpcService(interceptors = {LocaleServerInterceptor.class})
class ProfileApiService extends MessageApiRpcGrpc.MessageApiRpcImplBase {
    @Override
    public void sendMessage(MessageRpc request, StreamObserver<MessageResponseRpc> responseObserver) {
        System.out.printf("\nServer side: %s\n", Message.ofRpc(request));

        System.out.println("\nLocale: " + LocaleHolder.getLocale());

        String uuid = UUID.randomUUID().toString();
        System.out.println("\nUuid : " + uuid);

        responseObserver.onNext(MessageResponseRpc.newBuilder().setUuid(uuid).build());
        responseObserver.onCompleted();
    }
}

class LocaleHolder {
    static String getLocale() {
        return GrpcConstants.LOCALE_CONTEXT_KEY.get();
    }
}

@Component
class LocaleServerInterceptor implements ServerInterceptor {
    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call, Metadata headers, ServerCallHandler<ReqT, RespT> next) {
        String ownerUuid = headers.get(LOCALE_METADATA_KEY);
        Context ctx = Context.current().withValue(GrpcConstants.LOCALE_CONTEXT_KEY, ownerUuid);
        return Contexts.interceptCall(ctx, call, headers, next);
    }
}
