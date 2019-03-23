package com.example.grpc.credential.client;

import com.example.grpc.Message;
import com.example.grpc.generated.MessageApiRpcGrpc;
import io.grpc.*;

import java.util.concurrent.Executor;

import static com.example.grpc.ChannelProvider.channel;
import static com.example.grpc.GrpcConstants.CRED_AUTH;

public class ClientCredentialClientApplication {

    public static void main(String[] args) {
        MessageApiRpcGrpc.MessageApiRpcBlockingStub stub = MessageApiRpcGrpc.newBlockingStub(channel());

        Message message = Message.of("Client", "Hello!");

        stub.withCallCredentials(new LocalClientCredential()).sendMessage(message.toRpc());

        System.out.println("Request sent");
    }
}

class LocalClientCredential implements CallCredentials {
    @Override
    public void applyRequestMetadata(MethodDescriptor<?, ?> method, Attributes attrs, Executor appExecutor, MetadataApplier applier) {
        appExecutor.execute(() -> {
            try {
                Metadata headers = new Metadata();
                headers.put(CRED_AUTH, "John Doe");
                applier.apply(headers);
            } catch (Throwable e) {
                applier.fail(Status.UNAUTHENTICATED.withCause(e));
            }
        });
    }

    @Override
    public void thisUsesUnstableApi() {
    }
}