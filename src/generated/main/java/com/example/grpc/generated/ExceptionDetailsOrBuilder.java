// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: MessageApi.proto

package com.example.grpc.generated;

public interface ExceptionDetailsOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ExceptionDetails)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 status = 1;</code>
   */
  int getStatus();

  /**
   * <code>string code = 2;</code>
   */
  java.lang.String getCode();
  /**
   * <code>string code = 2;</code>
   */
  com.google.protobuf.ByteString
      getCodeBytes();

  /**
   * <code>repeated string params = 3;</code>
   */
  java.util.List<java.lang.String>
      getParamsList();
  /**
   * <code>repeated string params = 3;</code>
   */
  int getParamsCount();
  /**
   * <code>repeated string params = 3;</code>
   */
  java.lang.String getParams(int index);
  /**
   * <code>repeated string params = 3;</code>
   */
  com.google.protobuf.ByteString
      getParamsBytes(int index);
}
