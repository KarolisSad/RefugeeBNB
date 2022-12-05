package via.sep3.group11.tier2.GrpcClients;

import io.grpc.StatusRuntimeException;
import org.lognet.springboot.grpc.GRpcService;
import via.sep3.group11.tier2.GrpcClients.connections.Channel;
import via.sep3.group11.tier2.GrpcClients.converters.GrpcConverter;
import via.sep3.group11.tier2.CommunicationInterfaces.RefugeeCommunicationInterface;
import via.sep3.group11.tier2.protobuf.GEmail;
import via.sep3.group11.tier2.protobuf.GRefugee;
import via.sep3.group11.tier2.shared.domain.Refugee;
import via.sep3.group11.tier2.shared.exceptions.ValidationException;

import javax.annotation.Resource;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@GRpcService
public class RefugeeGrpcClient implements RefugeeCommunicationInterface {

    @Resource
    Channel channel;

    @Override
    public Refugee createRefugee(Refugee refugee) {
        try {
            GRefugee request = GrpcConverter.refugeeToGrpc(refugee);
            GRefugee response = channel.getRefugeeStub().withDeadlineAfter(1, TimeUnit.SECONDS).createRefugee(request);
            if (response.getEmail().isEmpty())
            {
                return null;
            }
            return GrpcConverter.refugeeFromGrpc(response);
        }
        catch (StatusRuntimeException e)
        {
            reestablishConnection();
            return null;
        }
    }

    @Override
    public Optional<Refugee> getRefugeeByEmail(String email) throws ValidationException {
        try {
            GEmail request = GEmail.newBuilder().setEmail(email).build();
            GRefugee response = channel.getRefugeeStub().withDeadlineAfter(1, TimeUnit.SECONDS).getRefugeeByEmail(request);
            if (response.getEmail().isEmpty()) {
                return Optional.empty();
            }

            return Optional.of(GrpcConverter.refugeeFromGrpc(response));
        }
        catch (StatusRuntimeException e)
        {
            reestablishConnection();
            return null;
        }
    }

    private void reestablishConnection() {
        channel.createChannel();
    }
}
