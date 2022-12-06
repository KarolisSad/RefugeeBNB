package via.sep3.group11.tier2.GrpcClients;

import io.grpc.StatusRuntimeException;
import org.lognet.springboot.grpc.GRpcService;
import via.sep3.group11.tier2.CommunicationInterfaces.AgreementCommunicationInterface;
import via.sep3.group11.tier2.GrpcClients.connections.Channel;
import via.sep3.group11.tier2.GrpcClients.converters.GrpcConverter;
import via.sep3.group11.tier2.protobuf.*;
import via.sep3.group11.tier2.shared.domain.Agreement;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@GRpcService
public class AgreementGrpcClient implements AgreementCommunicationInterface {

    @Resource
    Channel channel;

    @Override
    public Agreement addAgreement(Agreement agreement) {
       try {
           System.out.println("Logic housing id: " + agreement.getHousing().getHousingId());
           GAgreement request = GrpcConverter.agreementToGrpc(agreement);
           System.out.println("Request: " + request.getHousing().getId());
           GAgreement response = channel.getAgreementStub().withDeadlineAfter(1, TimeUnit.SECONDS).addAgreement(request);
           return GrpcConverter.agreementWithIdFromGrpc(response);
       }
       catch (StatusRuntimeException e)
       {
           reestablishConnection();
           return null;
       }
    }

    @Override
    public Agreement updateAgreement(Agreement agreement) {
        try {
            System.out.println("AgreementGrpcClient agreement: " + agreement);
            GAgreement request = GrpcConverter.agreementWithIdToGrpc(agreement);
            GAgreement response = channel.getAgreementStub().withDeadlineAfter(1, TimeUnit.SECONDS).updateAgreement(request);
            if (response.equals(agreement))
            {
                return agreement;
            }
            return GrpcConverter.agreementWithIdFromGrpc(response);
        }
        catch (StatusRuntimeException e)
        {
            reestablishConnection();
            return null;
        }

    }

    @Override
    public Optional<Agreement> getAgreementById(long agreementId) {
        try{
            System.out.println("AgreeGrpcClient ID: " + agreementId);
            GId request = GId.newBuilder().setId(agreementId).build();
            System.out.println("GID Request Id: " + request.getId());
            GAgreement response = channel.getAgreementStub().withDeadlineAfter(1, TimeUnit.SECONDS).getAgreementById(request);
            System.out.println("AgreeGrpc return Id: " + response.getId());
            if (response == null){
                return Optional.empty();
            }
            return Optional.of(GrpcConverter.agreementWithIdFromGrpc(response));
        }
        catch (StatusRuntimeException e)
        {
            reestablishConnection();
            return null;
        }
    }

    @Override
    public List<Agreement> getAgreementsByHostId(String hostId) {
        try {
            GEmail request = GEmail.newBuilder().setEmail(hostId).build();
            getAllPendingAgreementsResponse response = channel.getAgreementStub().withDeadlineAfter(1, TimeUnit.SECONDS).getAgreementByHostId(request);
            List<Agreement> agreements = new ArrayList<>();
            for (int i = 0; i < response.getAgreementsCount(); i++)
            {
                agreements.add(GrpcConverter.agreementWithIdFromGrpc(response.getAgreements(i)));
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
    public List<Agreement> getAllAgreementsByHousingId(long housingId) {
        try {
            GId request = GId.newBuilder().setId(housingId).build();
                getAllPendingAgreementsResponse response = channel.getAgreementStub().withDeadlineAfter(1, TimeUnit.SECONDS).getAllAgreementByHousingId(request);
            List<Agreement> agreements = new ArrayList<>();
            for (int i = 0; i < response.getAgreementsCount(); i++)
            {
                agreements.add(GrpcConverter.agreementWithIdFromGrpc(response.getAgreements(i)));
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


