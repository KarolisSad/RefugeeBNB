package via.sep3.group11.tier2.businessLogic;

import org.junit.jupiter.api.*;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import via.sep3.group11.tier2.CommunicationInterfaces.AgreementCommunicationInterface;
import via.sep3.group11.tier2.CommunicationInterfaces.HostCommunicationInterface;
import via.sep3.group11.tier2.CommunicationInterfaces.HousingCommunicationInterface;
import via.sep3.group11.tier2.Tier2Application;
import via.sep3.group11.tier2.logicInterfaces.HostInterface;
import via.sep3.group11.tier2.shared.DTOs.HostDTO;
import via.sep3.group11.tier2.shared.DTOs.HostRegisterDTO;
import via.sep3.group11.tier2.shared.DTOs.HostUpdateDTO;
import via.sep3.group11.tier2.shared.DTOs.LoginDTO;
import via.sep3.group11.tier2.shared.domain.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ActiveProfiles("test")
@SpringBootTest(classes = Tier2Application.class)
class HostLogicTest {

    @Autowired
    HostCommunicationInterface hostCommunication;
    @Autowired
    HousingCommunicationInterface housingCommunicationInterface;
    @Autowired
    AgreementCommunicationInterface agreementCommunicationInterface;

    @Autowired
    HostInterface underTest;

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
    void testGetHostByHousingId()
    {
         // setup
        when(housingCommunicationInterface.getHousingById(1L)).thenReturn(Optional.of(availableHousing1));
        when(hostCommunication.getHostByHousingId(1L)).thenReturn(Optional.of(host1));
         // action
        HostDTO result = underTest.getHostByHousingId(1L);
         // testing
        verify(housingCommunicationInterface).getHousingById(1L);
        verify(hostCommunication).getHostByHousingId(1L);
        assertEquals("", result.getErrorMessage());
        assertEquals(host1, result.getHost());
    }

    @Test
    @DirtiesContext
    void testGetHostByHousingId_WithNoMatchingHousingId()
    {
        // setup
        when(housingCommunicationInterface.getHousingById(1L)).thenReturn(Optional.empty());
        when(hostCommunication.getHostByHousingId(1L)).thenReturn(Optional.of(host1));
        // action
        HostDTO result = underTest.getHostByHousingId(1L);
        // testing
        verify(housingCommunicationInterface).getHousingById(1L);
        verify(hostCommunication, never()).getHostByHousingId(1L);
        assertEquals("This housing no longer exists.", result.getErrorMessage());
    }

    @Test
    @DirtiesContext
    @Disabled
    void testGetHostByHousingId_WhenNoHostIsFound()
    {
        // setup
        when(housingCommunicationInterface.getHousingById(1L)).thenReturn(Optional.empty());
        when(hostCommunication.getHostByHousingId(1L)).thenReturn(Optional.empty());
        // action
        HostDTO result = underTest.getHostByHousingId(1L);
        // testing
        verify(housingCommunicationInterface).getHousingById(1L);
        verify(hostCommunication).getHostByHousingId(1L);
        assertEquals("This host no longer exists", result.getErrorMessage());
    }

    @Test
    @DirtiesContext
    void deleteHost_whenNoActiveHousingsOrAgreements()
    {
         // setup
        when(hostCommunication.getHostByEmail(host1.getEmail())).thenReturn(Optional.of(host1));
        when(agreementCommunicationInterface.getAgreementsByHostId(host1.getEmail())).thenReturn(agreementList);
        when(housingCommunicationInterface.getAllHousingByHostId(host1.getEmail())).thenReturn(housingList);
         // test
        HostDTO result = underTest.deleteAccount(host1.getEmail());
         // verify
        verify(hostCommunication).getHostByEmail(host1.getEmail());
        verify(agreementCommunicationInterface, never()).deleteAgreement(anyLong());
        verify(housingCommunicationInterface, never()).removeHousing(anyLong());
        verify(housingCommunicationInterface).getAllHousingByHostId(host1.getEmail());
        verify(agreementCommunicationInterface).getAgreementsByHostId(host1.getEmail());
        verify(hostCommunication).deleteAccount(host1.getEmail());
        assertEquals("",result.getErrorMessage());
    }

