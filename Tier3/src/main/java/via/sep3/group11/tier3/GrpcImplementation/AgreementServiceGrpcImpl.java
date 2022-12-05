package via.sep3.group11.tier3.GrpcImplementation;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import via.sep3.group11.tier3.GrpcImplementation.converters.GrpcConverter;
import via.sep3.group11.tier3.model.Agreement;
import via.sep3.group11.tier3.protobuf.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

import static via.sep3.group11.tier3.GrpcImplementation.converters.GrpcConverter.*;

@GRpcService
public class AgreementServiceGrpcImpl extends AgreementGrpc.AgreementImplBase {

    @Resource
    AgreementDaoInterface agreementDao;

    @Override
    public void addAgreement (GAgreement request, StreamObserver<GAgreement> responseObserver)
    {
        Agreement convertedRequest = GrpcConverter.AgreementFromGrpc(request);
        Agreement dataResponse = agreementDao.addAgreement(convertedRequest);
        GAgreement response = AgreementToGrpc(dataResponse);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getAgreementById(GId request, StreamObserver<GAgreement> responseObserver)
    {
        Optional<Agreement> dataResponse = agreementDao.getAgreementById(request.getId());
        if (dataResponse.isEmpty())
        {
            responseObserver.onNext(GAgreement.newBuilder().build());
            responseObserver.onCompleted();
        }
        else {
            GAgreement agreement = AgreementToGrpc(dataResponse.get());
            responseObserver.onNext(agreement);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void getAgreementByHostId(GEmail request, StreamObserver<getAllPendingAgreementsResponse> responseObserver)
    {
        List<Agreement> dataResponse = agreementDao.getAgreementByHostId(request.getEmail());
        getAllPendingAgreementsResponse.Builder responseBuilder = getAllPendingAgreementsResponse.newBuilder();
        if (dataResponse.isEmpty())
        {
            responseObserver.onNext(getAllPendingAgreementsResponse.newBuilder().build());
            responseObserver.onCompleted();
        }
        else {
            for(int i = 0; i < dataResponse.size(); i++)
            {
                responseBuilder.addAgreements(AgreementToGrpc(dataResponse.get(i)));
            }
            getAllPendingAgreementsResponse response = responseBuilder.build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void updateAgreement(GAgreement request, StreamObserver<GAgreement> responseObserver)
    {
        Optional<Agreement> dataResponse = agreementDao.updateAgreement(AgreementWithIdFromGrpc(request));
        if (dataResponse.isEmpty())
        {
            responseObserver.onNext(GAgreement.newBuilder().build());
            responseObserver.onCompleted();
        }
        else {
            GAgreement agreement = AgreementWithIdToGrpc(dataResponse.get());
            responseObserver.onNext(agreement);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void deleteAgreement(GId request, StreamObserver<Empty> responseObserver) {
            agreementDao.deleteAgreement(request.getId());
            responseObserver.onCompleted();
    }

    @Override
    public void getAllPendingAgreements(GEmail request, StreamObserver<getAllPendingAgreementsResponse> responseObserver) {
        List<Agreement> dataResponse = agreementDao.getAllPendingAgreements(request.getEmail());
        getAllPendingAgreementsResponse.Builder responseBuilder = getAllPendingAgreementsResponse.newBuilder();
        if (dataResponse.isEmpty())
        {
            responseObserver.onNext(getAllPendingAgreementsResponse.newBuilder().build());
            responseObserver.onCompleted();
        }
        else {
            for(int i = 0; i < dataResponse.size(); i++)
            {
                responseBuilder.addAgreements(AgreementToGrpc(dataResponse.get(i)));
            }
            getAllPendingAgreementsResponse response = responseBuilder.build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void getAllAgreementByHousingId(GId request, StreamObserver<getAllPendingAgreementsResponse> responseObserver) {
        List<Agreement> dataResponse = agreementDao.getAllAgreementsByHousingId(request.getId());
        getAllPendingAgreementsResponse.Builder responseBuilder = getAllPendingAgreementsResponse.newBuilder();
        if (dataResponse.isEmpty())
        {
            responseObserver.onNext(getAllPendingAgreementsResponse.newBuilder().build());
            responseObserver.onCompleted();
        }
        else {
            for(int i = 0; i < dataResponse.size(); i++)
            {
                responseBuilder.addAgreements(AgreementToGrpc(dataResponse.get(i)));
            }
            getAllPendingAgreementsResponse response = responseBuilder.build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}



