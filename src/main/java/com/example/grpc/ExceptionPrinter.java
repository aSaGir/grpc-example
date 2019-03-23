package com.example.grpc;

import com.example.grpc.generated.ExceptionDetails;
import com.google.rpc.Status;
import io.grpc.protobuf.StatusProto;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

import static com.example.grpc.WrapException.apply;

public class ExceptionPrinter {

    public static void printError(Throwable throwable, String user) {
        Status status = StatusProto.fromThrowable(throwable);

        Optional.ofNullable(status)
                .filter(it -> it.getDetailsList().size() > 0)
                .map(it -> it.getDetails(0))
                .map(apply(it -> it.unpack(ExceptionDetails.class)))
                .ifPresent(it -> System.out.println("\nUser: '" + user + "' \nException: \n" + it.toString()));

        System.out.println("User: " + user + " exception: " + Objects.requireNonNull(throwable).toString());
    }

}

class WrapException {
    static <T, R> Function<T, R> apply(ExceptionFunction<T, R> function) {
        return it -> {
            try {
                return function.apply(it);
            } catch (Throwable t) {
                throw new RuntimeException(t);
            }
        };
    }
}

@FunctionalInterface
interface ExceptionFunction<T, R> {
    R apply(T t) throws Throwable;
}