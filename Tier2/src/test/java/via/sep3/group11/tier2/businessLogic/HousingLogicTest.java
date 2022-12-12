package via.sep3.group11.tier2.businessLogic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import via.sep3.group11.tier2.CommunicationInterfaces.AgreementCommunicationInterface;
import via.sep3.group11.tier2.CommunicationInterfaces.HostCommunicationInterface;
import via.sep3.group11.tier2.CommunicationInterfaces.HousingCommunicationInterface;
import via.sep3.group11.tier2.Tier2Application;
import via.sep3.group11.tier2.logicInterfaces.HousingInterface;
import via.sep3.group11.tier2.shared.DTOs.HousingCreationDTO;
import via.sep3.group11.tier2.shared.DTOs.HousingDTO;
import via.sep3.group11.tier2.shared.DTOs.HousingIdDTO;
import via.sep3.group11.tier2.shared.DTOs.HousingListDTO;
import via.sep3.group11.tier2.shared.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ActiveProfiles("test")
@SpringBootTest(classes = Tier2Application.class)
class HousingLogicTest {

    @Autowired
    HostCommunicationInterface hostCommunication;
    @Autowired
    HousingCommunicationInterface housingCommunicationInterface;
    @Autowired
    AgreementCommunicationInterface agreementCommunicationInterface;

    @Autowired
    HousingInterface underTest;

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
    void addHousing_successfully() {
         // setup
        when(housingCommunicationInterface.addHousing(any(),any())).thenReturn(availableHousing1);
        HousingCreationDTO housingCreationDTO = new HousingCreationDTO(
                availableHousing1.getAddress().getCountry(),
                availableHousing1.getAddress().getCity(),
                availableHousing1.getAddress().getStreetName(),
                availableHousing1.getAddress().getHouseNumber(),
                availableHousing1.getAddress().getRoomNumber(),
                availableHousing1.getAddress().getPostCode(),
                availableHousing1.getCapacity(),
                host1.getEmail(),
                "");
         // action
        HousingDTO result = underTest.addHousing(housingCreationDTO);
        // verify
        ArgumentCaptor<Housing> argCaptorHousing = ArgumentCaptor.forClass(Housing.class);
        ArgumentCaptor<String> argCaptorEmail = ArgumentCaptor.forClass(String.class);
        verify(housingCommunicationInterface).addHousing(argCaptorHousing.capture(),argCaptorEmail.capture());

        assertEquals(host1.getEmail(),argCaptorEmail.getValue());
        assertEquals(availableHousing1.getAddress().toString(),argCaptorHousing.getValue().getAddress().toString());
        assertEquals(availableHousing1.getCapacity(),argCaptorHousing.getValue().getCapacity());
        assertEquals("",result.getErrorMessage());
    }

    @Test
    @DirtiesContext
    @Disabled
    void addHousing_nullResponse() {
        // setup
        when(housingCommunicationInterface.addHousing(any(),any())).thenReturn(null);
        HousingCreationDTO housingCreationDTO = new HousingCreationDTO(
                availableHousing1.getAddress().getCountry(),
                availableHousing1.getAddress().getCity(),
                availableHousing1.getAddress().getStreetName(),
                availableHousing1.getAddress().getHouseNumber(),
                availableHousing1.getAddress().getRoomNumber(),
                availableHousing1.getAddress().getPostCode(),
                availableHousing1.getCapacity(),
                host1.getEmail(),
                "");
        // action
        HousingDTO result = underTest.addHousing(housingCreationDTO);
        // verify
        verify(housingCommunicationInterface).addHousing(any(),any());
        assertEquals("Connection to the server was lost.",result.getErrorMessage());
    }

    @Test
    @DirtiesContext
    void getAvailableHousing_withNoHousing() {
         // setup
        when(housingCommunicationInterface.getAvailableHousing()).thenReturn(housingList);
         // action
        HousingListDTO result = underTest.getAvailableHousing();
        // verify
        verify(housingCommunicationInterface).getAvailableHousing();
        assertEquals(0,result.getHousingList().size());
        assertEquals("", result.getErrorMessage());
    }

    @Test
    @DirtiesContext
    void getAvailableHousing_withAvailableHousing() {
        // setup
        housingList.add(availableHousing1);
        housingList.add(availableHousing2);
        when(housingCommunicationInterface.getAvailableHousing()).thenReturn(housingList);
        // action
        HousingListDTO result = underTest.getAvailableHousing();
        // verify
        verify(housingCommunicationInterface).getAvailableHousing();
        assertEquals(2,result.getHousingList().size());
        assertTrue(result.getHousingList().get(0).isAvailable());
        assertTrue(result.getHousingList().get(1).isAvailable());
        assertEquals("", result.getErrorMessage());
    }

    @Test
    @DirtiesContext
    void getAvailableHousing_withNotAvailableHousing() {
        // setup
        housingList.add(notAvailableHousing4);
        housingList.add(notAvailableHousing5);
        when(housingCommunicationInterface.getAvailableHousing()).thenReturn(housingList);
        // action
        HousingListDTO result = underTest.getAvailableHousing();
        // verify
        verify(housingCommunicationInterface).getAvailableHousing();
        assertEquals(2,result.getHousingList().size());
        assertFalse(result.getHousingList().get(0).isAvailable());
        assertFalse(result.getHousingList().get(1).isAvailable());
        assertEquals("", result.getErrorMessage());
    }

