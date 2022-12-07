package via.sep3.group11.tier2.protobuf;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.39.0)",
    comments = "Source: Host.proto")
public final class HostGrpc {

  private HostGrpc() {}

  public static final String SERVICE_NAME = "Host";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<via.sep3.group11.tier2.protobuf.GHost,
      via.sep3.group11.tier2.protobuf.GHost> getCreateHostMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateHost",
      requestType = via.sep3.group11.tier2.protobuf.GHost.class,
      responseType = via.sep3.group11.tier2.protobuf.GHost.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<via.sep3.group11.tier2.protobuf.GHost,
      via.sep3.group11.tier2.protobuf.GHost> getCreateHostMethod() {
    io.grpc.MethodDescriptor<via.sep3.group11.tier2.protobuf.GHost, via.sep3.group11.tier2.protobuf.GHost> getCreateHostMethod;
    if ((getCreateHostMethod = HostGrpc.getCreateHostMethod) == null) {
      synchronized (HostGrpc.class) {
        if ((getCreateHostMethod = HostGrpc.getCreateHostMethod) == null) {
          HostGrpc.getCreateHostMethod = getCreateHostMethod =
              io.grpc.MethodDescriptor.<via.sep3.group11.tier2.protobuf.GHost, via.sep3.group11.tier2.protobuf.GHost>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateHost"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.group11.tier2.protobuf.GHost.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.group11.tier2.protobuf.GHost.getDefaultInstance()))
              .setSchemaDescriptor(new HostMethodDescriptorSupplier("CreateHost"))
              .build();
        }
      }
    }
    return getCreateHostMethod;
  }

  private static volatile io.grpc.MethodDescriptor<via.sep3.group11.tier2.protobuf.GEmail,
      via.sep3.group11.tier2.protobuf.GHost> getGetHostByEmailMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetHostByEmail",
      requestType = via.sep3.group11.tier2.protobuf.GEmail.class,
      responseType = via.sep3.group11.tier2.protobuf.GHost.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<via.sep3.group11.tier2.protobuf.GEmail,
      via.sep3.group11.tier2.protobuf.GHost> getGetHostByEmailMethod() {
    io.grpc.MethodDescriptor<via.sep3.group11.tier2.protobuf.GEmail, via.sep3.group11.tier2.protobuf.GHost> getGetHostByEmailMethod;
    if ((getGetHostByEmailMethod = HostGrpc.getGetHostByEmailMethod) == null) {
      synchronized (HostGrpc.class) {
        if ((getGetHostByEmailMethod = HostGrpc.getGetHostByEmailMethod) == null) {
          HostGrpc.getGetHostByEmailMethod = getGetHostByEmailMethod =
              io.grpc.MethodDescriptor.<via.sep3.group11.tier2.protobuf.GEmail, via.sep3.group11.tier2.protobuf.GHost>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetHostByEmail"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.group11.tier2.protobuf.GEmail.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.group11.tier2.protobuf.GHost.getDefaultInstance()))
              .setSchemaDescriptor(new HostMethodDescriptorSupplier("GetHostByEmail"))
              .build();
        }
      }
    }
    return getGetHostByEmailMethod;
  }

