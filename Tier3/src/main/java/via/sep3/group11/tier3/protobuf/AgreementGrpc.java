package via.sep3.group11.tier3.protobuf;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.39.0)",
    comments = "Source: Agreement.proto")
public final class AgreementGrpc {

  private AgreementGrpc() {}

  public static final String SERVICE_NAME = "Agreement";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<via.sep3.group11.tier3.protobuf.GAgreement,
      via.sep3.group11.tier3.protobuf.GAgreement> getAddAgreementMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addAgreement",
      requestType = via.sep3.group11.tier3.protobuf.GAgreement.class,
      responseType = via.sep3.group11.tier3.protobuf.GAgreement.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<via.sep3.group11.tier3.protobuf.GAgreement,
      via.sep3.group11.tier3.protobuf.GAgreement> getAddAgreementMethod() {
    io.grpc.MethodDescriptor<via.sep3.group11.tier3.protobuf.GAgreement, via.sep3.group11.tier3.protobuf.GAgreement> getAddAgreementMethod;
    if ((getAddAgreementMethod = AgreementGrpc.getAddAgreementMethod) == null) {
      synchronized (AgreementGrpc.class) {
        if ((getAddAgreementMethod = AgreementGrpc.getAddAgreementMethod) == null) {
          AgreementGrpc.getAddAgreementMethod = getAddAgreementMethod =
              io.grpc.MethodDescriptor.<via.sep3.group11.tier3.protobuf.GAgreement, via.sep3.group11.tier3.protobuf.GAgreement>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addAgreement"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.group11.tier3.protobuf.GAgreement.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.group11.tier3.protobuf.GAgreement.getDefaultInstance()))
              .setSchemaDescriptor(new AgreementMethodDescriptorSupplier("addAgreement"))
              .build();
        }
      }
    }
    return getAddAgreementMethod;
  }

  private static volatile io.grpc.MethodDescriptor<via.sep3.group11.tier3.protobuf.GAgreement,
      via.sep3.group11.tier3.protobuf.GAgreement> getUpdateAgreementMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateAgreement",
      requestType = via.sep3.group11.tier3.protobuf.GAgreement.class,
      responseType = via.sep3.group11.tier3.protobuf.GAgreement.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<via.sep3.group11.tier3.protobuf.GAgreement,
      via.sep3.group11.tier3.protobuf.GAgreement> getUpdateAgreementMethod() {
    io.grpc.MethodDescriptor<via.sep3.group11.tier3.protobuf.GAgreement, via.sep3.group11.tier3.protobuf.GAgreement> getUpdateAgreementMethod;
    if ((getUpdateAgreementMethod = AgreementGrpc.getUpdateAgreementMethod) == null) {
      synchronized (AgreementGrpc.class) {
        if ((getUpdateAgreementMethod = AgreementGrpc.getUpdateAgreementMethod) == null) {
          AgreementGrpc.getUpdateAgreementMethod = getUpdateAgreementMethod =
              io.grpc.MethodDescriptor.<via.sep3.group11.tier3.protobuf.GAgreement, via.sep3.group11.tier3.protobuf.GAgreement>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateAgreement"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.group11.tier3.protobuf.GAgreement.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.group11.tier3.protobuf.GAgreement.getDefaultInstance()))
              .setSchemaDescriptor(new AgreementMethodDescriptorSupplier("updateAgreement"))
              .build();
        }
      }
    }
    return getUpdateAgreementMethod;
  }

