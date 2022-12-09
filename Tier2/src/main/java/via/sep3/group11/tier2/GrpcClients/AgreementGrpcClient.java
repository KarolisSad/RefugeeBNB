package via.sep3.group11.tier2.GrpcClients;

import io.grpc.StatusRuntimeException;
import org.lognet.springboot.grpc.GRpcService;
import via.sep3.group11.tier2.CommunicationInterfaces.AgreementCommunicationInterface;
import via.sep3.group11.tier2.GrpcClients.connections.Channel;
import via.sep3.group11.tier2.GrpcClients.converters.GrpcConverter;
import via.sep3.group11.tier2.protobuf.GAgreement;
import via.sep3.group11.tier2.protobuf.GAgreementList;
import via.sep3.group11.tier2.protobuf.GEmail;
import via.sep3.group11.tier2.protobuf.GId;
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
           GAgreement request = GrpcConverter.agreementToGrpc(agreement);
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
            GId request = GId.newBuilder().setId(agreementId).build();
            GAgreement response = channel.getAgreementStub().withDeadlineAfter(1, TimeUnit.SECONDS).getAgreementById(request);
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
            GAgreementList response = channel.getAgreementStub().withDeadlineAfter(1, TimeUnit.SECONDS).getAgreementByHostId(request);
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

    @Override
    public List<Agreement> getAllAgreementsByHousingId(long housingId) {
        try {
            GId request = GId.newBuilder().setId(housingId).build();
            GAgreementList response = channel.getAgreementStub().withDeadlineAfter(1, TimeUnit.SECONDS).getAllAgreementByHousingId(request);
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
    public Optional<Agreement> getAgreementByRefugeeEmail(String email) {
        try{
            GEmail request = GEmail.newBuilder().setEmail(email).build();
            GAgreement response = channel.getAgreementStub().withDeadlineAfter(1, TimeUnit.SECONDS).getAgreementByRefugeeId(request);


            if (!response.hasRefugee()) {
                return Optional.empty();
            }

            //Todo was not working because of this. The Grpc response was not null - it was empty.
/*
            if (response == null){
                return Optional.empty();
            }
 */
            return Optional.of(GrpcConverter.agreementWithIdFromGrpc(response));
        }
        catch (StatusRuntimeException e)
        {
            reestablishConnection();
            return null;
        }
    }

    public void reestablishConnection() {
        channel.createChannel();
    }
}




