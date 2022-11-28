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
      via.sep3.group11.tier3.protobuf.GHousing> getAddHousingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addHousing",
      requestType = via.sep3.group11.tier3.protobuf.GAddHousingRequest.class,
      responseType = via.sep3.group11.tier3.protobuf.GHousing.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<via.sep3.group11.tier3.protobuf.GAddHousingRequest,
      via.sep3.group11.tier3.protobuf.GHousing> getAddHousingMethod() {
    io.grpc.MethodDescriptor<via.sep3.group11.tier3.protobuf.GAddHousingRequest, via.sep3.group11.tier3.protobuf.GHousing> getAddHousingMethod;
    if ((getAddHousingMethod = HousingGrpc.getAddHousingMethod) == null) {
      synchronized (HousingGrpc.class) {
        if ((getAddHousingMethod = HousingGrpc.getAddHousingMethod) == null) {
          HousingGrpc.getAddHousingMethod = getAddHousingMethod =
              io.grpc.MethodDescriptor.<via.sep3.group11.tier3.protobuf.GAddHousingRequest, via.sep3.group11.tier3.protobuf.GHousing>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addHousing"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.group11.tier3.protobuf.GAddHousingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.group11.tier3.protobuf.GHousing.getDefaultInstance()))
              .setSchemaDescriptor(new HousingMethodDescriptorSupplier("addHousing"))
              .build();
        }
      }
    }
    return getAddHousingMethod;
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
        io.grpc.stub.StreamObserver<via.sep3.group11.tier3.protobuf.GHousing> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddHousingMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddHousingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                via.sep3.group11.tier3.protobuf.GAddHousingRequest,
                via.sep3.group11.tier3.protobuf.GHousing>(
                  this, METHODID_ADD_HOUSING)))
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
        io.grpc.stub.StreamObserver<via.sep3.group11.tier3.protobuf.GHousing> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddHousingMethod(), getCallOptions()), request, responseObserver);
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
    public via.sep3.group11.tier3.protobuf.GHousing addHousing(via.sep3.group11.tier3.protobuf.GAddHousingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddHousingMethod(), getCallOptions(), request);
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
    public com.google.common.util.concurrent.ListenableFuture<via.sep3.group11.tier3.protobuf.GHousing> addHousing(
        via.sep3.group11.tier3.protobuf.GAddHousingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddHousingMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_HOUSING = 0;

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
              (io.grpc.stub.StreamObserver<via.sep3.group11.tier3.protobuf.GHousing>) responseObserver);
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
              .build();
        }
      }
    }
    return result;
  }
}
