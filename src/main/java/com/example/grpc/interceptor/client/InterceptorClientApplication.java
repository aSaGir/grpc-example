package com.example.grpc.interceptor.client;

import com.example.grpc.GrpcConstants;
import com.example.grpc.Message;
import com.example.grpc.generated.MessageApiRpcGrpc;
import io.grpc.*;

import static com.example.grpc.ChannelProvider.channel;

public class InterceptorClientApplication {

    public static void main(String[] args) {
        Message message = Message.of("Client", "Hello!");

        Context.current().withValue(GrpcConstants.LOCALE_CONTEXT_KEY, "en").run(() -> {
            MessageApiRpcGrpc.MessageApiRpcBlockingStub stub = MessageApiRpcGrpc.newBlockingStub(channel(new LocaleInterceptor()));
            stub.sendMessage(message.toRpc());
        });

        System.out.println("Request sent");
    }
}

class LocaleInterceptor implements ClientInterceptor {
    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions, Channel channel) {
        return new ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT>(channel.newCall(methodDescriptor, callOptions)) {
            @Override
            public void start(ClientCall.Listener<RespT> responseListener, Metadata headers) {
                if (GrpcConstants.LOCALE_CONTEXT_KEY.get() != null) {
                    headers.put(GrpcConstants.LOCALE_METADATA_KEY, GrpcConstants.LOCALE_CONTEXT_KEY.get());
                }
                super.start(responseListener, headers);
            }
        };
    }
}