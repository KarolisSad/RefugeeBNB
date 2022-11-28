package via.sep3.group11.tier2.daoImplementation;

import io.grpc.StatusRuntimeException;
import org.springframework.context.annotation.Configuration;
import via.sep3.group11.tier2.daoImplementation.connections.Channel;
import via.sep3.group11.tier2.daoImplementation.converters.GrpcConverter;
import via.sep3.group11.tier2.daoInterfaces.HousingDaoInterface;
import via.sep3.group11.tier2.protobuf.GAddHousingRequest;
import via.sep3.group11.tier2.protobuf.GHousing;
import via.sep3.group11.tier2.shared.domain.Housing;
import via.sep3.group11.tier2.shared.exceptions.ValidationException;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Configuration
public class HousingDaoImpl implements HousingDaoInterface {

    @Resource
    Channel channel;

    @Override
    public Housing addHousing(Housing housing, String email) throws ValidationException {
        try {
            GAddHousingRequest request = GrpcConverter.addHousingRequest(housing, email);
            GHousing response = channel.getHousingStub().withDeadlineAfter(1, TimeUnit.SECONDS).addHousing(request);
            return GrpcConverter.housingFromGrpc(response);
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
