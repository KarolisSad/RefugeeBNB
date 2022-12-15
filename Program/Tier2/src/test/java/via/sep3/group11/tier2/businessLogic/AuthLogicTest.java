package via.sep3.group11.tier2.businessLogic;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import via.sep3.group11.tier2.CommunicationInterfaces.AgreementCommunicationInterface;
import via.sep3.group11.tier2.CommunicationInterfaces.HostCommunicationInterface;
import via.sep3.group11.tier2.CommunicationInterfaces.HousingCommunicationInterface;
import via.sep3.group11.tier2.CommunicationInterfaces.RefugeeCommunicationInterface;
import via.sep3.group11.tier2.Tier2Application;
import via.sep3.group11.tier2.logicInterfaces.AuthInterface;
import via.sep3.group11.tier2.shared.DTOs.*;
import via.sep3.group11.tier2.shared.domain.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ActiveProfiles("test")
@SpringBootTest(classes = Tier2Application.class)
class AuthLogicTest {

    @Autowired
    HostCommunicationInterface hostCommunication;
    @Autowired
    HousingCommunicationInterface housingCommunicationInterface;
    @Autowired
    AgreementCommunicationInterface agreementCommunicationInterface;
    @Autowired
    RefugeeCommunicationInterface refugeeCommunication;

    @Autowired
    AuthInterface underTest;

    Host host1;
    Host host2;
    Host host3;
    Host host4;
    Host host5;

    Refugee refugee1;
    Refugee refugee2;
    Refugee refugee3;
    Refugee refugee4;
    Refugee refugee5;

    Housing availableHousing1;
    Housing availableHousing2;
    Housing availableHousing3;

    Housing notAvailableHousing4;
    Housing notAvailableHousing5;
    Housing notAvailableHousing6;

    List<Agreement> agreementList;
    List<Housing> housingList;

    @BeforeEach
    void setUp() {
        host1 = new Host("DummyHost1","dummyHost1@gmail.com","DummyHost1", 'O',"DummyHost1","DummyHost1","DummyHost1", new Date(01,01,2019));
        host2 = new Host("DummyHost2","dummyHost2@gmail.com","DummyHost2", 'O',"DummyHost2","DummyHost2","DummyHost2", new Date(01,01,2018));
        host3 = new Host("DummyHost3","dummyHost3@gmail.com","DummyHost3", 'O',"DummyHost3","DummyHost3","DummyHost3", new Date(01,01,2000));
        host4 = new Host("DummyHost4","dummyHost4@gmail.com","DummyHost4", 'O',"DummyHost4","DummyHost4","DummyHost4", new Date(01,01,2021));
        host5 = new Host("DummyHost5","dummyHost5@gmail.com","DummyHost5", 'O',"DummyHost5","DummyHost5","DummyHost5", new Date(01,01,2017));

        refugee1 = new Refugee("dummyRefugee1@gmail.com","DummyRefugee1",'O',"DummyRefugee1","DummyRefugee1","DummyRefugee1","DummyRefugee1",new Date(01,01,1999),1,"Amazing person!");
        refugee2 = new Refugee("dummyRefugee2@gmail.com","DummyRefugee2",'O',"DummyRefugee2","DummyRefugee2","DummyRefugee2","DummyRefugee2",new Date(01,01,2018),5,"Lovely family!");
        refugee3 = new Refugee("dummyRefugee3@gmail.com","DummyRefugee3",'O',"DummyRefugee3","DummyRefugee3","DummyRefugee3","DummyRefugee3",new Date(01,01,2018),2,"Nice couple!");
        refugee4 = new Refugee("dummyRefugee4@gmail.com","DummyRefugee4",'O',"DummyRefugee4","DummyRefugee4","DummyRefugee4","DummyRefugee4",new Date(01,01,2000),1,"Good chief!");
        refugee5 = new Refugee("dummyRefugee5@gmail.com","DummyRefugee5",'O',"DummyRefugee5","DummyRefugee5","DummyRefugee5","DummyRefugee5",new Date(01,01,2021),5,"Lovely family!");

        availableHousing1 = new Housing(1L,2,new Address("TestCountry1","TestCity1","TestStreet1","TestHouseNumber1","TestRoomNumber1","TestPostCode1"),true);
        availableHousing2 = new Housing(2L,2,new Address("TestCountry2","TestCity2","TestStreet2","TestHouseNumber2","TestRoomNumber2","TestPostCode2"),true);
        availableHousing3 = new Housing(3L,2,new Address("TestCountry3","TestCity3","TestStreet3","TestHouseNumber3","TestRoomNumber3","TestPostCode3"),true);

        notAvailableHousing4 = new Housing(4L,2,new Address("TestCountry4","TestCity4","TestStreet4","TestHouseNumber4","TestRoomNumber4","TestPostCode4"),false);
        notAvailableHousing5 = new Housing(5L,2,new Address("TestCountry5","TestCity5","TestStreet5","TestHouseNumber5","TestRoomNumber5","TestPostCode5"),false);
        notAvailableHousing6 = new Housing(6L,2,new Address("TestCountry6","TestCity6","TestStreet6","TestHouseNumber6","TestRoomNumber6","TestPostCode6"),false);

        agreementList = new ArrayList<>();
        housingList = new ArrayList<>();
    }

