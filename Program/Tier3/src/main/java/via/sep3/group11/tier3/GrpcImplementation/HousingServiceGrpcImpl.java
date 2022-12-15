package via.sep3.group11.tier3.GrpcImplementation;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import via.sep3.group11.tier3.GrpcImplementation.converters.GrpcConverter;
import via.sep3.group11.tier3.model.Agreement;
import via.sep3.group11.tier3.model.Housing;
import via.sep3.group11.tier3.protobuf.*;
import via.sep3.group11.tier3.DAO.DAOInterfaces.HousingDaoInterface;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static via.sep3.group11.tier3.GrpcImplementation.converters.GrpcConverter.*;

@GRpcService
public class HousingServiceGrpcImpl extends HousingGrpc.HousingImplBase {

    @Resource
    HousingDaoInterface housingDaoInterface;

    @Override
    public void addHousing(GAddHousingRequest request, StreamObserver<GHousingWithStatus> responseObserver) {
        Housing housingRequest = GrpcConverter.housingFromGrpc(request.getHousing());
        Housing toSend = housingDaoInterface.addHousing(housingRequest,request.getEmail());
        GHousingWithStatus response = GrpcConverter.housingToGrpc(toSend);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getAvailableHousing(GEmpty request, StreamObserver<GListOfHousing> responseObserver) {
        List<Housing> dataResponse = housingDaoInterface.getAvailableHousing();
        GListOfHousing.Builder responseBuilder = GListOfHousing.newBuilder();
        if (dataResponse.isEmpty())
        {
            responseObserver.onNext(GListOfHousing.newBuilder().build());
            responseObserver.onCompleted();
        }
        else {
            for(int i = 0; i < dataResponse.size(); i++)
            {
                responseBuilder.addHousings(housingToGrpc(dataResponse.get(i)));
            }
            GListOfHousing response = responseBuilder.build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void updateHousing(GHousingWithStatus request, StreamObserver<GHousingWithStatus> responseObserver) {
        Housing dataResponse = housingDaoInterface.updateHousing(housingFromGrpcWithStatus(request));
        if (dataResponse == null)
        {
            responseObserver.onNext(GHousingWithStatus.newBuilder().build());
            responseObserver.onCompleted();
        }
        else {
            GHousingWithStatus housing = housingToGrpc(dataResponse);
            responseObserver.onNext(housing);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void removeHousing(GId request, StreamObserver<GEmpty> responseObserver) {
        housingDaoInterface.removeHousing(request.getId());
        responseObserver.onNext(GEmpty.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void getHousingById(GId request, StreamObserver<GHousingWithStatus> responseObserver) {
        Optional<Housing> dataResponse = housingDaoInterface.getHousingById(request.getId());
        if (dataResponse.isEmpty())
        {
            responseObserver.onNext(GHousingWithStatus.newBuilder().build());
            responseObserver.onCompleted();
        }
        else {
            GHousingWithStatus housing = housingToGrpc(dataResponse.get());
            responseObserver.onNext(housing);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void getAllHousingByHostId(GEmail request, StreamObserver<GListOfHousing> responseObserver) {
        List<Housing> dataResponse = housingDaoInterface.getAllHousingByHostId(request.getEmail());
        GListOfHousing.Builder responseBuilder = GListOfHousing.newBuilder();
        if (dataResponse.isEmpty())
        {
            responseObserver.onNext(GListOfHousing.newBuilder().build());
            responseObserver.onCompleted();
        }
        else {
            for(int i = 0; i < dataResponse.size(); i++)
            {
                responseBuilder.addHousings(housingToGrpc(dataResponse.get(i)));
            }
            GListOfHousing response = responseBuilder.build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}


