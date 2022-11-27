package via.sep3.group11.tier2.daoImplementation;

import io.grpc.StatusRuntimeException;
import org.springframework.context.annotation.Configuration;
import via.sep3.group11.tier2.daoImplementation.connections.Channel;
import via.sep3.group11.tier2.daoImplementation.converters.GrpcConverter;
import via.sep3.group11.tier2.daoInterfaces.RefugeeDaoInterface;
import via.sep3.group11.tier2.protobuf.GEmail;
import via.sep3.group11.tier2.protobuf.GRefugee;
import via.sep3.group11.tier2.shared.domain.Refugee;
import via.sep3.group11.tier2.shared.exceptions.ValidationException;
import javax.annotation.Resource;

@Configuration
public class RefugeeDaoImpl implements RefugeeDaoInterface {

    @Resource
    Channel channel;

    @Override
    public Refugee CreateRefugee(Refugee refugee) throws ValidationException {
        try {
            GRefugee request = GrpcConverter.RefugeeToGrpc(refugee);
            GRefugee response = channel.getRefugeeStub().createRefugee(request);
            return GrpcConverter.RefugeeFromGrpc(response);
        }
        catch (StatusRuntimeException e)
        {
            reestablishConnection();
            return null;
        }
    }

    @Override
    public Refugee GetRefugeeByEmail(String email) throws ValidationException {
        try {
            GEmail request = GEmail.newBuilder().setEmail(email).build();
            GRefugee response = channel.getRefugeeStub().getRefugeeByEmail(request);
            return GrpcConverter.RefugeeFromGrpc(response);
        }
        catch (StatusRuntimeException e)
        {
            reestablishConnection();
            return null;
        }
    }

    private void reestablishConnection() {
        channel.CreateChannel();
    }
}
