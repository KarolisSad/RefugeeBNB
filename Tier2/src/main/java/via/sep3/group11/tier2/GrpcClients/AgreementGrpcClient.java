package via.sep3.group11.tier2.GrpcClients;

import io.grpc.StatusRuntimeException;
import via.sep3.group11.tier2.CommunicationInterfaces.AgreementCommunicationInterface;
import via.sep3.group11.tier2.GrpcClients.connections.Channel;
import via.sep3.group11.tier2.GrpcClients.converters.GrpcConverter;
import via.sep3.group11.tier2.protobuf.*;
import via.sep3.group11.tier2.shared.domain.Agreement;
import via.sep3.group11.tier2.shared.exceptions.ValidationException;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class AgreementGrpcClient implements AgreementCommunicationInterface {

    @Resource
    Channel channel;

    @Override
    public Agreement addAgreement(Agreement agreement) throws ValidationException {
       try {
           GAgreement request = GrpcConverter.AgreementToGrpc(agreement);
           GAgreement response = channel.getAgreementStub().withDeadlineAfter(1, TimeUnit.SECONDS).addAgreement(request);
           return GrpcConverter.AgreementWithIdFromGrpc(response);
       }
       catch (StatusRuntimeException e)
       {
           reestablishConnection();
           return null;
       }
    }

    @Override
    public Agreement updateAgreement(Agreement agreement) throws ValidationException{
        try {
            GAgreement request = GAgreement.newBuilder().build();
            GAgreement response = channel.getAgreementStub().withDeadlineAfter(1, TimeUnit.SECONDS).updateAgreement(request);
            if (response.equals(agreement))
            {
                return agreement;
            }
            return GrpcConverter.AgreementWithIdFromGrpc(response);
        }
        catch (StatusRuntimeException e)
        {
            reestablishConnection();
            return null;
        }

    }

    @Override
    public Optional<Agreement> getAgreementById(long agreementId) throws ValidationException  {
        try{
            GId request = GId.newBuilder().setId(agreementId).build();
            GAgreement response = channel.getAgreementStub().withDeadlineAfter(1, TimeUnit.SECONDS).getAgreementById(request);
            if (response == null){
                return Optional.empty();
            }
            return Optional.of(GrpcConverter.AgreementWithIdFromGrpc(response));
        }
        catch (StatusRuntimeException e)
        {
            reestablishConnection();
            return null;
        }
    }

    @Override
    public List<Agreement> getAgreementByHostId(String hostId) throws ValidationException{
        try {
            GEmail request = GEmail.newBuilder().setEmail(hostId).build();
            getAllPendingAgreementsResponse response = channel.getAgreementStub().withDeadlineAfter(1, TimeUnit.SECONDS).getAgreementByHostId(request);
            List<Agreement> agreements = new ArrayList<>();
            for (int i = 0; i < response.getAgreementsCount(); i++)
            {
                agreements.add(GrpcConverter.AgreementWithIdFromGrpc(response.getAgreements(i)));
            }
            return agreements;
        }
        catch (StatusRuntimeException e) {
            reestablishConnection();
            return null;
        }
    }

    @Override
    public void deleteAgreement(long agreementId) {
        try {
            GId request = GId.newBuilder().setId(agreementId).build();
            channel.getAgreementStub().withDeadlineAfter(1, TimeUnit.SECONDS).deleteAgreement(request);
        }
        catch (StatusRuntimeException e)
        {
            reestablishConnection();
        }

    }

    //TODO method getAllPendingAgreements() is the same as getAgreementsByHostId
    @Override
    public List<Agreement> getAllPendingAgreements(String hostEmail) {
        return null;
    }

    @Override
    public List<Agreement> getAllAgreementsByHousingId(Long housingId) throws ValidationException{
        try {
            GId request = GId.newBuilder().setId(housingId).build();
                getAllPendingAgreementsResponse response = channel.getAgreementStub().withDeadlineAfter(1, TimeUnit.SECONDS).getAllAgreementByHousingId(request);
            List<Agreement> agreements = new ArrayList<>();
            for (int i = 0; i < response.getAgreementsCount(); i++)
            {
                agreements.add(GrpcConverter.AgreementWithIdFromGrpc(response.getAgreements(i)));
            }
            return agreements;
        }
        catch (StatusRuntimeException e) {
            reestablishConnection();
            return null;
        }
    }

    public void reestablishConnection() {
        channel.createChannel();
    }
}


