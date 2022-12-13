package via.sep3.group11.tier2.businessLogic;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import via.sep3.group11.tier2.CommunicationInterfaces.AgreementCommunicationInterface;
import via.sep3.group11.tier2.CommunicationInterfaces.HostCommunicationInterface;
import via.sep3.group11.tier2.CommunicationInterfaces.HousingCommunicationInterface;
import via.sep3.group11.tier2.CommunicationInterfaces.RefugeeCommunicationInterface;
import via.sep3.group11.tier2.Tier2Application;
import via.sep3.group11.tier2.logicInterfaces.AgreementInterface;
import via.sep3.group11.tier2.shared.DTOs.*;
import via.sep3.group11.tier2.shared.domain.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ActiveProfiles("test")
@SpringBootTest(classes = Tier2Application.class)
class AgreementLogicTest {

    @Autowired
    HostCommunicationInterface hostCommunication;
    @Autowired
    HousingCommunicationInterface housingCommunicationInterface;
    @Autowired
    AgreementCommunicationInterface agreementCommunicationInterface;
    @Autowired
    RefugeeCommunicationInterface refugeeCommunicationInterface;

    @Autowired
    AgreementInterface underTest;

    Host host1;
    Host host2;
    Host host3;
    Host host4;
    Host host5;
    Host host6;

    Refugee refugee1;
    Refugee refugee2;
    Refugee refugee3;
    Refugee refugee4;
    Refugee refugee5;
    Refugee refugee6;

    Housing availableHousing1;
    Housing availableHousing2;
    Housing availableHousing3;

    Housing notAvailableHousing4;
    Housing notAvailableHousing5;
    Housing notAvailableHousing6;

    Agreement pendingAgreement1;
    Agreement pendingAgreement2;
    Agreement pendingAgreement3;

    Agreement acceptedAgreement4;
    Agreement acceptedAgreement5;
    Agreement acceptedAgreement6;

    List<Agreement> agreementList;
    List<Housing> housingList;

    @BeforeEach
    void setUp() {
        host1 = new Host("DummyHost1","dummyHost1@gmail.com","DummyHost1", 'O',"DummyHost1","DummyHost1","DummyHost1", new Date(01,01,2019));
        host2 = new Host("DummyHost2","dummyHost2@gmail.com","DummyHost2", 'O',"DummyHost2","DummyHost2","DummyHost2", new Date(01,01,2018));
        host3 = new Host("DummyHost3","dummyHost3@gmail.com","DummyHost3", 'O',"DummyHost3","DummyHost3","DummyHost3", new Date(01,01,2000));
        host4 = new Host("DummyHost4","dummyHost4@gmail.com","DummyHost4", 'O',"DummyHost4","DummyHost4","DummyHost4", new Date(01,01,2021));
        host5 = new Host("DummyHost5","dummyHost5@gmail.com","DummyHost5", 'O',"DummyHost5","DummyHost5","DummyHost5", new Date(01,01,2017));
        host6 = new Host("DummyHost6","dummyHost6@gmail.com","DummyHost6", 'O',"DummyHost6","DummyHost6","DummyHost6", new Date(01,01,2017));

        refugee1 = new Refugee("dummyRefugee1@gmail.com","DummyRefugee1",'O',"DummyRefugee1","DummyRefugee1","DummyRefugee1","DummyRefugee1",new Date(01,01,1999),1,"Amazing person!");
        refugee2 = new Refugee("dummyRefugee2@gmail.com","DummyRefugee2",'O',"DummyRefugee2","DummyRefugee2","DummyRefugee2","DummyRefugee2",new Date(01,01,2018),5,"Lovely family!");
        refugee3 = new Refugee("dummyRefugee3@gmail.com","DummyRefugee3",'O',"DummyRefugee3","DummyRefugee3","DummyRefugee3","DummyRefugee3",new Date(01,01,2018),2,"Nice couple!");
        refugee4 = new Refugee("dummyRefugee4@gmail.com","DummyRefugee4",'O',"DummyRefugee4","DummyRefugee4","DummyRefugee4","DummyRefugee4",new Date(01,01,2000),1,"Good chief!");
        refugee5 = new Refugee("dummyRefugee5@gmail.com","DummyRefugee5",'O',"DummyRefugee5","DummyRefugee5","DummyRefugee5","DummyRefugee5",new Date(01,01,2021),5,"Lovely family!");
        refugee6 = new Refugee("dummyRefugee6@gmail.com","DummyRefugee6",'O',"DummyRefugee6","DummyRefugee6","DummyRefugee6","DummyRefugee6",new Date(01,01,2021),5,"Lovely family!");

        availableHousing1 = new Housing(1L,2,new Address("TestCountry1","TestCity1","TestStreet1","TestHouseNumber1","TestRoomNumber1","TestPostCode1"),true);
        availableHousing2 = new Housing(2L,2,new Address("TestCountry2","TestCity2","TestStreet2","TestHouseNumber2","TestRoomNumber2","TestPostCode2"),true);
        availableHousing3 = new Housing(3L,2,new Address("TestCountry3","TestCity3","TestStreet3","TestHouseNumber3","TestRoomNumber3","TestPostCode3"),true);

        notAvailableHousing4 = new Housing(4L,2,new Address("TestCountry4","TestCity4","TestStreet4","TestHouseNumber4","TestRoomNumber4","TestPostCode4"),false);
        notAvailableHousing5 = new Housing(5L,2,new Address("TestCountry5","TestCity5","TestStreet5","TestHouseNumber5","TestRoomNumber5","TestPostCode5"),false);
        notAvailableHousing6 = new Housing(6L,2,new Address("TestCountry6","TestCity6","TestStreet6","TestHouseNumber6","TestRoomNumber6","TestPostCode6"),false);

        pendingAgreement1 = new Agreement(1L,host1,availableHousing1,refugee1,false,new Date(01,01,2000));
        pendingAgreement2 = new Agreement(2L,host2,availableHousing2,refugee2,false,new Date(01,01,2000));
        pendingAgreement3 = new Agreement(3L,host3,availableHousing3,refugee3,false,new Date(01,01,2000));

        acceptedAgreement4 = new Agreement(4L,host4,notAvailableHousing4,refugee4,true,new Date(01,01,2000));
        acceptedAgreement5 = new Agreement(5L,host5,notAvailableHousing5,refugee5,true,new Date(01,01,2000));
        acceptedAgreement6 = new Agreement(6L,host6,notAvailableHousing6,refugee6,true,new Date(01,01,2000));

        agreementList = new ArrayList<>();
        housingList = new ArrayList<>();
    }

