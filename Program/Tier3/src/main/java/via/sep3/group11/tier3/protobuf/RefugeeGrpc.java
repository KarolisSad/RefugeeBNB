package via.sep3.group11.tier3.protobuf;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.39.0)",
    comments = "Source: Refugee.proto")
public final class RefugeeGrpc {

  private RefugeeGrpc() {}

  public static final String SERVICE_NAME = "Refugee";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<via.sep3.group11.tier3.protobuf.GRefugee,
      via.sep3.group11.tier3.protobuf.GRefugee> getCreateRefugeeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "createRefugee",
      requestType = via.sep3.group11.tier3.protobuf.GRefugee.class,
      responseType = via.sep3.group11.tier3.protobuf.GRefugee.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<via.sep3.group11.tier3.protobuf.GRefugee,
      via.sep3.group11.tier3.protobuf.GRefugee> getCreateRefugeeMethod() {
    io.grpc.MethodDescriptor<via.sep3.group11.tier3.protobuf.GRefugee, via.sep3.group11.tier3.protobuf.GRefugee> getCreateRefugeeMethod;
    if ((getCreateRefugeeMethod = RefugeeGrpc.getCreateRefugeeMethod) == null) {
      synchronized (RefugeeGrpc.class) {
        if ((getCreateRefugeeMethod = RefugeeGrpc.getCreateRefugeeMethod) == null) {
          RefugeeGrpc.getCreateRefugeeMethod = getCreateRefugeeMethod =
              io.grpc.MethodDescriptor.<via.sep3.group11.tier3.protobuf.GRefugee, via.sep3.group11.tier3.protobuf.GRefugee>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "createRefugee"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.group11.tier3.protobuf.GRefugee.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.group11.tier3.protobuf.GRefugee.getDefaultInstance()))
              .setSchemaDescriptor(new RefugeeMethodDescriptorSupplier("createRefugee"))
              .build();
        }
      }
    }
    return getCreateRefugeeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<via.sep3.group11.tier3.protobuf.GEmail,
      via.sep3.group11.tier3.protobuf.GRefugee> getGetRefugeeByEmailMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getRefugeeByEmail",
      requestType = via.sep3.group11.tier3.protobuf.GEmail.class,
      responseType = via.sep3.group11.tier3.protobuf.GRefugee.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<via.sep3.group11.tier3.protobuf.GEmail,
      via.sep3.group11.tier3.protobuf.GRefugee> getGetRefugeeByEmailMethod() {
    io.grpc.MethodDescriptor<via.sep3.group11.tier3.protobuf.GEmail, via.sep3.group11.tier3.protobuf.GRefugee> getGetRefugeeByEmailMethod;
    if ((getGetRefugeeByEmailMethod = RefugeeGrpc.getGetRefugeeByEmailMethod) == null) {
      synchronized (RefugeeGrpc.class) {
        if ((getGetRefugeeByEmailMethod = RefugeeGrpc.getGetRefugeeByEmailMethod) == null) {
          RefugeeGrpc.getGetRefugeeByEmailMethod = getGetRefugeeByEmailMethod =
              io.grpc.MethodDescriptor.<via.sep3.group11.tier3.protobuf.GEmail, via.sep3.group11.tier3.protobuf.GRefugee>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getRefugeeByEmail"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.group11.tier3.protobuf.GEmail.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.group11.tier3.protobuf.GRefugee.getDefaultInstance()))
              .setSchemaDescriptor(new RefugeeMethodDescriptorSupplier("getRefugeeByEmail"))
              .build();
        }
      }
    }
    return getGetRefugeeByEmailMethod;
  }

  private static volatile io.grpc.MethodDescriptor<via.sep3.group11.tier3.protobuf.GEmail,
      via.sep3.group11.tier3.protobuf.GEmpty> getDeleteAccountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteAccount",
      requestType = via.sep3.group11.tier3.protobuf.GEmail.class,
      responseType = via.sep3.group11.tier3.protobuf.GEmpty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<via.sep3.group11.tier3.protobuf.GEmail,
      via.sep3.group11.tier3.protobuf.GEmpty> getDeleteAccountMethod() {
    io.grpc.MethodDescriptor<via.sep3.group11.tier3.protobuf.GEmail, via.sep3.group11.tier3.protobuf.GEmpty> getDeleteAccountMethod;
    if ((getDeleteAccountMethod = RefugeeGrpc.getDeleteAccountMethod) == null) {
      synchronized (RefugeeGrpc.class) {
        if ((getDeleteAccountMethod = RefugeeGrpc.getDeleteAccountMethod) == null) {
          RefugeeGrpc.getDeleteAccountMethod = getDeleteAccountMethod =
              io.grpc.MethodDescriptor.<via.sep3.group11.tier3.protobuf.GEmail, via.sep3.group11.tier3.protobuf.GEmpty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteAccount"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.group11.tier3.protobuf.GEmail.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.group11.tier3.protobuf.GEmpty.getDefaultInstance()))
              .setSchemaDescriptor(new RefugeeMethodDescriptorSupplier("deleteAccount"))
              .build();
        }
      }
    }
    return getDeleteAccountMethod;
  }

  private static volatile io.grpc.MethodDescriptor<via.sep3.group11.tier3.protobuf.GRefugee,
      via.sep3.group11.tier3.protobuf.GRefugee> getUpdateInformationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateInformation",
      requestType = via.sep3.group11.tier3.protobuf.GRefugee.class,
      responseType = via.sep3.group11.tier3.protobuf.GRefugee.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<via.sep3.group11.tier3.protobuf.GRefugee,
      via.sep3.group11.tier3.protobuf.GRefugee> getUpdateInformationMethod() {
    io.grpc.MethodDescriptor<via.sep3.group11.tier3.protobuf.GRefugee, via.sep3.group11.tier3.protobuf.GRefugee> getUpdateInformationMethod;
    if ((getUpdateInformationMethod = RefugeeGrpc.getUpdateInformationMethod) == null) {
      synchronized (RefugeeGrpc.class) {
        if ((getUpdateInformationMethod = RefugeeGrpc.getUpdateInformationMethod) == null) {
          RefugeeGrpc.getUpdateInformationMethod = getUpdateInformationMethod =
              io.grpc.MethodDescriptor.<via.sep3.group11.tier3.protobuf.GRefugee, via.sep3.group11.tier3.protobuf.GRefugee>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateInformation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.group11.tier3.protobuf.GRefugee.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.group11.tier3.protobuf.GRefugee.getDefaultInstance()))
              .setSchemaDescriptor(new RefugeeMethodDescriptorSupplier("updateInformation"))
              .build();
        }
      }
    }
    return getUpdateInformationMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RefugeeStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RefugeeStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RefugeeStub>() {
        @java.lang.Override
        public RefugeeStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RefugeeStub(channel, callOptions);
        }
      };
    return RefugeeStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RefugeeBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RefugeeBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RefugeeBlockingStub>() {
        @java.lang.Override
        public RefugeeBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RefugeeBlockingStub(channel, callOptions);
        }
      };
    return RefugeeBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RefugeeFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RefugeeFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RefugeeFutureStub>() {
        @java.lang.Override
        public RefugeeFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RefugeeFutureStub(channel, callOptions);
        }
      };
    return RefugeeFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class RefugeeImplBase implements io.grpc.BindableService {

    /**
     */
    public void createRefugee(via.sep3.group11.tier3.protobuf.GRefugee request,
        io.grpc.stub.StreamObserver<via.sep3.group11.tier3.protobuf.GRefugee> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateRefugeeMethod(), responseObserver);
    }

    /**
     */
    public void getRefugeeByEmail(via.sep3.group11.tier3.protobuf.GEmail request,
        io.grpc.stub.StreamObserver<via.sep3.group11.tier3.protobuf.GRefugee> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetRefugeeByEmailMethod(), responseObserver);
    }

    /**
     */
    public void deleteAccount(via.sep3.group11.tier3.protobuf.GEmail request,
        io.grpc.stub.StreamObserver<via.sep3.group11.tier3.protobuf.GEmpty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteAccountMethod(), responseObserver);
    }

    /**
     */
    public void updateInformation(via.sep3.group11.tier3.protobuf.GRefugee request,
        io.grpc.stub.StreamObserver<via.sep3.group11.tier3.protobuf.GRefugee> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateInformationMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateRefugeeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                via.sep3.group11.tier3.protobuf.GRefugee,
                via.sep3.group11.tier3.protobuf.GRefugee>(
                  this, METHODID_CREATE_REFUGEE)))
          .addMethod(
            getGetRefugeeByEmailMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                via.sep3.group11.tier3.protobuf.GEmail,
                via.sep3.group11.tier3.protobuf.GRefugee>(
                  this, METHODID_GET_REFUGEE_BY_EMAIL)))
          .addMethod(
            getDeleteAccountMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                via.sep3.group11.tier3.protobuf.GEmail,
                via.sep3.group11.tier3.protobuf.GEmpty>(
                  this, METHODID_DELETE_ACCOUNT)))
          .addMethod(
            getUpdateInformationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                via.sep3.group11.tier3.protobuf.GRefugee,
                via.sep3.group11.tier3.protobuf.GRefugee>(
                  this, METHODID_UPDATE_INFORMATION)))
          .build();
    }
  }

  /**
   */
  public static final class RefugeeStub extends io.grpc.stub.AbstractAsyncStub<RefugeeStub> {
    private RefugeeStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RefugeeStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RefugeeStub(channel, callOptions);
    }

    /**
     */
    public void createRefugee(via.sep3.group11.tier3.protobuf.GRefugee request,
        io.grpc.stub.StreamObserver<via.sep3.group11.tier3.protobuf.GRefugee> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateRefugeeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getRefugeeByEmail(via.sep3.group11.tier3.protobuf.GEmail request,
        io.grpc.stub.StreamObserver<via.sep3.group11.tier3.protobuf.GRefugee> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetRefugeeByEmailMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteAccount(via.sep3.group11.tier3.protobuf.GEmail request,
        io.grpc.stub.StreamObserver<via.sep3.group11.tier3.protobuf.GEmpty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAccountMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateInformation(via.sep3.group11.tier3.protobuf.GRefugee request,
        io.grpc.stub.StreamObserver<via.sep3.group11.tier3.protobuf.GRefugee> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateInformationMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RefugeeBlockingStub extends io.grpc.stub.AbstractBlockingStub<RefugeeBlockingStub> {
    private RefugeeBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RefugeeBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RefugeeBlockingStub(channel, callOptions);
    }

    /**
     */
    public via.sep3.group11.tier3.protobuf.GRefugee createRefugee(via.sep3.group11.tier3.protobuf.GRefugee request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateRefugeeMethod(), getCallOptions(), request);
    }

    /**
     */
    public via.sep3.group11.tier3.protobuf.GRefugee getRefugeeByEmail(via.sep3.group11.tier3.protobuf.GEmail request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRefugeeByEmailMethod(), getCallOptions(), request);
    }

    /**
     */
    public via.sep3.group11.tier3.protobuf.GEmpty deleteAccount(via.sep3.group11.tier3.protobuf.GEmail request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAccountMethod(), getCallOptions(), request);
    }

    /**
     */
    public via.sep3.group11.tier3.protobuf.GRefugee updateInformation(via.sep3.group11.tier3.protobuf.GRefugee request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateInformationMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RefugeeFutureStub extends io.grpc.stub.AbstractFutureStub<RefugeeFutureStub> {
    private RefugeeFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RefugeeFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RefugeeFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<via.sep3.group11.tier3.protobuf.GRefugee> createRefugee(
        via.sep3.group11.tier3.protobuf.GRefugee request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateRefugeeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<via.sep3.group11.tier3.protobuf.GRefugee> getRefugeeByEmail(
        via.sep3.group11.tier3.protobuf.GEmail request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetRefugeeByEmailMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<via.sep3.group11.tier3.protobuf.GEmpty> deleteAccount(
        via.sep3.group11.tier3.protobuf.GEmail request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAccountMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<via.sep3.group11.tier3.protobuf.GRefugee> updateInformation(
        via.sep3.group11.tier3.protobuf.GRefugee request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateInformationMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_REFUGEE = 0;
  private static final int METHODID_GET_REFUGEE_BY_EMAIL = 1;
  private static final int METHODID_DELETE_ACCOUNT = 2;
  private static final int METHODID_UPDATE_INFORMATION = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RefugeeImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RefugeeImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_REFUGEE:
          serviceImpl.createRefugee((via.sep3.group11.tier3.protobuf.GRefugee) request,
              (io.grpc.stub.StreamObserver<via.sep3.group11.tier3.protobuf.GRefugee>) responseObserver);
          break;
        case METHODID_GET_REFUGEE_BY_EMAIL:
          serviceImpl.getRefugeeByEmail((via.sep3.group11.tier3.protobuf.GEmail) request,
              (io.grpc.stub.StreamObserver<via.sep3.group11.tier3.protobuf.GRefugee>) responseObserver);
          break;
        case METHODID_DELETE_ACCOUNT:
          serviceImpl.deleteAccount((via.sep3.group11.tier3.protobuf.GEmail) request,
              (io.grpc.stub.StreamObserver<via.sep3.group11.tier3.protobuf.GEmpty>) responseObserver);
          break;
        case METHODID_UPDATE_INFORMATION:
          serviceImpl.updateInformation((via.sep3.group11.tier3.protobuf.GRefugee) request,
              (io.grpc.stub.StreamObserver<via.sep3.group11.tier3.protobuf.GRefugee>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class RefugeeBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RefugeeBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return via.sep3.group11.tier3.protobuf.RefugeeOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Refugee");
    }
  }

  private static final class RefugeeFileDescriptorSupplier
      extends RefugeeBaseDescriptorSupplier {
    RefugeeFileDescriptorSupplier() {}
  }

  private static final class RefugeeMethodDescriptorSupplier
      extends RefugeeBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RefugeeMethodDescriptorSupplier(String methodName) {
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
      synchronized (RefugeeGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RefugeeFileDescriptorSupplier())
              .addMethod(getCreateRefugeeMethod())
              .addMethod(getGetRefugeeByEmailMethod())
              .addMethod(getDeleteAccountMethod())
              .addMethod(getUpdateInformationMethod())
              .build();
        }
      }
    }
    return result;
  }
}
