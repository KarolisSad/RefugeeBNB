package via.sep3.group11.tier2.daoImplementation;

import io.grpc.StatusRuntimeException;
import org.lognet.springboot.grpc.GRpcService;
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

@GRpcService
public class HousingDaoImpl implements HousingDaoInterface {

    @Resource
    Channel channel;

    @Override
    public Housing AddHousing(Housing housing, String email) throws ValidationException {
        try {
            GAddHousingRequest request = GrpcConverter.AddHousingRequest(housing, email);
            GHousing response = channel.getHousingStub().withDeadlineAfter(1, TimeUnit.SECONDS).addHousing(request);
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
