package via.sep3.group11.tier3.GrpcImplementation;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import via.sep3.group11.tier3.GrpcImplementation.converters.GrpcConverter;
import via.sep3.group11.tier3.model.Refugee;
import via.sep3.group11.tier3.protobuf.GEmail;
import via.sep3.group11.tier3.protobuf.GRefugee;
import via.sep3.group11.tier3.protobuf.RefugeeGrpc;
import via.sep3.group11.tier3.services.servicesInterfaces.RefugeeDaoInterface;

import javax.annotation.Resource;
import java.util.Optional;

@GRpcService
public class RefugeeServiceGrpcImpl extends RefugeeGrpc.RefugeeImplBase {

    @Resource
    RefugeeDaoInterface refugeeDao;

    @Override
    public void createRefugee(GRefugee request, StreamObserver<GRefugee> responseObserver) {

        Refugee convertedRequest = GrpcConverter.RefugeeFromGrpc(request);
        Refugee dataResponse = refugeeDao.createRefugee(convertedRequest);
        GRefugee response = GrpcConverter.RefugeeToGrpc(dataResponse);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getRefugeeByEmail(GEmail request, StreamObserver<GRefugee> responseObserver)
    {
        Optional<Refugee> dataResponse = refugeeDao.getRefugeeByEmail(request.getEmail());
        if (dataResponse.isEmpty())
        {
            responseObserver.onNext(GRefugee.newBuilder().build());
            responseObserver.onCompleted();
        }
        else {
            GRefugee response = GrpcConverter.RefugeeToGrpc(dataResponse.get());
            responseObserver.onNext(response);
            responseObserver.onCompleted();

        }
    }
}
