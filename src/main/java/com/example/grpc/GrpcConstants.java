package com.example.grpc;

import io.grpc.Context;
import io.grpc.Metadata;

import static io.grpc.Metadata.ASCII_STRING_MARSHALLER;

public interface GrpcConstants {
    Metadata.Key<String> CRED_AUTH = Metadata.Key.of("cred_auth", ASCII_STRING_MARSHALLER);
    Metadata.Key<String> LOCALE_METADATA_KEY = Metadata.Key.of("owner_uuid_meta", ASCII_STRING_MARSHALLER);
    Context.Key<String> LOCALE_CONTEXT_KEY = Context.key("owner_uuid");
}
