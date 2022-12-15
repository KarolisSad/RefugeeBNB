package via.sep3.group11.tier2.GrpcClients.connections;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import via.sep3.group11.tier2.protobuf.AgreementGrpc;
import via.sep3.group11.tier2.protobuf.HostGrpc;
import via.sep3.group11.tier2.protobuf.HousingGrpc;
import via.sep3.group11.tier2.protobuf.RefugeeGrpc;

@Service
@Scope("singleton")
public class Channel {


    private ManagedChannel managedChannel;
    private HostGrpc.HostBlockingStub hostStub;
    private RefugeeGrpc.RefugeeBlockingStub refugeeStub;
    private HousingGrpc.HousingBlockingStub housingStub;
    private AgreementGrpc.AgreementBlockingStub agreementStub;

    public Channel() {
        createChannel();
    }

    public void createChannel() {
        this.managedChannel = ManagedChannelBuilder
                .forAddress("localhost", 8084)
                .usePlaintext()
                .build();

        resetStubs();
    }

    private void resetStubs() {
        hostStub = null;
        refugeeStub = null;
        housingStub = null;
        agreementStub = null;
    }

    public HostGrpc.HostBlockingStub getHostStub() {
        if (hostStub == null) {
            this.hostStub = HostGrpc.newBlockingStub(managedChannel);
        }
        return hostStub;
    }

    public RefugeeGrpc.RefugeeBlockingStub getRefugeeStub() {
        if (refugeeStub == null) {
            this.refugeeStub = RefugeeGrpc.newBlockingStub(managedChannel);
        }
        return refugeeStub;
    }

    public HousingGrpc.HousingBlockingStub getHousingStub() {
        if (housingStub == null) {
            this.housingStub = HousingGrpc.newBlockingStub(managedChannel);
        }
        return housingStub;
    }

    public AgreementGrpc.AgreementBlockingStub getAgreementStub() {
        if (agreementStub == null) {
            this.agreementStub = AgreementGrpc.newBlockingStub(managedChannel);
        }
        return agreementStub;
    }
}