    @Test
    @DirtiesContext
    void deleteHost_whenHostIsNotFound()
    {
        // setup
        when(hostCommunication.getHostByEmail(host1.getEmail())).thenReturn(Optional.empty());
        // test
        HostDTO result = underTest.deleteAccount(host1.getEmail());
        // verify
        verify(hostCommunication).getHostByEmail(host1.getEmail());
        verify(agreementCommunicationInterface, never()).deleteAgreement(anyLong());
        verify(housingCommunicationInterface, never()).removeHousing(anyLong());
        verify(housingCommunicationInterface, never()).getAllHousingByHostId(host1.getEmail());
        verify(agreementCommunicationInterface, never()).getAgreementsByHostId(host1.getEmail());
        verify(hostCommunication, never()).deleteAccount(host1.getEmail());
        assertEquals("Host with email: " + host1.getEmail() + " not found, and therefore unable to be deleted.",result.getErrorMessage());
    }

    @Test
    @DirtiesContext
    void deleteHost_whenNoActiveAgreements_butFewActiveHousings()
    {
        // setup
        housingList.add(new Housing(1L,2,new Address("TestCountry","TestCity","TestStreet","TestHouseNumber","TestRoomNumber","TestPostCode"),false));
        housingList.add(new Housing(2L,2,new Address("TestCountry","TestCity","TestStreet","TestHouseNumber","TestRoomNumber","TestPostCode"),false));
        when(hostCommunication.getHostByEmail(host1.getEmail())).thenReturn(Optional.of(host1));
        when(agreementCommunicationInterface.getAgreementsByHostId(host1.getEmail())).thenReturn(agreementList);
        when(housingCommunicationInterface.getAllHousingByHostId(host1.getEmail())).thenReturn(housingList);
        // test
        HostDTO result = underTest.deleteAccount(host1.getEmail());
        // verify
        verify(hostCommunication).getHostByEmail(host1.getEmail());
        verify(agreementCommunicationInterface, never()).deleteAgreement(anyLong());
        verify(housingCommunicationInterface).removeHousing(1L);
        verify(housingCommunicationInterface).removeHousing(2L);
        verify(housingCommunicationInterface).getAllHousingByHostId(host1.getEmail());
        verify(agreementCommunicationInterface).getAgreementsByHostId(host1.getEmail());
        verify(hostCommunication).deleteAccount(host1.getEmail());
        assertEquals("",result.getErrorMessage());
    }

    @Test
    @DirtiesContext
    void deleteHost_whenFewActiveAgreementsButNonAccepted_andFewActiveHousings()
    {
        // setup
        housingList.add(availableHousing1);
        housingList.add(availableHousing2);
        agreementList.add(new Agreement(1L,host1,availableHousing1,refugee1,false));
        agreementList.add(new Agreement(2L,host1,availableHousing2,refugee1,false));

        when(hostCommunication.getHostByEmail(host1.getEmail())).thenReturn(Optional.of(host1));
        when(agreementCommunicationInterface.getAgreementsByHostId(host1.getEmail())).thenReturn(agreementList);
        when(housingCommunicationInterface.getAllHousingByHostId(host1.getEmail())).thenReturn(housingList);
        // test
        HostDTO result = underTest.deleteAccount(host1.getEmail());
        // verify
        verify(hostCommunication).getHostByEmail(host1.getEmail());
        verify(agreementCommunicationInterface).deleteAgreement(1L);
        verify(agreementCommunicationInterface).deleteAgreement(2L);
        verify(housingCommunicationInterface).getAllHousingByHostId(host1.getEmail());
        verify(agreementCommunicationInterface).getAgreementsByHostId(host1.getEmail());
        verify(housingCommunicationInterface).removeHousing(1L);
        verify(housingCommunicationInterface).removeHousing(2L);
        verify(hostCommunication).deleteAccount(host1.getEmail());
        assertEquals("",result.getErrorMessage());
    }

    @Test
    @DirtiesContext
    void deleteHost_whenFewActiveAgreementsAndAccepted()
    {
        // setup
        housingList.add(notAvailableHousing4);
        housingList.add(notAvailableHousing4);
        agreementList.add(new Agreement(1L,host1,notAvailableHousing4,refugee1,true));
        agreementList.add(new Agreement(2L,host1,notAvailableHousing4,refugee1,true));

        when(hostCommunication.getHostByEmail(host1.getEmail())).thenReturn(Optional.of(host1));
        when(agreementCommunicationInterface.getAgreementsByHostId(host1.getEmail())).thenReturn(agreementList);
        when(housingCommunicationInterface.getAllHousingByHostId(host1.getEmail())).thenReturn(housingList);
        // test
        HostDTO result = underTest.deleteAccount(host1.getEmail());
        // verify
        verify(hostCommunication).getHostByEmail(host1.getEmail());
        verify(agreementCommunicationInterface, never()).deleteAgreement(1L);
        verify(agreementCommunicationInterface, never()).deleteAgreement(2L);
        verify(housingCommunicationInterface).getAllHousingByHostId(host1.getEmail());
        verify(agreementCommunicationInterface).getAgreementsByHostId(host1.getEmail());
        verify(housingCommunicationInterface, never()).removeHousing(1L);
        verify(housingCommunicationInterface, never()).removeHousing(2L);
        verify(hostCommunication, never()).deleteAccount(host1.getEmail());
        assertEquals("Unable to delete. Ongoing agreement(s) found.",result.getErrorMessage());
    }

