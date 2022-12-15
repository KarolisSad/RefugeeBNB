package via.sep3.group11.tier3.GrpcImplementation;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import via.sep3.group11.tier3.GrpcImplementation.converters.GrpcConverter;
import via.sep3.group11.tier3.model.Host;
import via.sep3.group11.tier3.DAO.DAOInterfaces.HostDaoInterface;
import via.sep3.group11.tier3.protobuf.*;

import javax.annotation.Resource;
import java.util.Optional;

import static via.sep3.group11.tier3.GrpcImplementation.converters.GrpcConverter.hostDetailsFromGrpc;
import static via.sep3.group11.tier3.GrpcImplementation.converters.GrpcConverter.hostToGrpc;

@GRpcService
public class HostServiceGrpcImpl extends HostGrpc.HostImplBase {

    @Resource
    HostDaoInterface hostDaoInterface;

    @Override
    public void createHost(GHost request, StreamObserver<GHost> responseObserver) {
        responseObserver.onNext(GrpcConverter.hostToGrpc(
                hostDaoInterface.createHost(GrpcConverter.hostFromGrpc(request))));
        responseObserver.onCompleted();

        //                Host convertedRequest = GrpcConverter.HostFromGrpc(request);
        //                Host dataResponse = hostDaoInterface.createHost(convertedRequest);
        //                GHost response = GrpcConverter.HostToGrpc(dataResponse);
        //                responseObserver.onNext(response);
        //                responseObserver.onCompleted();
    }

    @Override
    public void getHostByEmail(GEmail request, StreamObserver<GHost> responseObserver) {
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
    public void getHostByHousingId(GId request, StreamObserver<GHost> responseObserver) {
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

    @Override
    public void deleteAccount(GEmail request, StreamObserver<GEmpty> responseObserver) {
        hostDaoInterface.deleteAccount(request.getEmail());
        // Todo added this onNext statement to prevent Grpc Warning on each call.
        responseObserver.onNext(GEmpty.newBuilder().build());
        responseObserver.onCompleted();
    }


    @Override
    public void updateInformation(GHostDetails request, StreamObserver<GHost> responseObserver) {

        Host hostResponse = hostDaoInterface.updateInformation(hostDetailsFromGrpc(request));

        if (hostResponse == null) {
            responseObserver.onNext(GHost.newBuilder().build());
            responseObserver.onCompleted();
        }
        else {
            responseObserver.onNext(hostToGrpc(hostResponse));
            responseObserver.onCompleted();
        }
    }
}