  private static volatile io.grpc.MethodDescriptor<via.sep3.group11.tier2.protobuf.GId,
      via.sep3.group11.tier2.protobuf.GHost> getGetHostByHousingIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getHostByHousingId",
      requestType = via.sep3.group11.tier2.protobuf.GId.class,
      responseType = via.sep3.group11.tier2.protobuf.GHost.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<via.sep3.group11.tier2.protobuf.GId,
      via.sep3.group11.tier2.protobuf.GHost> getGetHostByHousingIdMethod() {
    io.grpc.MethodDescriptor<via.sep3.group11.tier2.protobuf.GId, via.sep3.group11.tier2.protobuf.GHost> getGetHostByHousingIdMethod;
    if ((getGetHostByHousingIdMethod = HostGrpc.getGetHostByHousingIdMethod) == null) {
      synchronized (HostGrpc.class) {
        if ((getGetHostByHousingIdMethod = HostGrpc.getGetHostByHousingIdMethod) == null) {
          HostGrpc.getGetHostByHousingIdMethod = getGetHostByHousingIdMethod =
              io.grpc.MethodDescriptor.<via.sep3.group11.tier2.protobuf.GId, via.sep3.group11.tier2.protobuf.GHost>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getHostByHousingId"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.group11.tier2.protobuf.GId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.group11.tier2.protobuf.GHost.getDefaultInstance()))
              .setSchemaDescriptor(new HostMethodDescriptorSupplier("getHostByHousingId"))
              .build();
        }
      }
    }
    return getGetHostByHousingIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<via.sep3.group11.tier2.protobuf.GEmail,
      via.sep3.group11.tier2.protobuf.GEmpty> getDeleteAccountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteAccount",
      requestType = via.sep3.group11.tier2.protobuf.GEmail.class,
      responseType = via.sep3.group11.tier2.protobuf.GEmpty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<via.sep3.group11.tier2.protobuf.GEmail,
      via.sep3.group11.tier2.protobuf.GEmpty> getDeleteAccountMethod() {
    io.grpc.MethodDescriptor<via.sep3.group11.tier2.protobuf.GEmail, via.sep3.group11.tier2.protobuf.GEmpty> getDeleteAccountMethod;
    if ((getDeleteAccountMethod = HostGrpc.getDeleteAccountMethod) == null) {
      synchronized (HostGrpc.class) {
        if ((getDeleteAccountMethod = HostGrpc.getDeleteAccountMethod) == null) {
          HostGrpc.getDeleteAccountMethod = getDeleteAccountMethod =
              io.grpc.MethodDescriptor.<via.sep3.group11.tier2.protobuf.GEmail, via.sep3.group11.tier2.protobuf.GEmpty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteAccount"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.group11.tier2.protobuf.GEmail.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.group11.tier2.protobuf.GEmpty.getDefaultInstance()))
              .setSchemaDescriptor(new HostMethodDescriptorSupplier("deleteAccount"))
              .build();
        }
      }
    }
    return getDeleteAccountMethod;
  }

  private static volatile io.grpc.MethodDescriptor<via.sep3.group11.tier2.protobuf.GHostDetails,
      via.sep3.group11.tier2.protobuf.GHost> getUpdateInformationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateInformation",
      requestType = via.sep3.group11.tier2.protobuf.GHostDetails.class,
      responseType = via.sep3.group11.tier2.protobuf.GHost.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<via.sep3.group11.tier2.protobuf.GHostDetails,
      via.sep3.group11.tier2.protobuf.GHost> getUpdateInformationMethod() {
    io.grpc.MethodDescriptor<via.sep3.group11.tier2.protobuf.GHostDetails, via.sep3.group11.tier2.protobuf.GHost> getUpdateInformationMethod;
    if ((getUpdateInformationMethod = HostGrpc.getUpdateInformationMethod) == null) {
      synchronized (HostGrpc.class) {
        if ((getUpdateInformationMethod = HostGrpc.getUpdateInformationMethod) == null) {
          HostGrpc.getUpdateInformationMethod = getUpdateInformationMethod =
              io.grpc.MethodDescriptor.<via.sep3.group11.tier2.protobuf.GHostDetails, via.sep3.group11.tier2.protobuf.GHost>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateInformation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.group11.tier2.protobuf.GHostDetails.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.group11.tier2.protobuf.GHost.getDefaultInstance()))
              .setSchemaDescriptor(new HostMethodDescriptorSupplier("updateInformation"))
              .build();
        }
      }
    }
    return getUpdateInformationMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static HostStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HostStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HostStub>() {
        @java.lang.Override
        public HostStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HostStub(channel, callOptions);
        }
      };
    return HostStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HostBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HostBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HostBlockingStub>() {
        @java.lang.Override
        public HostBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HostBlockingStub(channel, callOptions);
        }
      };
    return HostBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static HostFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HostFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HostFutureStub>() {
        @java.lang.Override
        public HostFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HostFutureStub(channel, callOptions);
        }
      };
    return HostFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class HostImplBase implements io.grpc.BindableService {

    /**
     */
    public void createHost(via.sep3.group11.tier2.protobuf.GHost request,
        io.grpc.stub.StreamObserver<via.sep3.group11.tier2.protobuf.GHost> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateHostMethod(), responseObserver);
    }

    /**
     */
    public void getHostByEmail(via.sep3.group11.tier2.protobuf.GEmail request,
        io.grpc.stub.StreamObserver<via.sep3.group11.tier2.protobuf.GHost> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetHostByEmailMethod(), responseObserver);
    }

    /**
     */
    public void getHostByHousingId(via.sep3.group11.tier2.protobuf.GId request,
        io.grpc.stub.StreamObserver<via.sep3.group11.tier2.protobuf.GHost> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetHostByHousingIdMethod(), responseObserver);
    }

    /**
     */
    public void deleteAccount(via.sep3.group11.tier2.protobuf.GEmail request,
        io.grpc.stub.StreamObserver<via.sep3.group11.tier2.protobuf.GEmpty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteAccountMethod(), responseObserver);
    }

    /**
     */
    public void updateInformation(via.sep3.group11.tier2.protobuf.GHostDetails request,
        io.grpc.stub.StreamObserver<via.sep3.group11.tier2.protobuf.GHost> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateInformationMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateHostMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                via.sep3.group11.tier2.protobuf.GHost,
                via.sep3.group11.tier2.protobuf.GHost>(
                  this, METHODID_CREATE_HOST)))
          .addMethod(
            getGetHostByEmailMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                via.sep3.group11.tier2.protobuf.GEmail,
                via.sep3.group11.tier2.protobuf.GHost>(
                  this, METHODID_GET_HOST_BY_EMAIL)))
          .addMethod(
            getGetHostByHousingIdMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                via.sep3.group11.tier2.protobuf.GId,
                via.sep3.group11.tier2.protobuf.GHost>(
                  this, METHODID_GET_HOST_BY_HOUSING_ID)))
          .addMethod(
            getDeleteAccountMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                via.sep3.group11.tier2.protobuf.GEmail,
                via.sep3.group11.tier2.protobuf.GEmpty>(
                  this, METHODID_DELETE_ACCOUNT)))
          .addMethod(
            getUpdateInformationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                via.sep3.group11.tier2.protobuf.GHostDetails,
                via.sep3.group11.tier2.protobuf.GHost>(
                  this, METHODID_UPDATE_INFORMATION)))
          .build();
    }
  }

  /**
   */
  public static final class HostStub extends io.grpc.stub.AbstractAsyncStub<HostStub> {
    private HostStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HostStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HostStub(channel, callOptions);
    }

    /**
     */
    public void createHost(via.sep3.group11.tier2.protobuf.GHost request,
        io.grpc.stub.StreamObserver<via.sep3.group11.tier2.protobuf.GHost> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateHostMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getHostByEmail(via.sep3.group11.tier2.protobuf.GEmail request,
        io.grpc.stub.StreamObserver<via.sep3.group11.tier2.protobuf.GHost> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetHostByEmailMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getHostByHousingId(via.sep3.group11.tier2.protobuf.GId request,
        io.grpc.stub.StreamObserver<via.sep3.group11.tier2.protobuf.GHost> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetHostByHousingIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteAccount(via.sep3.group11.tier2.protobuf.GEmail request,
        io.grpc.stub.StreamObserver<via.sep3.group11.tier2.protobuf.GEmpty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAccountMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateInformation(via.sep3.group11.tier2.protobuf.GHostDetails request,
        io.grpc.stub.StreamObserver<via.sep3.group11.tier2.protobuf.GHost> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateInformationMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class HostBlockingStub extends io.grpc.stub.AbstractBlockingStub<HostBlockingStub> {
    private HostBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HostBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HostBlockingStub(channel, callOptions);
    }

    /**
     */
    public via.sep3.group11.tier2.protobuf.GHost createHost(via.sep3.group11.tier2.protobuf.GHost request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateHostMethod(), getCallOptions(), request);
    }

    /**
     */
    public via.sep3.group11.tier2.protobuf.GHost getHostByEmail(via.sep3.group11.tier2.protobuf.GEmail request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetHostByEmailMethod(), getCallOptions(), request);
    }

    /**
     */
    public via.sep3.group11.tier2.protobuf.GHost getHostByHousingId(via.sep3.group11.tier2.protobuf.GId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetHostByHousingIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public via.sep3.group11.tier2.protobuf.GEmpty deleteAccount(via.sep3.group11.tier2.protobuf.GEmail request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAccountMethod(), getCallOptions(), request);
    }

    /**
     */
    public via.sep3.group11.tier2.protobuf.GHost updateInformation(via.sep3.group11.tier2.protobuf.GHostDetails request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateInformationMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class HostFutureStub extends io.grpc.stub.AbstractFutureStub<HostFutureStub> {
    private HostFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HostFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HostFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<via.sep3.group11.tier2.protobuf.GHost> createHost(
        via.sep3.group11.tier2.protobuf.GHost request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateHostMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<via.sep3.group11.tier2.protobuf.GHost> getHostByEmail(
        via.sep3.group11.tier2.protobuf.GEmail request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetHostByEmailMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<via.sep3.group11.tier2.protobuf.GHost> getHostByHousingId(
        via.sep3.group11.tier2.protobuf.GId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetHostByHousingIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<via.sep3.group11.tier2.protobuf.GEmpty> deleteAccount(
        via.sep3.group11.tier2.protobuf.GEmail request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAccountMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<via.sep3.group11.tier2.protobuf.GHost> updateInformation(
        via.sep3.group11.tier2.protobuf.GHostDetails request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateInformationMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_HOST = 0;
  private static final int METHODID_GET_HOST_BY_EMAIL = 1;
  private static final int METHODID_GET_HOST_BY_HOUSING_ID = 2;
  private static final int METHODID_DELETE_ACCOUNT = 3;
  private static final int METHODID_UPDATE_INFORMATION = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final HostImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(HostImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_HOST:
          serviceImpl.createHost((via.sep3.group11.tier2.protobuf.GHost) request,
              (io.grpc.stub.StreamObserver<via.sep3.group11.tier2.protobuf.GHost>) responseObserver);
          break;
        case METHODID_GET_HOST_BY_EMAIL:
          serviceImpl.getHostByEmail((via.sep3.group11.tier2.protobuf.GEmail) request,
              (io.grpc.stub.StreamObserver<via.sep3.group11.tier2.protobuf.GHost>) responseObserver);
          break;
        case METHODID_GET_HOST_BY_HOUSING_ID:
          serviceImpl.getHostByHousingId((via.sep3.group11.tier2.protobuf.GId) request,
              (io.grpc.stub.StreamObserver<via.sep3.group11.tier2.protobuf.GHost>) responseObserver);
          break;
        case METHODID_DELETE_ACCOUNT:
          serviceImpl.deleteAccount((via.sep3.group11.tier2.protobuf.GEmail) request,
              (io.grpc.stub.StreamObserver<via.sep3.group11.tier2.protobuf.GEmpty>) responseObserver);
          break;
        case METHODID_UPDATE_INFORMATION:
          serviceImpl.updateInformation((via.sep3.group11.tier2.protobuf.GHostDetails) request,
              (io.grpc.stub.StreamObserver<via.sep3.group11.tier2.protobuf.GHost>) responseObserver);
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

  private static abstract class HostBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HostBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return via.sep3.group11.tier2.protobuf.HostOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Host");
    }
  }

  private static final class HostFileDescriptorSupplier
      extends HostBaseDescriptorSupplier {
    HostFileDescriptorSupplier() {}
  }

  private static final class HostMethodDescriptorSupplier
      extends HostBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    HostMethodDescriptorSupplier(String methodName) {
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
      synchronized (HostGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new HostFileDescriptorSupplier())
              .addMethod(getCreateHostMethod())
              .addMethod(getGetHostByEmailMethod())
              .addMethod(getGetHostByHousingIdMethod())
              .addMethod(getDeleteAccountMethod())
              .addMethod(getUpdateInformationMethod())
              .build();
        }
      }
    }
    return result;
  }
}