    @Test
    @DirtiesContext
    void registerRefugee() {
        // setup
        NewRefugeeRegisterDTO newRefugeeRegisterDTO = new NewRefugeeRegisterDTO(
                refugee1.getEmail(),
                refugee1.getPassword(),
                refugee1.getGender(),
                refugee1.getNationality(),
                refugee1.getFirstName(),
                refugee1.getMiddleName(),
                refugee1.getLastName(),
                refugee1.getDateOfBirth(),
                refugee1.getFamilySize(),
                refugee1.getDescription()
        );
        when(refugeeCommunication.createRefugee(refugee1)).thenReturn(refugee1);

        // action
        RefugeeDTO result = underTest.registerRefugee(newRefugeeRegisterDTO);

        // verify
        ArgumentCaptor<Refugee> argCaptor = ArgumentCaptor.forClass(Refugee.class);
        verify(refugeeCommunication).createRefugee(argCaptor.capture());
        assertEquals(refugee1.getEmail(), argCaptor.getValue().getEmail());
        assertNotEquals(refugee1.getPassword(), argCaptor.getValue().getPassword());
        assertEquals(refugee1.getDateOfBirth(), argCaptor.getValue().getDateOfBirth());
        assertEquals(refugee1.getDescription(), argCaptor.getValue().getDescription());
        assertEquals(refugee1.getFirstName(), argCaptor.getValue().getFirstName());
        assertEquals(refugee1.getLastName(), argCaptor.getValue().getLastName());
        assertEquals(refugee1.getNationality(), argCaptor.getValue().getNationality());
        assertEquals(refugee1.getFamilySize(), argCaptor.getValue().getFamilySize());
        assertEquals("", result.getErrorMessage());
    }

    @Test
    @DirtiesContext
    void registerHost() {
        // setup
        NewHostRegisterDTO newHostRegisterDTO = new NewHostRegisterDTO(
                host1.getEmail(),
                host1.getPassword(),
                host1.getGender(),
                host1.getNationality(),
                host1.getFirstName(),
                host1.getMiddleName(),
                host1.getLastName(),
                host1.getDateOfBirth()
        );
        when(hostCommunication.createHost(host1)).thenReturn(host1);

        // action
        HostDTO result = underTest.registerHost(newHostRegisterDTO);

        // verify
        ArgumentCaptor<Host> argCaptor = ArgumentCaptor.forClass(Host.class);
        verify(hostCommunication).createHost(argCaptor.capture());
        assertEquals(host1.getEmail(), argCaptor.getValue().getEmail());
        assertNotEquals(host1.getPassword(), argCaptor.getValue().getPassword());
        assertEquals(host1.getDateOfBirth(), argCaptor.getValue().getDateOfBirth());
        assertEquals(host1.getFirstName(), argCaptor.getValue().getFirstName());
        assertEquals(host1.getLastName(), argCaptor.getValue().getLastName());
        assertEquals(host1.getNationality(), argCaptor.getValue().getNationality());
        assertEquals("", result.getErrorMessage());
    }

    @Test
    @DirtiesContext
    void existsByEmail_whenHostExists()
    {
         // setup
        when(hostCommunication.getHostByEmail(host1.getEmail())).thenReturn(Optional.ofNullable(host1));
         // action
        boolean result = underTest.existsByEmail(host1.getEmail());
        // verify
        assertTrue(result);
    }


    @Test
    @DirtiesContext
    void existsByEmail_whenRefugeeExists()
    {
        // setup
        when(refugeeCommunication.getRefugeeByEmail(refugee1.getEmail())).thenReturn(Optional.ofNullable(refugee1));
        // action
        boolean result = underTest.existsByEmail(refugee1.getEmail());
        // verify
        assertTrue(result);
    }


    @Test
    @DirtiesContext
    void existsByEmail_noHostFound_noRefugeeFound()
    {
        // setup
        when(hostCommunication.getHostByEmail(host1.getEmail())).thenReturn(Optional.empty());
        // action
        boolean result = underTest.existsByEmail(host1.getEmail());
        // verify
        assertFalse(result);
    }

    @Test
    @DirtiesContext
    @Disabled
    void login_whenHostIsTryingToLogin()
    {
        LoginDTO loginDTO = new LoginDTO(host1.getEmail(),host1.getPassword());

        // setup
        when(hostCommunication.getHostByEmail(host1.getEmail())).thenReturn(Optional.ofNullable(host1));
        // action
        AuthResponseDTO result = underTest.login(loginDTO);
        // verify
        System.out.println(result);
    }


}