package via.sep3.group11.tier2.GrpcClients;

import io.grpc.StatusRuntimeException;
import org.lognet.springboot.grpc.GRpcService;
import via.sep3.group11.tier2.GrpcClients.connections.Channel;
import via.sep3.group11.tier2.GrpcClients.converters.GrpcConverter;
import via.sep3.group11.tier2.CommunicationInterfaces.HostCommunicationInterface;
import via.sep3.group11.tier2.protobuf.*;
import via.sep3.group11.tier2.shared.domain.Host;

import javax.annotation.Resource;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import static via.sep3.group11.tier2.GrpcClients.converters.GrpcConverter.*;

@GRpcService
public class HostGrpcClient implements HostCommunicationInterface {

    @Resource
    Channel channel;

    @Override
    public Host createHost(Host host) {
        try {
            GHost request = GrpcConverter.hostToGrpc(host);
            GHost response = channel.getHostStub().withDeadlineAfter(1, TimeUnit.SECONDS).createHost(request);
            if (response == null) {
                return null;
            }
            return hostFromGrpc(response);
        } catch (StatusRuntimeException e) {
            reestablishConnection();
            return null;
        }
    }

    @Override
    public Optional<Host> getHostByEmail(String email) {
        try {
            GEmail request = GEmail.newBuilder().setEmail(email).build();
            GHost response = channel.getHostStub().withDeadlineAfter(1, TimeUnit.SECONDS).getHostByEmail(request);
            if (response.getEmail().isEmpty()) {
                return Optional.empty();
            }
            return Optional.of(hostFromGrpc(response));
        } catch (StatusRuntimeException e) {
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
            return Optional.of(hostFromGrpc(response));
        } catch (StatusRuntimeException e) {
            reestablishConnection();
            return null;
        }
    }

    @Override
    public void deleteAccount(String email) {
        try {
            GEmail request = GEmail.newBuilder().setEmail(email).build();
            channel.getHostStub().withDeadlineAfter(1, TimeUnit.SECONDS).deleteAccount(request);
        } catch (StatusRuntimeException e) {
            reestablishConnection();
        }
    }

    @Override
    public Host updateInformation(Host host) {

        try {
            System.out.println("UPDATE CALLED GRPC");
            GHostDetails request = hostDetailsToGrpc(host);
            System.out.println("REQUEST MADE GRPC");
            GHost response = channel.getHostStub().withDeadlineAfter(1, TimeUnit.SECONDS).updateInformation(request);
            System.out.println("RESPONSE GOTTEN GRPC");
            System.out.println(response);
            return hostFromGrpc(response);
        } catch (StatusRuntimeException e) {
            reestablishConnection();
            return null;
        }
    }

    public void reestablishConnection() {
        channel.createChannel();
    }
}

