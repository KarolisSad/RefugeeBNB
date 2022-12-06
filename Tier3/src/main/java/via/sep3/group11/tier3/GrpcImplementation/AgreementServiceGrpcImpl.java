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
        System.out.println("ConvertedRequest: " + convertedRequest);
        Agreement dataResponse = agreementDao.addAgreement(convertedRequest);
        System.out.println(dataResponse);
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
    public void getAgreementByHostId(GEmail request, StreamObserver<getAllPendingAgreementsResponse> responseObserver)
    {
        List<Agreement> dataResponse = agreementDao.getAgreementsByHostId(request.getEmail());
        getAllPendingAgreementsResponse.Builder responseBuilder = getAllPendingAgreementsResponse.newBuilder();
        if (dataResponse.isEmpty())
        {
            responseObserver.onNext(getAllPendingAgreementsResponse.newBuilder().build());
            responseObserver.onCompleted();
        }
        else {
            for(int i = 0; i < dataResponse.size(); i++)
            {
                responseBuilder.addAgreements(agreementWithIdToGrpc(dataResponse.get(i)));
            }
            getAllPendingAgreementsResponse response = responseBuilder.build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void updateAgreement(GAgreement request, StreamObserver<GAgreement> responseObserver)
    {
        System.out.println("Request dates: REFUGEE" + request.getRefugee().getDateOfBirth());
        System.out.println("Request dates: HOST" + request.getHostDetails().getDateOfBirth());
        System.out.println("Request dates: Agreement" + request.getDateOfCreation());
        Agreement dataResponse = agreementDao.updateAgreement(agreementWithIdFromGrpc(request));
        System.out.println("DataResponse: " + dataResponse);
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
                responseBuilder.addAgreements(agreementToGrpc(dataResponse.get(i)));
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
                responseBuilder.addAgreements(agreementToGrpc(dataResponse.get(i)));
            }
            getAllPendingAgreementsResponse response = responseBuilder.build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}