  private static volatile io.grpc.MethodDescriptor<via.sep3.group11.tier3.protobuf.GId,
      via.sep3.group11.tier3.protobuf.GAgreement> getGetAgreementByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAgreementById",
      requestType = via.sep3.group11.tier3.protobuf.GId.class,
      responseType = via.sep3.group11.tier3.protobuf.GAgreement.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<via.sep3.group11.tier3.protobuf.GId,
      via.sep3.group11.tier3.protobuf.GAgreement> getGetAgreementByIdMethod() {
    io.grpc.MethodDescriptor<via.sep3.group11.tier3.protobuf.GId, via.sep3.group11.tier3.protobuf.GAgreement> getGetAgreementByIdMethod;
    if ((getGetAgreementByIdMethod = AgreementGrpc.getGetAgreementByIdMethod) == null) {
      synchronized (AgreementGrpc.class) {
        if ((getGetAgreementByIdMethod = AgreementGrpc.getGetAgreementByIdMethod) == null) {
          AgreementGrpc.getGetAgreementByIdMethod = getGetAgreementByIdMethod =
              io.grpc.MethodDescriptor.<via.sep3.group11.tier3.protobuf.GId, via.sep3.group11.tier3.protobuf.GAgreement>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAgreementById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.group11.tier3.protobuf.GId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.group11.tier3.protobuf.GAgreement.getDefaultInstance()))
              .setSchemaDescriptor(new AgreementMethodDescriptorSupplier("getAgreementById"))
              .build();
        }
      }
    }
    return getGetAgreementByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<via.sep3.group11.tier3.protobuf.GEmail,
      via.sep3.group11.tier3.protobuf.GAgreementList> getGetAgreementByHostIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAgreementByHostId",
      requestType = via.sep3.group11.tier3.protobuf.GEmail.class,
      responseType = via.sep3.group11.tier3.protobuf.GAgreementList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<via.sep3.group11.tier3.protobuf.GEmail,
      via.sep3.group11.tier3.protobuf.GAgreementList> getGetAgreementByHostIdMethod() {
    io.grpc.MethodDescriptor<via.sep3.group11.tier3.protobuf.GEmail, via.sep3.group11.tier3.protobuf.GAgreementList> getGetAgreementByHostIdMethod;
    if ((getGetAgreementByHostIdMethod = AgreementGrpc.getGetAgreementByHostIdMethod) == null) {
      synchronized (AgreementGrpc.class) {
        if ((getGetAgreementByHostIdMethod = AgreementGrpc.getGetAgreementByHostIdMethod) == null) {
          AgreementGrpc.getGetAgreementByHostIdMethod = getGetAgreementByHostIdMethod =
              io.grpc.MethodDescriptor.<via.sep3.group11.tier3.protobuf.GEmail, via.sep3.group11.tier3.protobuf.GAgreementList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAgreementByHostId"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.group11.tier3.protobuf.GEmail.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.group11.tier3.protobuf.GAgreementList.getDefaultInstance()))
              .setSchemaDescriptor(new AgreementMethodDescriptorSupplier("getAgreementByHostId"))
              .build();
        }
      }
    }
    return getGetAgreementByHostIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<via.sep3.group11.tier3.protobuf.GId,
      via.sep3.group11.tier3.protobuf.GEmpty> getDeleteAgreementMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteAgreement",
      requestType = via.sep3.group11.tier3.protobuf.GId.class,
      responseType = via.sep3.group11.tier3.protobuf.GEmpty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<via.sep3.group11.tier3.protobuf.GId,
      via.sep3.group11.tier3.protobuf.GEmpty> getDeleteAgreementMethod() {
    io.grpc.MethodDescriptor<via.sep3.group11.tier3.protobuf.GId, via.sep3.group11.tier3.protobuf.GEmpty> getDeleteAgreementMethod;
    if ((getDeleteAgreementMethod = AgreementGrpc.getDeleteAgreementMethod) == null) {
      synchronized (AgreementGrpc.class) {
        if ((getDeleteAgreementMethod = AgreementGrpc.getDeleteAgreementMethod) == null) {
          AgreementGrpc.getDeleteAgreementMethod = getDeleteAgreementMethod =
              io.grpc.MethodDescriptor.<via.sep3.group11.tier3.protobuf.GId, via.sep3.group11.tier3.protobuf.GEmpty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteAgreement"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.group11.tier3.protobuf.GId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.group11.tier3.protobuf.GEmpty.getDefaultInstance()))
              .setSchemaDescriptor(new AgreementMethodDescriptorSupplier("deleteAgreement"))
              .build();
        }
      }
    }
    return getDeleteAgreementMethod;
  }

  private static volatile io.grpc.MethodDescriptor<via.sep3.group11.tier3.protobuf.GId,
      via.sep3.group11.tier3.protobuf.GAgreementList> getGetAllAgreementByHousingIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAllAgreementByHousingId",
      requestType = via.sep3.group11.tier3.protobuf.GId.class,
      responseType = via.sep3.group11.tier3.protobuf.GAgreementList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<via.sep3.group11.tier3.protobuf.GId,
      via.sep3.group11.tier3.protobuf.GAgreementList> getGetAllAgreementByHousingIdMethod() {
    io.grpc.MethodDescriptor<via.sep3.group11.tier3.protobuf.GId, via.sep3.group11.tier3.protobuf.GAgreementList> getGetAllAgreementByHousingIdMethod;
    if ((getGetAllAgreementByHousingIdMethod = AgreementGrpc.getGetAllAgreementByHousingIdMethod) == null) {
      synchronized (AgreementGrpc.class) {
        if ((getGetAllAgreementByHousingIdMethod = AgreementGrpc.getGetAllAgreementByHousingIdMethod) == null) {
          AgreementGrpc.getGetAllAgreementByHousingIdMethod = getGetAllAgreementByHousingIdMethod =
              io.grpc.MethodDescriptor.<via.sep3.group11.tier3.protobuf.GId, via.sep3.group11.tier3.protobuf.GAgreementList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAllAgreementByHousingId"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.group11.tier3.protobuf.GId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.group11.tier3.protobuf.GAgreementList.getDefaultInstance()))
              .setSchemaDescriptor(new AgreementMethodDescriptorSupplier("getAllAgreementByHousingId"))
              .build();
        }
      }
    }
    return getGetAllAgreementByHousingIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<via.sep3.group11.tier3.protobuf.GEmail,
      via.sep3.group11.tier3.protobuf.GAgreement> getGetAgreementByRefugeeIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAgreementByRefugeeId",
      requestType = via.sep3.group11.tier3.protobuf.GEmail.class,
      responseType = via.sep3.group11.tier3.protobuf.GAgreement.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<via.sep3.group11.tier3.protobuf.GEmail,
      via.sep3.group11.tier3.protobuf.GAgreement> getGetAgreementByRefugeeIdMethod() {
    io.grpc.MethodDescriptor<via.sep3.group11.tier3.protobuf.GEmail, via.sep3.group11.tier3.protobuf.GAgreement> getGetAgreementByRefugeeIdMethod;
    if ((getGetAgreementByRefugeeIdMethod = AgreementGrpc.getGetAgreementByRefugeeIdMethod) == null) {
      synchronized (AgreementGrpc.class) {
        if ((getGetAgreementByRefugeeIdMethod = AgreementGrpc.getGetAgreementByRefugeeIdMethod) == null) {
          AgreementGrpc.getGetAgreementByRefugeeIdMethod = getGetAgreementByRefugeeIdMethod =
              io.grpc.MethodDescriptor.<via.sep3.group11.tier3.protobuf.GEmail, via.sep3.group11.tier3.protobuf.GAgreement>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAgreementByRefugeeId"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.group11.tier3.protobuf.GEmail.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.group11.tier3.protobuf.GAgreement.getDefaultInstance()))
              .setSchemaDescriptor(new AgreementMethodDescriptorSupplier("getAgreementByRefugeeId"))
              .build();
        }
      }
    }
    return getGetAgreementByRefugeeIdMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AgreementStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AgreementStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AgreementStub>() {
        @java.lang.Override
        public AgreementStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AgreementStub(channel, callOptions);
        }
      };
    return AgreementStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AgreementBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AgreementBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AgreementBlockingStub>() {
        @java.lang.Override
        public AgreementBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AgreementBlockingStub(channel, callOptions);
        }
      };
    return AgreementBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AgreementFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AgreementFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AgreementFutureStub>() {
        @java.lang.Override
        public AgreementFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AgreementFutureStub(channel, callOptions);
        }
      };
    return AgreementFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class AgreementImplBase implements io.grpc.BindableService {

    /**
     */
    public void addAgreement(via.sep3.group11.tier3.protobuf.GAgreement request,
        io.grpc.stub.StreamObserver<via.sep3.group11.tier3.protobuf.GAgreement> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddAgreementMethod(), responseObserver);
    }

    /**
     */
    public void updateAgreement(via.sep3.group11.tier3.protobuf.GAgreement request,
        io.grpc.stub.StreamObserver<via.sep3.group11.tier3.protobuf.GAgreement> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateAgreementMethod(), responseObserver);
    }

    /**
     */
    public void getAgreementById(via.sep3.group11.tier3.protobuf.GId request,
        io.grpc.stub.StreamObserver<via.sep3.group11.tier3.protobuf.GAgreement> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAgreementByIdMethod(), responseObserver);
    }

    /**
     */
    public void getAgreementByHostId(via.sep3.group11.tier3.protobuf.GEmail request,
        io.grpc.stub.StreamObserver<via.sep3.group11.tier3.protobuf.GAgreementList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAgreementByHostIdMethod(), responseObserver);
    }

    /**
     */
    public void deleteAgreement(via.sep3.group11.tier3.protobuf.GId request,
        io.grpc.stub.StreamObserver<via.sep3.group11.tier3.protobuf.GEmpty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteAgreementMethod(), responseObserver);
    }

    /**
     */
    public void getAllAgreementByHousingId(via.sep3.group11.tier3.protobuf.GId request,
        io.grpc.stub.StreamObserver<via.sep3.group11.tier3.protobuf.GAgreementList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllAgreementByHousingIdMethod(), responseObserver);
    }

    /**
     */
    public void getAgreementByRefugeeId(via.sep3.group11.tier3.protobuf.GEmail request,
        io.grpc.stub.StreamObserver<via.sep3.group11.tier3.protobuf.GAgreement> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAgreementByRefugeeIdMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddAgreementMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                via.sep3.group11.tier3.protobuf.GAgreement,
                via.sep3.group11.tier3.protobuf.GAgreement>(
                  this, METHODID_ADD_AGREEMENT)))
          .addMethod(
            getUpdateAgreementMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                via.sep3.group11.tier3.protobuf.GAgreement,
                via.sep3.group11.tier3.protobuf.GAgreement>(
                  this, METHODID_UPDATE_AGREEMENT)))
          .addMethod(
            getGetAgreementByIdMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                via.sep3.group11.tier3.protobuf.GId,
                via.sep3.group11.tier3.protobuf.GAgreement>(
                  this, METHODID_GET_AGREEMENT_BY_ID)))
          .addMethod(
            getGetAgreementByHostIdMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                via.sep3.group11.tier3.protobuf.GEmail,
                via.sep3.group11.tier3.protobuf.GAgreementList>(
                  this, METHODID_GET_AGREEMENT_BY_HOST_ID)))
          .addMethod(
            getDeleteAgreementMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                via.sep3.group11.tier3.protobuf.GId,
                via.sep3.group11.tier3.protobuf.GEmpty>(
                  this, METHODID_DELETE_AGREEMENT)))
          .addMethod(
            getGetAllAgreementByHousingIdMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                via.sep3.group11.tier3.protobuf.GId,
                via.sep3.group11.tier3.protobuf.GAgreementList>(
                  this, METHODID_GET_ALL_AGREEMENT_BY_HOUSING_ID)))
          .addMethod(
            getGetAgreementByRefugeeIdMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                via.sep3.group11.tier3.protobuf.GEmail,
                via.sep3.group11.tier3.protobuf.GAgreement>(
                  this, METHODID_GET_AGREEMENT_BY_REFUGEE_ID)))
          .build();
    }
  }

  /**
   */
  public static final class AgreementStub extends io.grpc.stub.AbstractAsyncStub<AgreementStub> {
    private AgreementStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AgreementStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AgreementStub(channel, callOptions);
    }

    /**
     */
    public void addAgreement(via.sep3.group11.tier3.protobuf.GAgreement request,
        io.grpc.stub.StreamObserver<via.sep3.group11.tier3.protobuf.GAgreement> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddAgreementMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateAgreement(via.sep3.group11.tier3.protobuf.GAgreement request,
        io.grpc.stub.StreamObserver<via.sep3.group11.tier3.protobuf.GAgreement> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAgreementMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAgreementById(via.sep3.group11.tier3.protobuf.GId request,
        io.grpc.stub.StreamObserver<via.sep3.group11.tier3.protobuf.GAgreement> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAgreementByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAgreementByHostId(via.sep3.group11.tier3.protobuf.GEmail request,
        io.grpc.stub.StreamObserver<via.sep3.group11.tier3.protobuf.GAgreementList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAgreementByHostIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteAgreement(via.sep3.group11.tier3.protobuf.GId request,
        io.grpc.stub.StreamObserver<via.sep3.group11.tier3.protobuf.GEmpty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAgreementMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllAgreementByHousingId(via.sep3.group11.tier3.protobuf.GId request,
        io.grpc.stub.StreamObserver<via.sep3.group11.tier3.protobuf.GAgreementList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllAgreementByHousingIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAgreementByRefugeeId(via.sep3.group11.tier3.protobuf.GEmail request,
        io.grpc.stub.StreamObserver<via.sep3.group11.tier3.protobuf.GAgreement> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAgreementByRefugeeIdMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class AgreementBlockingStub extends io.grpc.stub.AbstractBlockingStub<AgreementBlockingStub> {
    private AgreementBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AgreementBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AgreementBlockingStub(channel, callOptions);
    }

    /**
     */
    public via.sep3.group11.tier3.protobuf.GAgreement addAgreement(via.sep3.group11.tier3.protobuf.GAgreement request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddAgreementMethod(), getCallOptions(), request);
    }

    /**
     */
    public via.sep3.group11.tier3.protobuf.GAgreement updateAgreement(via.sep3.group11.tier3.protobuf.GAgreement request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAgreementMethod(), getCallOptions(), request);
    }

    /**
     */
    public via.sep3.group11.tier3.protobuf.GAgreement getAgreementById(via.sep3.group11.tier3.protobuf.GId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAgreementByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public via.sep3.group11.tier3.protobuf.GAgreementList getAgreementByHostId(via.sep3.group11.tier3.protobuf.GEmail request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAgreementByHostIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public via.sep3.group11.tier3.protobuf.GEmpty deleteAgreement(via.sep3.group11.tier3.protobuf.GId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAgreementMethod(), getCallOptions(), request);
    }

    /**
     */
    public via.sep3.group11.tier3.protobuf.GAgreementList getAllAgreementByHousingId(via.sep3.group11.tier3.protobuf.GId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllAgreementByHousingIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public via.sep3.group11.tier3.protobuf.GAgreement getAgreementByRefugeeId(via.sep3.group11.tier3.protobuf.GEmail request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAgreementByRefugeeIdMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class AgreementFutureStub extends io.grpc.stub.AbstractFutureStub<AgreementFutureStub> {
    private AgreementFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AgreementFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AgreementFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<via.sep3.group11.tier3.protobuf.GAgreement> addAgreement(
        via.sep3.group11.tier3.protobuf.GAgreement request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddAgreementMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<via.sep3.group11.tier3.protobuf.GAgreement> updateAgreement(
        via.sep3.group11.tier3.protobuf.GAgreement request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAgreementMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<via.sep3.group11.tier3.protobuf.GAgreement> getAgreementById(
        via.sep3.group11.tier3.protobuf.GId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAgreementByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<via.sep3.group11.tier3.protobuf.GAgreementList> getAgreementByHostId(
        via.sep3.group11.tier3.protobuf.GEmail request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAgreementByHostIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<via.sep3.group11.tier3.protobuf.GEmpty> deleteAgreement(
        via.sep3.group11.tier3.protobuf.GId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAgreementMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<via.sep3.group11.tier3.protobuf.GAgreementList> getAllAgreementByHousingId(
        via.sep3.group11.tier3.protobuf.GId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllAgreementByHousingIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<via.sep3.group11.tier3.protobuf.GAgreement> getAgreementByRefugeeId(
        via.sep3.group11.tier3.protobuf.GEmail request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAgreementByRefugeeIdMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_AGREEMENT = 0;
  private static final int METHODID_UPDATE_AGREEMENT = 1;
  private static final int METHODID_GET_AGREEMENT_BY_ID = 2;
  private static final int METHODID_GET_AGREEMENT_BY_HOST_ID = 3;
  private static final int METHODID_DELETE_AGREEMENT = 4;
  private static final int METHODID_GET_ALL_AGREEMENT_BY_HOUSING_ID = 5;
  private static final int METHODID_GET_AGREEMENT_BY_REFUGEE_ID = 6;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AgreementImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AgreementImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_AGREEMENT:
          serviceImpl.addAgreement((via.sep3.group11.tier3.protobuf.GAgreement) request,
              (io.grpc.stub.StreamObserver<via.sep3.group11.tier3.protobuf.GAgreement>) responseObserver);
          break;
        case METHODID_UPDATE_AGREEMENT:
          serviceImpl.updateAgreement((via.sep3.group11.tier3.protobuf.GAgreement) request,
              (io.grpc.stub.StreamObserver<via.sep3.group11.tier3.protobuf.GAgreement>) responseObserver);
          break;
        case METHODID_GET_AGREEMENT_BY_ID:
          serviceImpl.getAgreementById((via.sep3.group11.tier3.protobuf.GId) request,
              (io.grpc.stub.StreamObserver<via.sep3.group11.tier3.protobuf.GAgreement>) responseObserver);
          break;
        case METHODID_GET_AGREEMENT_BY_HOST_ID:
          serviceImpl.getAgreementByHostId((via.sep3.group11.tier3.protobuf.GEmail) request,
              (io.grpc.stub.StreamObserver<via.sep3.group11.tier3.protobuf.GAgreementList>) responseObserver);
          break;
        case METHODID_DELETE_AGREEMENT:
          serviceImpl.deleteAgreement((via.sep3.group11.tier3.protobuf.GId) request,
              (io.grpc.stub.StreamObserver<via.sep3.group11.tier3.protobuf.GEmpty>) responseObserver);
          break;
        case METHODID_GET_ALL_AGREEMENT_BY_HOUSING_ID:
          serviceImpl.getAllAgreementByHousingId((via.sep3.group11.tier3.protobuf.GId) request,
              (io.grpc.stub.StreamObserver<via.sep3.group11.tier3.protobuf.GAgreementList>) responseObserver);
          break;
        case METHODID_GET_AGREEMENT_BY_REFUGEE_ID:
          serviceImpl.getAgreementByRefugeeId((via.sep3.group11.tier3.protobuf.GEmail) request,
              (io.grpc.stub.StreamObserver<via.sep3.group11.tier3.protobuf.GAgreement>) responseObserver);
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

  private static abstract class AgreementBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AgreementBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return via.sep3.group11.tier3.protobuf.AgreementOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Agreement");
    }
  }

  private static final class AgreementFileDescriptorSupplier
      extends AgreementBaseDescriptorSupplier {
    AgreementFileDescriptorSupplier() {}
  }

  private static final class AgreementMethodDescriptorSupplier
      extends AgreementBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AgreementMethodDescriptorSupplier(String methodName) {
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
      synchronized (AgreementGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AgreementFileDescriptorSupplier())
              .addMethod(getAddAgreementMethod())
              .addMethod(getUpdateAgreementMethod())
              .addMethod(getGetAgreementByIdMethod())
              .addMethod(getGetAgreementByHostIdMethod())
              .addMethod(getDeleteAgreementMethod())
              .addMethod(getGetAllAgreementByHousingIdMethod())
              .addMethod(getGetAgreementByRefugeeIdMethod())
              .build();
        }
      }
    }
    return result;
  }
}
