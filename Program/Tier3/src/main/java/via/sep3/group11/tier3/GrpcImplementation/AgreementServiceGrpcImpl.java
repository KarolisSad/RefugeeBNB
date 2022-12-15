package via.sep3.group11.tier3.GrpcImplementation;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import via.sep3.group11.tier3.DAO.DAOInterfaces.AgreementDaoInterface;
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
        Agreement convertedRequest = GrpcConverter.agreementFromGrpc(request);
        Agreement dataResponse = agreementDao.addAgreement(convertedRequest);
        GAgreement response = agreementWithIdToGrpc(dataResponse);
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
            GAgreement agreement = agreementWithIdToGrpc(dataResponse.get());
            responseObserver.onNext(agreement);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void getAgreementByHostId(GEmail request, StreamObserver<GAgreementList> responseObserver)
    {
        List<Agreement> dataResponse = agreementDao.getAgreementsByHostId(request.getEmail());
        GAgreementList.Builder responseBuilder = GAgreementList.newBuilder();
        if (dataResponse.isEmpty())
        {
            responseObserver.onNext(GAgreementList.newBuilder().build());
            responseObserver.onCompleted();
        }
        else {
            for(int i = 0; i < dataResponse.size(); i++)
            {
                responseBuilder.addAgreements(agreementWithIdToGrpc(dataResponse.get(i)));
            }
            GAgreementList response = responseBuilder.build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void updateAgreement(GAgreement request, StreamObserver<GAgreement> responseObserver)
    {
        Agreement dataResponse = agreementDao.updateAgreement(agreementWithIdFromGrpc(request));

        if (dataResponse == null)
        {
            responseObserver.onNext(GAgreement.newBuilder().build());
            responseObserver.onCompleted();
        }
        else {
            GAgreement agreement = agreementWithIdToGrpc(dataResponse);
            responseObserver.onNext(agreement);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void deleteAgreement(GId request, StreamObserver<GEmpty> responseObserver) {
            agreementDao.deleteAgreement(request.getId());
            responseObserver.onCompleted();
    }

    @Override
    public void getAllAgreementByHousingId(GId request, StreamObserver<GAgreementList> responseObserver) {
        List<Agreement> dataResponse = agreementDao.getAllAgreementsByHousingId(request.getId());
        GAgreementList.Builder responseBuilder = GAgreementList.newBuilder();
        if (dataResponse.isEmpty())
        {
            responseObserver.onNext(GAgreementList.newBuilder().build());
            responseObserver.onCompleted();
        }
        else {
            for(int i = 0; i < dataResponse.size(); i++)
            {
                responseBuilder.addAgreements(agreementToGrpc(dataResponse.get(i)));
            }
            GAgreementList response = responseBuilder.build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void getAgreementByRefugeeId(GEmail request, StreamObserver<GAgreement> responseObserver) {
        Optional<Agreement> dataResponse = agreementDao.getAgreementByRefugeeEmail(request.getEmail());

        if(dataResponse.isEmpty())
        {
            responseObserver.onNext(GAgreement.newBuilder().build());
            responseObserver.onCompleted();
        }
        else {
            GAgreement agreement = GrpcConverter.agreementWithIdToGrpc(dataResponse.get());
            responseObserver.onNext(agreement);
            responseObserver.onCompleted();
        }
    }
}



