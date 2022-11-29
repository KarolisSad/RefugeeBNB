package via.sep3.group11.tier3.GrpcImplementation;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import via.sep3.group11.tier3.GrpcImplementation.converters.GrpcConverter;
import via.sep3.group11.tier3.model.Host;
import via.sep3.group11.tier3.protobuf.*;
import via.sep3.group11.tier3.services.servicesInterfaces.HostDaoInterface;

import javax.annotation.Resource;
import java.util.Optional;

@GRpcService
public class HostServiceGrpcImpl extends HostGrpc.HostImplBase {

    @Resource
    HostDaoInterface hostDaoInterface;

    @Override
    public void createHost(GHost request, StreamObserver<GHost> responseObserver) {
        responseObserver.onNext(GrpcConverter.HostToGrpc(
                hostDaoInterface.createHost(GrpcConverter.HostFromGrpc(request))));

        responseObserver.onCompleted();

        //                Host convertedRequest = GrpcConverter.HostFromGrpc(request);
        //                Host dataResponse = hostDaoInterface.createHost(convertedRequest);
        //                GHost response = GrpcConverter.HostToGrpc(dataResponse);
        //                responseObserver.onNext(response);
        //                responseObserver.onCompleted();
    }

    @Override
    public void getHostByEmail(GEmail request, StreamObserver<GHost> responseObserver)
    {
        Optional<Host> dataResponse = hostDaoInterface.getHostByEmail(request.getEmail());
        if (dataResponse.isEmpty())
        {
            responseObserver.onNext(GHost.newBuilder().build());
            responseObserver.onCompleted();
        }
        else {
            GHost response = GrpcConverter.HostToGrpc(dataResponse.get());
            responseObserver.onNext(response);
            responseObserver.onCompleted();

        }
    }

}
