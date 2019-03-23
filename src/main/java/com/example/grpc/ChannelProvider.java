package com.example.grpc;

import io.grpc.ClientInterceptor;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Optional;

public class ChannelProvider {
    private ChannelProvider(){}

    public static ManagedChannel channel() {
        return channel(null);
    }

    public static ManagedChannel channel(ClientInterceptor interceptor) {
        ManagedChannelBuilder<?> builder = ManagedChannelBuilder.forAddress("localhost", 8090)
                .usePlaintext(true);
        Optional.ofNullable(interceptor).ifPresent(builder::intercept);
        return builder.build();
    }
}
