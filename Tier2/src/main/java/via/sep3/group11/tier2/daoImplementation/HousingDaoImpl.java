package via.sep3.group11.tier2.daoImplementation;

import io.grpc.StatusRuntimeException;
import org.springframework.context.annotation.Configuration;
import via.sep3.group11.tier2.daoImplementation.connections.Channel;
import via.sep3.group11.tier2.daoImplementation.converters.GrpcConverter;
import via.sep3.group11.tier2.daoInterfaces.HousingDaoInterface;
import via.sep3.group11.tier2.protobuf.GAddHousingRequest;
import via.sep3.group11.tier2.protobuf.GHousing;
import javax.annotation.Resource;

@Configuration
public class HousingDaoImpl implements HousingDaoInterface {

    @Resource
    Channel channel;

    @Override
    public Housing AddHousing(Housing housing, String email) {
        try {
            GAddHousingRequest request = GrpcConverter.AddHousingRequest(housing, email);
            GHousing response = channel.getHousingStub().addHousing(request);
            return GrpcConverter.HousingFromGrpc(response);
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