    @Test
    @DirtiesContext
    void deleteHost_whenFewActiveAgreementsAndAccepted_andFewNotAccepted()
    {
        // setup
        housingList.add(availableHousing1);
        housingList.add(availableHousing2);
        housingList.add(availableHousing3);
        housingList.add(notAvailableHousing4);
        agreementList.add(new Agreement(1L,host1,availableHousing1,refugee1,false));
        agreementList.add(new Agreement(2L,host1,availableHousing2,refugee1,false));
        agreementList.add(new Agreement(3L,host1,notAvailableHousing4,refugee1,true));
        agreementList.add(new Agreement(4L,host1,notAvailableHousing5,refugee1,true));
        when(hostCommunication.getHostByEmail(host1.getEmail())).thenReturn(Optional.of(host1));
        when(agreementCommunicationInterface.getAgreementsByHostId(host1.getEmail())).thenReturn(agreementList);
        when(housingCommunicationInterface.getAllHousingByHostId(host1.getEmail())).thenReturn(housingList);
        // test
        HostDTO result = underTest.deleteAccount(host1.getEmail());
        // verify
        verify(hostCommunication).getHostByEmail(host1.getEmail());
        verify(agreementCommunicationInterface, never()).deleteAgreement(1L);
        verify(agreementCommunicationInterface, never()).deleteAgreement(2L);
        verify(housingCommunicationInterface).getAllHousingByHostId(host1.getEmail());
        verify(agreementCommunicationInterface).getAgreementsByHostId(host1.getEmail());
        verify(housingCommunicationInterface, never()).removeHousing(1L);
        verify(housingCommunicationInterface, never()).removeHousing(2L);
        verify(hostCommunication, never()).deleteAccount(host1.getEmail());
        assertEquals("Unable to delete. Ongoing agreement(s) found.",result.getErrorMessage());
    }

    @Test
    @DirtiesContext
    void updateHost_successfully()
    {
         // setup
        when(hostCommunication.getHostByEmail(host1.getEmail())).thenReturn(Optional.ofNullable(host1));
         // test
        underTest.updateInformation(new HostUpdateDTO(host1.getEmail(), "new", 'O', "new", "new", "new", "new"));
        // verify
        ArgumentCaptor<Host> argCaptor = ArgumentCaptor.forClass(Host.class);
        verify(hostCommunication).updateInformation(argCaptor.capture());
        verify(hostCommunication).getHostByEmail(host1.getEmail());
        assertEquals(host1,argCaptor.getValue());
    }

    @Test
    @DirtiesContext
    void updateHost_whenHostNotFound()
    {
        // setup
        when(hostCommunication.getHostByEmail(host1.getEmail())).thenReturn(Optional.empty());
        // test
        HostDTO result = underTest.updateInformation(new HostUpdateDTO(host1.getEmail(), "new", 'O', "new", "new", "new", "new"));
        // verify
        verify(hostCommunication, never()).updateInformation(any());
        verify(hostCommunication).getHostByEmail(host1.getEmail());
        assertEquals("The host with the given email does not exist.", result.getErrorMessage());
    }

    @Test
    @DirtiesContext
    @Disabled
    void getHostById_successfully()
    {
         // setup
        when(hostCommunication.getHostByEmail(host1.getEmail())).thenReturn(Optional.ofNullable(host1));
         // test
        HostDTO result = underTest.getHostById(host1.getEmail());
         // verify
        verify(hostCommunication).getHostByEmail(host1.getEmail());
        assertEquals("",result.getErrorMessage());
        assertEquals(host1,result.getHost());
    }

    @Test
    @DirtiesContext
    void getHostById_noHostFound()
    {
        // setup
        when(hostCommunication.getHostByEmail(host1.getEmail())).thenReturn(Optional.empty());
        // test
        HostDTO result = underTest.getHostById(host1.getEmail());
        // verify
        verify(hostCommunication).getHostByEmail(host1.getEmail());
        assertEquals("Host with this email can not be found.",result.getErrorMessage());
    }

}