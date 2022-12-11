package via.sep3.group11.tier3.GrpcImplementation;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import via.sep3.group11.tier3.GrpcImplementation.converters.GrpcConverter;
import via.sep3.group11.tier3.model.Refugee;
import via.sep3.group11.tier3.protobuf.GEmpty;
import via.sep3.group11.tier3.protobuf.GEmail;
import via.sep3.group11.tier3.protobuf.GRefugee;
import via.sep3.group11.tier3.protobuf.RefugeeGrpc;
import via.sep3.group11.tier3.DAO.DAOInterfaces.RefugeeDaoInterface;

import javax.annotation.Resource;
import java.util.Optional;

import static via.sep3.group11.tier3.GrpcImplementation.converters.GrpcConverter.refugeeFromGrpc;
import static via.sep3.group11.tier3.GrpcImplementation.converters.GrpcConverter.refugeeToGrpc;

@GRpcService
public class RefugeeServiceGrpcImpl extends RefugeeGrpc.RefugeeImplBase {

    @Resource
    RefugeeDaoInterface refugeeDao;

    @Override
    public void createRefugee(GRefugee request, StreamObserver<GRefugee> responseObserver) {
        Refugee convertedRequest = refugeeFromGrpc(request);
        Refugee dataResponse = refugeeDao.createRefugee(convertedRequest);
        GRefugee response = GrpcConverter.refugeeToGrpc(dataResponse);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getRefugeeByEmail(GEmail request, StreamObserver<GRefugee> responseObserver) {
        Optional<Refugee> dataResponse = refugeeDao.getRefugeeByEmail(request.getEmail());
        if (dataResponse.isEmpty())
        {
            responseObserver.onNext(GRefugee.newBuilder().build());
            responseObserver.onCompleted();
        }
        else {
            GRefugee response = GrpcConverter.refugeeToGrpc(dataResponse.get());
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void deleteAccount(GEmail request, StreamObserver<GEmpty> responseObserver) {
        refugeeDao.deleteAccount(request.getEmail());
        // Todo added this onNext statement to prevent Grpc Warning on each call.
        responseObserver.onNext(GEmpty.newBuilder().build());
        responseObserver.onCompleted();
    }


    @Override
    public void updateInformation(GRefugee request, StreamObserver<GRefugee> responseObserver) {

    Refugee refugeeResponse = refugeeDao.updateInformation(refugeeFromGrpc(request));

        if (refugeeResponse == null) {
            responseObserver.onNext(GRefugee.newBuilder().build());
            responseObserver.onCompleted();
        }
        else {
            responseObserver.onNext(refugeeToGrpc(refugeeResponse));
            responseObserver.onCompleted();
        }
    }

}
