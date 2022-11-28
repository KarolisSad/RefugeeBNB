package via.sep3.group11.tier3.GrpcImplementation;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import via.sep3.group11.tier3.GrpcImplementation.converters.GrpcConverter;
import via.sep3.group11.tier3.protobuf.GAddHousingRequest;
import via.sep3.group11.tier3.protobuf.GHousing;
import via.sep3.group11.tier3.protobuf.HousingGrpc;
import javax.annotation.Resource;

@GRpcService
public class HousingServiceGrpcImpl extends HousingGrpc.HousingImplBase {

    @Resource
    HousingDaoInterface housingDaoInterface;

    @Override
    public void addHousing(GAddHousingRequest request, StreamObserver<GHousing> responseObserver) {
    {
        Housing housingRequest = GrpcConverter.HousingFromGrpc(request.getHousing());
        Housing toSend = housingDaoInterface.addHousing(housingRequest,request.getEmail());
        GHousing response = GrpcConverter.HousingToGrpc(toSend);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    }
}
