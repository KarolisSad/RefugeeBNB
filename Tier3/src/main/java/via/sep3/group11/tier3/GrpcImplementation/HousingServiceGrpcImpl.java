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

import static via.sep3.group11.tier3.GrpcImplementation.converters.GrpcConverter.*;

@GRpcService
public class HousingServiceGrpcImpl extends HousingGrpc.HousingImplBase {

    @Resource
    HousingDaoInterface housingDaoInterface;

    @Override
    public void addHousing(GAddHousingRequest request, StreamObserver<GHousing> responseObserver)
    {
        Housing housingRequest = GrpcConverter.housingFromGrpc(request.getHousing());
        Housing toSend = housingDaoInterface.addHousing(housingRequest,request.getEmail());
        GHousing response = GrpcConverter.housingToGrpc(toSend);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getAvailableHousing(Empty request, StreamObserver<ListOfAvailableHousing> responseObserver) {
        List<Housing> dataResponse = housingDaoInterface.getAvailableHousing();
        ListOfAvailableHousing.Builder responseBuilder = ListOfAvailableHousing.newBuilder();
        if (dataResponse.isEmpty())
        {
            responseObserver.onNext(ListOfAvailableHousing.newBuilder().build());
            responseObserver.onCompleted();
        }
        else {
            for(int i = 0; i < dataResponse.size(); i++)
            {
                responseBuilder.addHousings(housingToGrpc(dataResponse.get(i)));
            }
            ListOfAvailableHousing response = responseBuilder.build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void updateHousing(GHousing request, StreamObserver<GHousing> responseObserver)
    {
        Housing dataResponse = housingDaoInterface.updateHousing(housingFromGrpc(request));
        if (dataResponse == null)
        {
            responseObserver.onNext(GHousing.newBuilder().build());
            responseObserver.onCompleted();
        }
        else {
            GHousing housing = housingToGrpc(dataResponse);
            responseObserver.onNext(housing);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void removeHousing(GId request, StreamObserver<Empty> responseObserver) {
        housingDaoInterface.removeHousing(request.getId());
        responseObserver.onCompleted();
    }

    @Override
    public void getHousingById(GId request, StreamObserver<GHousing> responseObserver)
    {
        Optional<Housing> dataResponse = housingDaoInterface.getHousingById(request.getId());

        System.out.println("Housing id: " + dataResponse.get().getHousingId());
        if (dataResponse.isEmpty())
        {
            responseObserver.onNext(GHousing.newBuilder().build());
            responseObserver.onCompleted();
        }
        else {
            GHousing housing = housingToGrpc(dataResponse.get());
            System.out.println("HousingID After convert: " + housing.getId());
            responseObserver.onNext(housing);
            responseObserver.onCompleted();
        }
    }
}


