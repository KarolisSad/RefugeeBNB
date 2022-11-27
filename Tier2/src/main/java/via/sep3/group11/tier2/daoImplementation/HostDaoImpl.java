package via.sep3.group11.tier2.daoImplementation;

import io.grpc.StatusRuntimeException;
import org.springframework.context.annotation.Configuration;
import via.sep3.group11.tier2.daoImplementation.connections.Channel;
import via.sep3.group11.tier2.daoImplementation.converters.GrpcConverter;
import via.sep3.group11.tier2.daoInterfaces.HostDaoInterface;
import via.sep3.group11.tier2.protobuf.GEmail;
import via.sep3.group11.tier2.protobuf.GHost;
import via.sep3.group11.tier2.shared.domain.Host;
import via.sep3.group11.tier2.shared.exceptions.ValidationException;
import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Configuration
public class HostDaoImpl implements HostDaoInterface{

    @Resource
    Channel channel;

    @Override
    public Host CreateHost(Host host) throws ValidationException {

        try {
            GHost request = GrpcConverter.HostToGrpc(host);
            GHost response = channel.getHostStub().createHost(request);
            return GrpcConverter.HostFromGrpc(response);
        }
        catch (StatusRuntimeException e)
        {
            reestablishConnection();
            return null;
        }
    }


    @Override
    public Host GetHostByEmail(String email) throws ValidationException {

        try {
            GEmail request = GEmail.newBuilder().setEmail(email).build();
            GHost response = channel.getHostStub().getHostByEmail(request);
            return GrpcConverter.HostFromGrpc(response);
        }
        catch (StatusRuntimeException e)
        {
            reestablishConnection();
            return null;
        }
    }

    public void reestablishConnection() {
        channel.CreateChannel();
    }
}
