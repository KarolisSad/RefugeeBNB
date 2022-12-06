package via.sep3.group11.tier3.GrpcImplementation;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import via.sep3.group11.tier3.GrpcImplementation.converters.GrpcConverter;
import via.sep3.group11.tier3.model.Host;
import via.sep3.group11.tier3.DAO.DAOInterfaces.HostDaoInterface;
import via.sep3.group11.tier3.protobuf.GEmail;
import via.sep3.group11.tier3.protobuf.GHost;
import via.sep3.group11.tier3.protobuf.GId;
import via.sep3.group11.tier3.protobuf.HostGrpc;
import javax.annotation.Resource;
import java.util.Optional;

@GRpcService
public class HostServiceGrpcImpl extends HostGrpc.HostImplBase {

    @Resource
    HostDaoInterface hostDaoInterface;

    @Override
    public void createHost(GHost request, StreamObserver<GHost> responseObserver) {
        System.out.println("DATA TIER CHECKING GENDER AFTER CONVERT: " + request.getGender());

        responseObserver.onNext(GrpcConverter.hostToGrpc(
                hostDaoInterface.createHost(GrpcConverter.hostFromGrpc(request))));
        System.out.println("DATA TIER CHECKING GENDER AFTER CONVERT: " + request.getGender());

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
            GHost response = GrpcConverter.hostToGrpc(dataResponse.get());
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void getHostByHousingId(GId request, StreamObserver<GHost> responseObserver)
    {
        Optional<Host> dataResponse = hostDaoInterface.getHostByHousingId(request.getId());
        if (dataResponse.isEmpty())
        {
            responseObserver.onNext(GHost.newBuilder().build());
            responseObserver.onCompleted();
        }
        else {
            GHost response = GrpcConverter.hostToGrpc(dataResponse.get());
            responseObserver.onNext(response);
            responseObserver.onCompleted();

        }
    }

}

