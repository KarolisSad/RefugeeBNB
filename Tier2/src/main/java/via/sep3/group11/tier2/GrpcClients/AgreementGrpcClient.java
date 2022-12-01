package via.sep3.group11.tier2.GrpcClients;

import io.grpc.StatusRuntimeException;
import via.sep3.group11.tier2.CommunicationInterfaces.AgreementCommunicationInterface;
import via.sep3.group11.tier2.GrpcClients.connections.Channel;
import via.sep3.group11.tier2.GrpcClients.converters.GrpcConverter;
import via.sep3.group11.tier2.protobuf.GAgreement;
import via.sep3.group11.tier2.protobuf.GEmail;
import via.sep3.group11.tier2.protobuf.GId;
import via.sep3.group11.tier2.shared.exceptions.ValidationException;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class AgreementGrpcClient implements AgreementCommunicationInterface {

    @Resource
    Channel channel;

    @Override
    public Agreement addAgreement(Agreement agreement) throws ValidationException {
       try {
           GAgreement request = GrpcConverter.agreementToGrpc(agreement);
           GAgreement response = channel.getAgreementStub().withDeadlineAfter(1, TimeUnit.SECONDS).addAgreement(request);
           return GrpcConverter.agreementFromGrpc(response);
       }
       catch (StatusRuntimeException e)
       {
           reestablishConnection();
           return null;
       }
    }

    @Override
    public Agreement updateAgreement(Agreement agreement) {
        return null;
    }

    @Override
    public Optional<Agreement> getAgreementById(long agreementId) {
        try{
            GId request = GId.newBuilder().setId(agreementId).build();
            GAgreement response = channel.getAgreementStub().withDeadlineAfter(1, TimeUnit.SECONDS).getAgreementById(request);
            if (response.getId().isEmpty()){
                return Optional.empty();
            }
            return Optional.of(GrpcConverter.agreementFromGrpc(response));
        }
        catch (StatusRuntimeException e)
        {
            reestablishConnection();
            return null;
        }
    }

    @Override
    public List<Agreement> getAgreementByHostId(String hostId) {
        try{
            GEmail request = GEmail.newBuilder().setEmail(hostId).build();
            List<GAgreement> response = channel.getAgreementStub().withDeadlineAfter(1, TimeUnit.SECONDS).getAgreementByHostId(request);
    }

    @Override
    public void deleteAgreement(long agreementId) {

    }

    public void reestablishConnection() {
        channel.createChannel();
    }
}