    @Test
    @DirtiesContext
    void requestAgreement_success() {
         // setup
        RequestAgreementDTO requestAgreementDTO = new RequestAgreementDTO(refugee1.getEmail(),host1.getEmail(),availableHousing1,"");
        when(hostCommunication.getHostByEmail(host1.getEmail())).thenReturn(Optional.ofNullable(host1));
        when(housingCommunicationInterface.getHousingById(availableHousing1.getHousingId())).thenReturn(Optional.ofNullable(availableHousing1));
        when(refugeeCommunicationInterface.getRefugeeByEmail(refugee1.getEmail())).thenReturn(Optional.ofNullable(refugee1));
        when(agreementCommunicationInterface.addAgreement(any())).thenAnswer(invocation -> {
            Agreement agreement = invocation.getArgument(0);
            return agreement;
        });
         // action
        AgreementDTO result = underTest.requestAgreement(requestAgreementDTO);
         // verify
        verify(hostCommunication).getHostByEmail(host1.getEmail());
        verify(housingCommunicationInterface).getHousingById(availableHousing1.getHousingId());
        verify(refugeeCommunicationInterface).getRefugeeByEmail(refugee1.getEmail());
        verify(agreementCommunicationInterface).addAgreement(any());

        assertEquals(host1, result.getAgreement().getHost());
        assertEquals(refugee1, result.getAgreement().getRefugee());
        assertFalse(result.getAgreement().isAccepted());
        assertEquals("",result.getErrorMessage());
    }

