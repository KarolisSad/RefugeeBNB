package via.sep3.group11.tier2;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import via.sep3.group11.tier2.CommunicationInterfaces.AgreementCommunicationInterface;
import via.sep3.group11.tier2.CommunicationInterfaces.HostCommunicationInterface;
import via.sep3.group11.tier2.CommunicationInterfaces.HousingCommunicationInterface;
import via.sep3.group11.tier2.CommunicationInterfaces.RefugeeCommunicationInterface;

@Profile("test")
@Configuration
public class MockTestConfiguration {

    @Bean
    @Primary
    public HostCommunicationInterface hostCommunicationInterface()
    {
        return Mockito.mock(HostCommunicationInterface.class);
    }

    @Bean
    @Primary
    public HousingCommunicationInterface housingCommunicationInterface()
    {
        return Mockito.mock(HousingCommunicationInterface.class);
    }
    @Bean
    @Primary
    public AgreementCommunicationInterface agreementCommunicationInterface()
    {
        return Mockito.mock(AgreementCommunicationInterface.class);
    }
    @Bean
    @Primary
    public RefugeeCommunicationInterface refugeeCommunicationInterface()
    {
        return Mockito.mock(RefugeeCommunicationInterface.class);
    }

}
