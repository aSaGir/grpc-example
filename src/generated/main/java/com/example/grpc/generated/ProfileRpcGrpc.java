package com.example.grpc.generated;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.7.0)",
    comments = "Source: Profile.proto")
public final class ProfileRpcGrpc {

  private ProfileRpcGrpc() {}

  public static final String SERVICE_NAME = "ProfileRpc";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<MessageRpc,
          MessageResponseRpc> METHOD_SEND_MESSAGE =
      io.grpc.MethodDescriptor.<MessageRpc, MessageResponseRpc>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "ProfileRpc", "sendMessage"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              MessageRpc.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              MessageResponseRpc.getDefaultInstance()))
          .setSchemaDescriptor(new ProfileRpcMethodDescriptorSupplier("sendMessage"))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<MessageRpc,
          MessageRpc> METHOD_MESSAGE_STREAM =
      io.grpc.MethodDescriptor.<MessageRpc, MessageRpc>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "ProfileRpc", "messageStream"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              MessageRpc.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              MessageRpc.getDefaultInstance()))
          .setSchemaDescriptor(new ProfileRpcMethodDescriptorSupplier("messageStream"))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ProfileRpcStub newStub(io.grpc.Channel channel) {
    return new ProfileRpcStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProfileRpcBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ProfileRpcBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ProfileRpcFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ProfileRpcFutureStub(channel);
  }

  /**
   */
  public static abstract class ProfileRpcImplBase implements io.grpc.BindableService {

    /**
     */
    public void sendMessage(MessageRpc request,
                            io.grpc.stub.StreamObserver<MessageResponseRpc> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SEND_MESSAGE, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<MessageRpc> messageStream(
        io.grpc.stub.StreamObserver<MessageRpc> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_MESSAGE_STREAM, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_SEND_MESSAGE,
            asyncUnaryCall(
              new MethodHandlers<
                      MessageRpc,
                      MessageResponseRpc>(
                  this, METHODID_SEND_MESSAGE)))
          .addMethod(
            METHOD_MESSAGE_STREAM,
            asyncBidiStreamingCall(
              new MethodHandlers<
                      MessageRpc,
                      MessageRpc>(
                  this, METHODID_MESSAGE_STREAM)))
          .build();
    }
  }

  /**
   */
  public static final class ProfileRpcStub extends io.grpc.stub.AbstractStub<ProfileRpcStub> {
    private ProfileRpcStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ProfileRpcStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProfileRpcStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ProfileRpcStub(channel, callOptions);
    }

    /**
     */
    public void sendMessage(MessageRpc request,
                            io.grpc.stub.StreamObserver<MessageResponseRpc> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SEND_MESSAGE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<MessageRpc> messageStream(
        io.grpc.stub.StreamObserver<MessageRpc> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(METHOD_MESSAGE_STREAM, getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class ProfileRpcBlockingStub extends io.grpc.stub.AbstractStub<ProfileRpcBlockingStub> {
    private ProfileRpcBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ProfileRpcBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProfileRpcBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ProfileRpcBlockingStub(channel, callOptions);
    }

    /**
     */
    public MessageResponseRpc sendMessage(MessageRpc request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SEND_MESSAGE, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ProfileRpcFutureStub extends io.grpc.stub.AbstractStub<ProfileRpcFutureStub> {
    private ProfileRpcFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ProfileRpcFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProfileRpcFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ProfileRpcFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<MessageResponseRpc> sendMessage(
        MessageRpc request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SEND_MESSAGE, getCallOptions()), request);
    }
  }

  private static final int METHODID_SEND_MESSAGE = 0;
  private static final int METHODID_MESSAGE_STREAM = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ProfileRpcImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ProfileRpcImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_MESSAGE:
          serviceImpl.sendMessage((MessageRpc) request,
              (io.grpc.stub.StreamObserver<MessageResponseRpc>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_MESSAGE_STREAM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.messageStream(
              (io.grpc.stub.StreamObserver<MessageRpc>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ProfileRpcBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ProfileRpcBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ProfileApi.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ProfileRpc");
    }
  }

  private static final class ProfileRpcFileDescriptorSupplier
      extends ProfileRpcBaseDescriptorSupplier {
    ProfileRpcFileDescriptorSupplier() {}
  }

  private static final class ProfileRpcMethodDescriptorSupplier
      extends ProfileRpcBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ProfileRpcMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ProfileRpcGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ProfileRpcFileDescriptorSupplier())
              .addMethod(METHOD_SEND_MESSAGE)
              .addMethod(METHOD_MESSAGE_STREAM)
              .build();
        }
      }
    }
    return result;
  }
}