    @Test
    @DirtiesContext
    void requestAgreement_noHostFound() {
        // setup
        RequestAgreementDTO requestAgreementDTO = new RequestAgreementDTO(refugee1.getEmail(),host1.getEmail(),availableHousing1,"");
        when(hostCommunication.getHostByEmail(host1.getEmail())).thenReturn(Optional.empty());
        when(housingCommunicationInterface.getHousingById(availableHousing1.getHousingId())).thenReturn(Optional.ofNullable(availableHousing1));
        when(refugeeCommunicationInterface.getRefugeeByEmail(refugee1.getEmail())).thenReturn(Optional.ofNullable(refugee1));
        when(agreementCommunicationInterface.addAgreement(any())).thenAnswer(invocation -> {
            Agreement agreement = invocation.getArgument(0);
            return agreement;
        });
        // action
        AgreementDTO result = underTest.requestAgreement(requestAgreementDTO);
        // verify
        verify(hostCommunication).getHostByEmail(host1.getEmail());
        verify(housingCommunicationInterface, never()).getHousingById(availableHousing1.getHousingId());
        verify(refugeeCommunicationInterface, never()).getRefugeeByEmail(refugee1.getEmail());
        verify(agreementCommunicationInterface, never()).addAgreement(any());

        assertEquals("Owner of this housing deactivated his account and this housing is no longer available",result.getErrorMessage());
    }

    @Test
    @DirtiesContext
    void requestAgreement_noHousingFound() {
        // setup
        RequestAgreementDTO requestAgreementDTO = new RequestAgreementDTO(refugee1.getEmail(),host1.getEmail(),availableHousing1,"");
        when(hostCommunication.getHostByEmail(host1.getEmail())).thenReturn(Optional.ofNullable(host1));
        when(housingCommunicationInterface.getHousingById(availableHousing1.getHousingId())).thenReturn(Optional.empty());
        when(refugeeCommunicationInterface.getRefugeeByEmail(refugee1.getEmail())).thenReturn(Optional.ofNullable(refugee1));
        when(agreementCommunicationInterface.addAgreement(any())).thenAnswer(invocation -> {
            Agreement agreement = invocation.getArgument(0);
            return agreement;
        });
        // action
        AgreementDTO result = underTest.requestAgreement(requestAgreementDTO);
        // verify
        verify(hostCommunication).getHostByEmail(host1.getEmail());
        verify(housingCommunicationInterface).getHousingById(availableHousing1.getHousingId());
        verify(refugeeCommunicationInterface, never()).getRefugeeByEmail(refugee1.getEmail());
        verify(agreementCommunicationInterface, never()).addAgreement(any());

        assertEquals("This housing is no longer listed.",result.getErrorMessage());
    }

    @Test
    @DirtiesContext
    void requestAgreement_housingAlreadyReserved() {
         // setup
        RequestAgreementDTO requestAgreementDTO = new RequestAgreementDTO(refugee1.getEmail(),host1.getEmail(),notAvailableHousing4,"");
        when(hostCommunication.getHostByEmail(host1.getEmail())).thenReturn(Optional.ofNullable(host1));
        when(housingCommunicationInterface.getHousingById(notAvailableHousing4.getHousingId())).thenReturn(Optional.ofNullable(notAvailableHousing4));
        when(refugeeCommunicationInterface.getRefugeeByEmail(refugee1.getEmail())).thenReturn(Optional.ofNullable(refugee1));
        when(agreementCommunicationInterface.addAgreement(any())).thenAnswer(invocation -> {
            Agreement agreement = invocation.getArgument(0);
            return agreement;
        });
         // action
        AgreementDTO result = underTest.requestAgreement(requestAgreementDTO);
         // verify
        verify(hostCommunication).getHostByEmail(host1.getEmail());
        verify(housingCommunicationInterface).getHousingById(notAvailableHousing4.getHousingId());
        verify(refugeeCommunicationInterface, never()).getRefugeeByEmail(refugee1.getEmail());
        verify(agreementCommunicationInterface, never()).addAgreement(any());

        assertEquals("This housing is already reserved.",result.getErrorMessage());
    }

    @Test
    @DirtiesContext
    void respondToAgreement_acceptSuccessfully() {
         // setup
        RespondAgreementDTO respondAgreementDTO = new RespondAgreementDTO(pendingAgreement1.getAgreementId(),true,"");
        when(agreementCommunicationInterface.getAgreementById(pendingAgreement1.getAgreementId())).thenReturn(Optional.ofNullable(pendingAgreement1));
        when(housingCommunicationInterface.getHousingById(pendingAgreement1.getHousing().getHousingId())).thenReturn(Optional.ofNullable(pendingAgreement1.getHousing()));
         // action
        AgreementDTO result = underTest.respondToAgreement(respondAgreementDTO);
        // verify
        verify(agreementCommunicationInterface).getAgreementById(pendingAgreement1.getAgreementId());
        verify(housingCommunicationInterface).getHousingById(pendingAgreement1.getAgreementId());
        verify(housingCommunicationInterface).updateHousing(any());
        verify(agreementCommunicationInterface).updateAgreement(any());
        verify(agreementCommunicationInterface, never()).deleteAgreement(anyLong());
        assertTrue(result.getAgreement().isAccepted());
        assertTrue(pendingAgreement1.isAccepted());
        assertEquals("",result.getErrorMessage());
    }