    @Test
    @DirtiesContext
    void getAvailableHousing_withNotAvailableHousing_andWithAvailableHousing() {
        // setup
        housingList.add(notAvailableHousing4);
        housingList.add(notAvailableHousing5);
        housingList.add(availableHousing1);
        housingList.add(availableHousing2);
        when(housingCommunicationInterface.getAvailableHousing()).thenReturn(housingList);
        // action
        HousingListDTO result = underTest.getAvailableHousing();
        // verify
        verify(housingCommunicationInterface).getAvailableHousing();
        assertEquals(4,result.getHousingList().size());
        assertFalse(result.getHousingList().get(0).isAvailable());
        assertFalse(result.getHousingList().get(1).isAvailable());
        assertTrue(result.getHousingList().get(2).isAvailable());
        assertTrue(result.getHousingList().get(3).isAvailable());
        assertEquals("", result.getErrorMessage());
    }


    @Test
    @DirtiesContext
    void removeHousing() {
         // setup
        when(housingCommunicationInterface.getHousingById(availableHousing1.getHousingId())).thenReturn(Optional.of(availableHousing1));
        when(agreementCommunicationInterface.getAllAgreementsByHousingId(availableHousing1.getHousingId())).thenReturn(agreementList);
        HousingIdDTO housingIdDTO = new HousingIdDTO(availableHousing1.getHousingId(),host1.getEmail(),"");
         // action
        HousingDTO result = underTest.removeHousing(housingIdDTO);
        // verify
        verify(housingCommunicationInterface).removeHousing(availableHousing1.getHousingId());
        assertEquals("",result.getErrorMessage());
    }

    @Test
    @DirtiesContext
    void removeHousing_noHostExisting() {
        // setup
        when(housingCommunicationInterface.getHousingById(availableHousing1.getHousingId())).thenReturn(Optional.empty());
        when(agreementCommunicationInterface.getAllAgreementsByHousingId(availableHousing1.getHousingId())).thenReturn(agreementList);
        HousingIdDTO housingIdDTO = new HousingIdDTO(availableHousing1.getHousingId(),host1.getEmail(),"");
        // action
        HousingDTO result = underTest.removeHousing(housingIdDTO);
        // verify
        verify(housingCommunicationInterface, never()).removeHousing(availableHousing1.getHousingId());
        verify(agreementCommunicationInterface,never()).getAllAgreementsByHousingId(availableHousing1.getHousingId());
        assertEquals("Housing with ID: "+availableHousing1.getHousingId()+ " doesn't exist.",result.getErrorMessage());
    }

    @Test
    @DirtiesContext
    void removeHousing_activeAgreement() {
        // setup
        agreementList.add(new Agreement(1L,host1,availableHousing1,refugee1,true));
        when(housingCommunicationInterface.getHousingById(availableHousing1.getHousingId())).thenReturn(Optional.ofNullable(availableHousing1));
        when(agreementCommunicationInterface.getAllAgreementsByHousingId(availableHousing1.getHousingId())).thenReturn(agreementList);
        HousingIdDTO housingIdDTO = new HousingIdDTO(availableHousing1.getHousingId(),host1.getEmail(),"");
        // action
        HousingDTO result = underTest.removeHousing(housingIdDTO);
        // verify
        verify(housingCommunicationInterface, never()).removeHousing(availableHousing1.getHousingId());
        verify(agreementCommunicationInterface).getAllAgreementsByHousingId(availableHousing1.getHousingId());
        assertEquals("This housing has active contract. First terminate contract.",result.getErrorMessage());
    }

    @Test
    void getHousingByHostId_housingFoundAvailable() {
        // setup
        housingList.add(availableHousing1);
        housingList.add(availableHousing2);
        when(housingCommunicationInterface.getAllHousingByHostId(host1.getEmail())).thenReturn(housingList);
        // action
        HousingListDTO result = underTest.getHousingByHostId(host1.getEmail());
        // verify
        verify(housingCommunicationInterface).getAllHousingByHostId(host1.getEmail());
        assertEquals(2, result.getHousingList().size());
        assertTrue(result.getHousingList().get(0).isAvailable());
        assertTrue(result.getHousingList().get(1).isAvailable());
    }

    @Test
    void getHousingByHostId_housingFoundNotAvailable() {
        // setup
        housingList.add(notAvailableHousing5);
        housingList.add(notAvailableHousing6);
        when(housingCommunicationInterface.getAllHousingByHostId(host1.getEmail())).thenReturn(housingList);
        // action
        HousingListDTO result = underTest.getHousingByHostId(host1.getEmail());
        // verify
        verify(housingCommunicationInterface).getAllHousingByHostId(host1.getEmail());
        assertEquals(2, result.getHousingList().size());
        assertFalse(result.getHousingList().get(0).isAvailable());
        assertFalse(result.getHousingList().get(1).isAvailable());
    }

    @Test
    void getHousingByHostId_noHousingFound() {
         // setup
        when(housingCommunicationInterface.getAllHousingByHostId(host1.getEmail())).thenReturn(housingList);
         // action
        HousingListDTO result = underTest.getHousingByHostId(host1.getEmail());
        // verify
        verify(housingCommunicationInterface).getAllHousingByHostId(host1.getEmail());
        assertEquals("No housing found for " + host1.getEmail(), result.getErrorMessage());
        assertEquals(0, result.getHousingList().size());
    }
}