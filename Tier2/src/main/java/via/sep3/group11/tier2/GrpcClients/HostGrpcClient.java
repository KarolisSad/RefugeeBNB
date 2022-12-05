package via.sep3.group11.tier2.GrpcClients;

import io.grpc.StatusRuntimeException;
import org.lognet.springboot.grpc.GRpcService;
import via.sep3.group11.tier2.GrpcClients.connections.Channel;
import via.sep3.group11.tier2.GrpcClients.converters.GrpcConverter;
import via.sep3.group11.tier2.CommunicationInterfaces.HostCommunicationInterface;
import via.sep3.group11.tier2.protobuf.GEmail;
import via.sep3.group11.tier2.protobuf.GHost;
import via.sep3.group11.tier2.protobuf.GId;
import via.sep3.group11.tier2.shared.domain.Host;
import via.sep3.group11.tier2.shared.exceptions.ValidationException;

import javax.annotation.Resource;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@GRpcService
public class HostGrpcClient implements HostCommunicationInterface {

    @Resource
    Channel channel;

    @Override
    public Host createHost(Host host) {

        try {
            GHost request = GrpcConverter.hostToGrpc(host);
            GHost response = channel.getHostStub().withDeadlineAfter(1, TimeUnit.SECONDS).createHost(request);
            if (response == null)
            {
                return null;
            }
            return GrpcConverter.hostFromGrpc(response);
        }
        catch (StatusRuntimeException e)
        {
            reestablishConnection();
            return null;
        }
    }

    @Override
    public Optional<Host> getHostByEmail(String email) {

        try {
            GEmail request = GEmail.newBuilder().setEmail(email).build();
            GHost response = channel.getHostStub().withDeadlineAfter(1, TimeUnit.SECONDS).getHostByEmail(request);
            if (response == null) {
                return Optional.empty();
            }
            return Optional.of(GrpcConverter.hostFromGrpc(response));
        }
        catch (StatusRuntimeException e)
        {
            reestablishConnection();
            return null;
        }
    }

    @Override
    public Optional<Host> getHostByHousingId(long housingId) {
        try {
            GId request = GId.newBuilder().setId(housingId).build();
            GHost response = channel.getHostStub().withDeadlineAfter(1, TimeUnit.SECONDS).getHostByHousingId(request);
            if (response == null) {
                return Optional.empty();
            }
            return Optional.of(GrpcConverter.hostFromGrpc(response));
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