    @Test
    @DirtiesContext
    void respondToAgreement_declineSuccessfully() {
        // setup
        RespondAgreementDTO respondAgreementDTO = new RespondAgreementDTO(pendingAgreement1.getAgreementId(),false,"");
        when(agreementCommunicationInterface.getAgreementById(pendingAgreement1.getAgreementId())).thenReturn(Optional.ofNullable(pendingAgreement1));
        when(housingCommunicationInterface.getHousingById(pendingAgreement1.getHousing().getHousingId())).thenReturn(Optional.ofNullable(pendingAgreement1.getHousing()));
        // action
        AgreementDTO result = underTest.respondToAgreement(respondAgreementDTO);
        // verify
        verify(agreementCommunicationInterface).getAgreementById(pendingAgreement1.getAgreementId());
        verify(housingCommunicationInterface).getHousingById(pendingAgreement1.getAgreementId());
        verify(housingCommunicationInterface).updateHousing(any());
        verify(agreementCommunicationInterface, never()).updateAgreement(any());
        verify(agreementCommunicationInterface).deleteAgreement(anyLong());
        assertFalse(result.getAgreement().isAccepted());
        assertFalse(pendingAgreement1.isAccepted());
        assertEquals("",result.getErrorMessage());
    }

    @Test
    @DirtiesContext
    void respondToAgreement_noAgreementFound() {
        // setup
        RespondAgreementDTO respondAgreementDTO = new RespondAgreementDTO(pendingAgreement1.getAgreementId(),false,"");
        when(agreementCommunicationInterface.getAgreementById(pendingAgreement1.getAgreementId())).thenReturn(Optional.empty());
        when(housingCommunicationInterface.getHousingById(pendingAgreement1.getHousing().getHousingId())).thenReturn(Optional.ofNullable(pendingAgreement1.getHousing()));
        // action
        AgreementDTO result = underTest.respondToAgreement(respondAgreementDTO);
        // verify
        verify(agreementCommunicationInterface).getAgreementById(pendingAgreement1.getAgreementId());
        verify(housingCommunicationInterface, never()).getHousingById(pendingAgreement1.getAgreementId());
        verify(housingCommunicationInterface, never()).updateHousing(any());
        verify(agreementCommunicationInterface, never()).updateAgreement(any());
        verify(agreementCommunicationInterface, never()).deleteAgreement(anyLong());
        assertEquals("This agreement no longer exists",result.getErrorMessage());
    }

    @Test
    @DirtiesContext
    void getAllRequestsByHost_whenNoAgreementsFound() {
         // setup
        AgreementsByHostDTO agreements = new AgreementsByHostDTO(host1.getEmail(),"");
        when(agreementCommunicationInterface.getAgreementsByHostId(host1.getEmail())).thenReturn(agreementList);
         // action
        AgreementListDTO result = underTest.getAllRequestsByHost(agreements);
        // verify
        verify(agreementCommunicationInterface).getAgreementsByHostId(host1.getEmail());
        assertEquals(0,result.getAgreementList().size());
        assertEquals("",result.getErrorMessage());
    }

    @Test
    @DirtiesContext
    void getAllRequestsByHost_whenAgreementsFound() {
        // setup
        agreementList.add(acceptedAgreement4);
        agreementList.add(acceptedAgreement5);
        AgreementsByHostDTO agreements = new AgreementsByHostDTO(host1.getEmail(),"");
        when(agreementCommunicationInterface.getAgreementsByHostId(host1.getEmail())).thenReturn(agreementList);
        // action
        AgreementListDTO result = underTest.getAllRequestsByHost(agreements);
        // verify
        verify(agreementCommunicationInterface).getAgreementsByHostId(host1.getEmail());
        assertEquals(2,result.getAgreementList().size());
        assertEquals("",result.getErrorMessage());
    }

}