package via.sep3.group11.tier3.protobuf;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.39.0)",
    comments = "Source: Housing.proto")
public final class HousingGrpc {

  private HousingGrpc() {}

  public static final String SERVICE_NAME = "Housing";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<via.sep3.group11.tier3.protobuf.GAddHousingRequest,
      via.sep3.group11.tier3.protobuf.GHousingWithStatus> getAddHousingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addHousing",
      requestType = via.sep3.group11.tier3.protobuf.GAddHousingRequest.class,
      responseType = via.sep3.group11.tier3.protobuf.GHousingWithStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<via.sep3.group11.tier3.protobuf.GAddHousingRequest,
      via.sep3.group11.tier3.protobuf.GHousingWithStatus> getAddHousingMethod() {
    io.grpc.MethodDescriptor<via.sep3.group11.tier3.protobuf.GAddHousingRequest, via.sep3.group11.tier3.protobuf.GHousingWithStatus> getAddHousingMethod;
    if ((getAddHousingMethod = HousingGrpc.getAddHousingMethod) == null) {
      synchronized (HousingGrpc.class) {
        if ((getAddHousingMethod = HousingGrpc.getAddHousingMethod) == null) {
          HousingGrpc.getAddHousingMethod = getAddHousingMethod =
              io.grpc.MethodDescriptor.<via.sep3.group11.tier3.protobuf.GAddHousingRequest, via.sep3.group11.tier3.protobuf.GHousingWithStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addHousing"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.group11.tier3.protobuf.GAddHousingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.group11.tier3.protobuf.GHousingWithStatus.getDefaultInstance()))
              .setSchemaDescriptor(new HousingMethodDescriptorSupplier("addHousing"))
              .build();
        }
      }
    }
    return getAddHousingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<via.sep3.group11.tier3.protobuf.GEmpty,
      via.sep3.group11.tier3.protobuf.GListOfHousing> getGetAvailableHousingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAvailableHousing",
      requestType = via.sep3.group11.tier3.protobuf.GEmpty.class,
      responseType = via.sep3.group11.tier3.protobuf.GListOfHousing.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<via.sep3.group11.tier3.protobuf.GEmpty,
      via.sep3.group11.tier3.protobuf.GListOfHousing> getGetAvailableHousingMethod() {
    io.grpc.MethodDescriptor<via.sep3.group11.tier3.protobuf.GEmpty, via.sep3.group11.tier3.protobuf.GListOfHousing> getGetAvailableHousingMethod;
    if ((getGetAvailableHousingMethod = HousingGrpc.getGetAvailableHousingMethod) == null) {
      synchronized (HousingGrpc.class) {
        if ((getGetAvailableHousingMethod = HousingGrpc.getGetAvailableHousingMethod) == null) {
          HousingGrpc.getGetAvailableHousingMethod = getGetAvailableHousingMethod =
              io.grpc.MethodDescriptor.<via.sep3.group11.tier3.protobuf.GEmpty, via.sep3.group11.tier3.protobuf.GListOfHousing>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAvailableHousing"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.group11.tier3.protobuf.GEmpty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.group11.tier3.protobuf.GListOfHousing.getDefaultInstance()))
              .setSchemaDescriptor(new HousingMethodDescriptorSupplier("getAvailableHousing"))
              .build();
        }
      }
    }
    return getGetAvailableHousingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<via.sep3.group11.tier3.protobuf.GId,
      via.sep3.group11.tier3.protobuf.GEmpty> getRemoveHousingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "removeHousing",
      requestType = via.sep3.group11.tier3.protobuf.GId.class,
      responseType = via.sep3.group11.tier3.protobuf.GEmpty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<via.sep3.group11.tier3.protobuf.GId,
      via.sep3.group11.tier3.protobuf.GEmpty> getRemoveHousingMethod() {
    io.grpc.MethodDescriptor<via.sep3.group11.tier3.protobuf.GId, via.sep3.group11.tier3.protobuf.GEmpty> getRemoveHousingMethod;
    if ((getRemoveHousingMethod = HousingGrpc.getRemoveHousingMethod) == null) {
      synchronized (HousingGrpc.class) {
        if ((getRemoveHousingMethod = HousingGrpc.getRemoveHousingMethod) == null) {
          HousingGrpc.getRemoveHousingMethod = getRemoveHousingMethod =
              io.grpc.MethodDescriptor.<via.sep3.group11.tier3.protobuf.GId, via.sep3.group11.tier3.protobuf.GEmpty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "removeHousing"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.group11.tier3.protobuf.GId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.group11.tier3.protobuf.GEmpty.getDefaultInstance()))
              .setSchemaDescriptor(new HousingMethodDescriptorSupplier("removeHousing"))
              .build();
        }
      }
    }
    return getRemoveHousingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<via.sep3.group11.tier3.protobuf.GId,
      via.sep3.group11.tier3.protobuf.GHousingWithStatus> getGetHousingByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getHousingById",
      requestType = via.sep3.group11.tier3.protobuf.GId.class,
      responseType = via.sep3.group11.tier3.protobuf.GHousingWithStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<via.sep3.group11.tier3.protobuf.GId,
      via.sep3.group11.tier3.protobuf.GHousingWithStatus> getGetHousingByIdMethod() {
    io.grpc.MethodDescriptor<via.sep3.group11.tier3.protobuf.GId, via.sep3.group11.tier3.protobuf.GHousingWithStatus> getGetHousingByIdMethod;
    if ((getGetHousingByIdMethod = HousingGrpc.getGetHousingByIdMethod) == null) {
      synchronized (HousingGrpc.class) {
        if ((getGetHousingByIdMethod = HousingGrpc.getGetHousingByIdMethod) == null) {
          HousingGrpc.getGetHousingByIdMethod = getGetHousingByIdMethod =
              io.grpc.MethodDescriptor.<via.sep3.group11.tier3.protobuf.GId, via.sep3.group11.tier3.protobuf.GHousingWithStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getHousingById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.group11.tier3.protobuf.GId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.group11.tier3.protobuf.GHousingWithStatus.getDefaultInstance()))
              .setSchemaDescriptor(new HousingMethodDescriptorSupplier("getHousingById"))
              .build();
        }
      }
    }
    return getGetHousingByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<via.sep3.group11.tier3.protobuf.GHousingWithStatus,
      via.sep3.group11.tier3.protobuf.GHousingWithStatus> getUpdateHousingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateHousing",
      requestType = via.sep3.group11.tier3.protobuf.GHousingWithStatus.class,
      responseType = via.sep3.group11.tier3.protobuf.GHousingWithStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<via.sep3.group11.tier3.protobuf.GHousingWithStatus,
      via.sep3.group11.tier3.protobuf.GHousingWithStatus> getUpdateHousingMethod() {
    io.grpc.MethodDescriptor<via.sep3.group11.tier3.protobuf.GHousingWithStatus, via.sep3.group11.tier3.protobuf.GHousingWithStatus> getUpdateHousingMethod;
    if ((getUpdateHousingMethod = HousingGrpc.getUpdateHousingMethod) == null) {
      synchronized (HousingGrpc.class) {
        if ((getUpdateHousingMethod = HousingGrpc.getUpdateHousingMethod) == null) {
          HousingGrpc.getUpdateHousingMethod = getUpdateHousingMethod =
              io.grpc.MethodDescriptor.<via.sep3.group11.tier3.protobuf.GHousingWithStatus, via.sep3.group11.tier3.protobuf.GHousingWithStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateHousing"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.group11.tier3.protobuf.GHousingWithStatus.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.group11.tier3.protobuf.GHousingWithStatus.getDefaultInstance()))
              .setSchemaDescriptor(new HousingMethodDescriptorSupplier("updateHousing"))
              .build();
        }
      }
    }
    return getUpdateHousingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<via.sep3.group11.tier3.protobuf.GEmail,
      via.sep3.group11.tier3.protobuf.GListOfHousing> getGetAllHousingByHostIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAllHousingByHostId",
      requestType = via.sep3.group11.tier3.protobuf.GEmail.class,
      responseType = via.sep3.group11.tier3.protobuf.GListOfHousing.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<via.sep3.group11.tier3.protobuf.GEmail,
      via.sep3.group11.tier3.protobuf.GListOfHousing> getGetAllHousingByHostIdMethod() {
    io.grpc.MethodDescriptor<via.sep3.group11.tier3.protobuf.GEmail, via.sep3.group11.tier3.protobuf.GListOfHousing> getGetAllHousingByHostIdMethod;
    if ((getGetAllHousingByHostIdMethod = HousingGrpc.getGetAllHousingByHostIdMethod) == null) {
      synchronized (HousingGrpc.class) {
        if ((getGetAllHousingByHostIdMethod = HousingGrpc.getGetAllHousingByHostIdMethod) == null) {
          HousingGrpc.getGetAllHousingByHostIdMethod = getGetAllHousingByHostIdMethod =
              io.grpc.MethodDescriptor.<via.sep3.group11.tier3.protobuf.GEmail, via.sep3.group11.tier3.protobuf.GListOfHousing>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAllHousingByHostId"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.group11.tier3.protobuf.GEmail.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.group11.tier3.protobuf.GListOfHousing.getDefaultInstance()))
              .setSchemaDescriptor(new HousingMethodDescriptorSupplier("getAllHousingByHostId"))
              .build();
        }
      }
    }
    return getGetAllHousingByHostIdMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static HousingStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HousingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HousingStub>() {
        @java.lang.Override
        public HousingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HousingStub(channel, callOptions);
        }
      };
    return HousingStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HousingBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HousingBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HousingBlockingStub>() {
        @java.lang.Override
        public HousingBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HousingBlockingStub(channel, callOptions);
        }
      };
    return HousingBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static HousingFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HousingFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HousingFutureStub>() {
        @java.lang.Override
        public HousingFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HousingFutureStub(channel, callOptions);
        }
      };
    return HousingFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class HousingImplBase implements io.grpc.BindableService {

    /**
     */
    public void addHousing(via.sep3.group11.tier3.protobuf.GAddHousingRequest request,
        io.grpc.stub.StreamObserver<via.sep3.group11.tier3.protobuf.GHousingWithStatus> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddHousingMethod(), responseObserver);
    }

    /**
     */
    public void getAvailableHousing(via.sep3.group11.tier3.protobuf.GEmpty request,
        io.grpc.stub.StreamObserver<via.sep3.group11.tier3.protobuf.GListOfHousing> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAvailableHousingMethod(), responseObserver);
    }

    /**
     */
    public void removeHousing(via.sep3.group11.tier3.protobuf.GId request,
        io.grpc.stub.StreamObserver<via.sep3.group11.tier3.protobuf.GEmpty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRemoveHousingMethod(), responseObserver);
    }

    /**
     */
    public void getHousingById(via.sep3.group11.tier3.protobuf.GId request,
        io.grpc.stub.StreamObserver<via.sep3.group11.tier3.protobuf.GHousingWithStatus> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetHousingByIdMethod(), responseObserver);
    }

    /**
     */
    public void updateHousing(via.sep3.group11.tier3.protobuf.GHousingWithStatus request,
        io.grpc.stub.StreamObserver<via.sep3.group11.tier3.protobuf.GHousingWithStatus> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateHousingMethod(), responseObserver);
    }

    /**
     */
    public void getAllHousingByHostId(via.sep3.group11.tier3.protobuf.GEmail request,
        io.grpc.stub.StreamObserver<via.sep3.group11.tier3.protobuf.GListOfHousing> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllHousingByHostIdMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddHousingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                via.sep3.group11.tier3.protobuf.GAddHousingRequest,
                via.sep3.group11.tier3.protobuf.GHousingWithStatus>(
                  this, METHODID_ADD_HOUSING)))
          .addMethod(
            getGetAvailableHousingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                via.sep3.group11.tier3.protobuf.GEmpty,
                via.sep3.group11.tier3.protobuf.GListOfHousing>(
                  this, METHODID_GET_AVAILABLE_HOUSING)))
          .addMethod(
            getRemoveHousingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                via.sep3.group11.tier3.protobuf.GId,
                via.sep3.group11.tier3.protobuf.GEmpty>(
                  this, METHODID_REMOVE_HOUSING)))
          .addMethod(
            getGetHousingByIdMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                via.sep3.group11.tier3.protobuf.GId,
                via.sep3.group11.tier3.protobuf.GHousingWithStatus>(
                  this, METHODID_GET_HOUSING_BY_ID)))
          .addMethod(
            getUpdateHousingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                via.sep3.group11.tier3.protobuf.GHousingWithStatus,
                via.sep3.group11.tier3.protobuf.GHousingWithStatus>(
                  this, METHODID_UPDATE_HOUSING)))
          .addMethod(
            getGetAllHousingByHostIdMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                via.sep3.group11.tier3.protobuf.GEmail,
                via.sep3.group11.tier3.protobuf.GListOfHousing>(
                  this, METHODID_GET_ALL_HOUSING_BY_HOST_ID)))
          .build();
    }
  }

  /**
   */
  public static final class HousingStub extends io.grpc.stub.AbstractAsyncStub<HousingStub> {
    private HousingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HousingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HousingStub(channel, callOptions);
    }

    /**
     */
    public void addHousing(via.sep3.group11.tier3.protobuf.GAddHousingRequest request,
        io.grpc.stub.StreamObserver<via.sep3.group11.tier3.protobuf.GHousingWithStatus> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddHousingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAvailableHousing(via.sep3.group11.tier3.protobuf.GEmpty request,
        io.grpc.stub.StreamObserver<via.sep3.group11.tier3.protobuf.GListOfHousing> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAvailableHousingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void removeHousing(via.sep3.group11.tier3.protobuf.GId request,
        io.grpc.stub.StreamObserver<via.sep3.group11.tier3.protobuf.GEmpty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRemoveHousingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getHousingById(via.sep3.group11.tier3.protobuf.GId request,
        io.grpc.stub.StreamObserver<via.sep3.group11.tier3.protobuf.GHousingWithStatus> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetHousingByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateHousing(via.sep3.group11.tier3.protobuf.GHousingWithStatus request,
        io.grpc.stub.StreamObserver<via.sep3.group11.tier3.protobuf.GHousingWithStatus> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateHousingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllHousingByHostId(via.sep3.group11.tier3.protobuf.GEmail request,
        io.grpc.stub.StreamObserver<via.sep3.group11.tier3.protobuf.GListOfHousing> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllHousingByHostIdMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class HousingBlockingStub extends io.grpc.stub.AbstractBlockingStub<HousingBlockingStub> {
    private HousingBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HousingBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HousingBlockingStub(channel, callOptions);
    }

    /**
     */
    public via.sep3.group11.tier3.protobuf.GHousingWithStatus addHousing(via.sep3.group11.tier3.protobuf.GAddHousingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddHousingMethod(), getCallOptions(), request);
    }

    /**
     */
    public via.sep3.group11.tier3.protobuf.GListOfHousing getAvailableHousing(via.sep3.group11.tier3.protobuf.GEmpty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAvailableHousingMethod(), getCallOptions(), request);
    }

    /**
     */
    public via.sep3.group11.tier3.protobuf.GEmpty removeHousing(via.sep3.group11.tier3.protobuf.GId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRemoveHousingMethod(), getCallOptions(), request);
    }

    /**
     */
    public via.sep3.group11.tier3.protobuf.GHousingWithStatus getHousingById(via.sep3.group11.tier3.protobuf.GId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetHousingByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public via.sep3.group11.tier3.protobuf.GHousingWithStatus updateHousing(via.sep3.group11.tier3.protobuf.GHousingWithStatus request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateHousingMethod(), getCallOptions(), request);
    }

    /**
     */
    public via.sep3.group11.tier3.protobuf.GListOfHousing getAllHousingByHostId(via.sep3.group11.tier3.protobuf.GEmail request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllHousingByHostIdMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class HousingFutureStub extends io.grpc.stub.AbstractFutureStub<HousingFutureStub> {
    private HousingFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HousingFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HousingFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<via.sep3.group11.tier3.protobuf.GHousingWithStatus> addHousing(
        via.sep3.group11.tier3.protobuf.GAddHousingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddHousingMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<via.sep3.group11.tier3.protobuf.GListOfHousing> getAvailableHousing(
        via.sep3.group11.tier3.protobuf.GEmpty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAvailableHousingMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<via.sep3.group11.tier3.protobuf.GEmpty> removeHousing(
        via.sep3.group11.tier3.protobuf.GId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRemoveHousingMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<via.sep3.group11.tier3.protobuf.GHousingWithStatus> getHousingById(
        via.sep3.group11.tier3.protobuf.GId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetHousingByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<via.sep3.group11.tier3.protobuf.GHousingWithStatus> updateHousing(
        via.sep3.group11.tier3.protobuf.GHousingWithStatus request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateHousingMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<via.sep3.group11.tier3.protobuf.GListOfHousing> getAllHousingByHostId(
        via.sep3.group11.tier3.protobuf.GEmail request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllHousingByHostIdMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_HOUSING = 0;
  private static final int METHODID_GET_AVAILABLE_HOUSING = 1;
  private static final int METHODID_REMOVE_HOUSING = 2;
  private static final int METHODID_GET_HOUSING_BY_ID = 3;
  private static final int METHODID_UPDATE_HOUSING = 4;
  private static final int METHODID_GET_ALL_HOUSING_BY_HOST_ID = 5;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final HousingImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(HousingImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_HOUSING:
          serviceImpl.addHousing((via.sep3.group11.tier3.protobuf.GAddHousingRequest) request,
              (io.grpc.stub.StreamObserver<via.sep3.group11.tier3.protobuf.GHousingWithStatus>) responseObserver);
          break;
        case METHODID_GET_AVAILABLE_HOUSING:
          serviceImpl.getAvailableHousing((via.sep3.group11.tier3.protobuf.GEmpty) request,
              (io.grpc.stub.StreamObserver<via.sep3.group11.tier3.protobuf.GListOfHousing>) responseObserver);
          break;
        case METHODID_REMOVE_HOUSING:
          serviceImpl.removeHousing((via.sep3.group11.tier3.protobuf.GId) request,
              (io.grpc.stub.StreamObserver<via.sep3.group11.tier3.protobuf.GEmpty>) responseObserver);
          break;
        case METHODID_GET_HOUSING_BY_ID:
          serviceImpl.getHousingById((via.sep3.group11.tier3.protobuf.GId) request,
              (io.grpc.stub.StreamObserver<via.sep3.group11.tier3.protobuf.GHousingWithStatus>) responseObserver);
          break;
        case METHODID_UPDATE_HOUSING:
          serviceImpl.updateHousing((via.sep3.group11.tier3.protobuf.GHousingWithStatus) request,
              (io.grpc.stub.StreamObserver<via.sep3.group11.tier3.protobuf.GHousingWithStatus>) responseObserver);
          break;
        case METHODID_GET_ALL_HOUSING_BY_HOST_ID:
          serviceImpl.getAllHousingByHostId((via.sep3.group11.tier3.protobuf.GEmail) request,
              (io.grpc.stub.StreamObserver<via.sep3.group11.tier3.protobuf.GListOfHousing>) responseObserver);
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

  private static abstract class HousingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HousingBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return via.sep3.group11.tier3.protobuf.HousingOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Housing");
    }
  }

  private static final class HousingFileDescriptorSupplier
      extends HousingBaseDescriptorSupplier {
    HousingFileDescriptorSupplier() {}
  }

  private static final class HousingMethodDescriptorSupplier
      extends HousingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    HousingMethodDescriptorSupplier(String methodName) {
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
      synchronized (HousingGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new HousingFileDescriptorSupplier())
              .addMethod(getAddHousingMethod())
              .addMethod(getGetAvailableHousingMethod())
              .addMethod(getRemoveHousingMethod())
              .addMethod(getGetHousingByIdMethod())
              .addMethod(getUpdateHousingMethod())
              .addMethod(getGetAllHousingByHostIdMethod())
              .build();
        }
      }
    }
    return result;
  }
}
