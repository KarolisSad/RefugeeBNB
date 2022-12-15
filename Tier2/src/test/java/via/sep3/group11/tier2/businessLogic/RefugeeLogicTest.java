package via.sep3.group11.tier2.businessLogic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import via.sep3.group11.tier2.CommunicationInterfaces.AgreementCommunicationInterface;
import via.sep3.group11.tier2.CommunicationInterfaces.HostCommunicationInterface;
import via.sep3.group11.tier2.CommunicationInterfaces.HousingCommunicationInterface;
import via.sep3.group11.tier2.CommunicationInterfaces.RefugeeCommunicationInterface;
import via.sep3.group11.tier2.Tier2Application;
import via.sep3.group11.tier2.logicInterfaces.RefugeeInterface;
import via.sep3.group11.tier2.shared.DTOs.*;
import via.sep3.group11.tier2.shared.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ActiveProfiles("test")
@SpringBootTest(classes = Tier2Application.class)
class RefugeeLogicTest {


    @Autowired
    HostCommunicationInterface hostCommunication;
    @Autowired
    HousingCommunicationInterface housingCommunicationInterface;
    @Autowired
    AgreementCommunicationInterface agreementCommunicationInterface;
    @Autowired
    RefugeeCommunicationInterface refugeeCommunication;

    @Autowired
    RefugeeInterface underTest;

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
    void deleteRefugee_successfully()
    {
         // setup
        when(refugeeCommunication.getRefugeeByEmail(refugee1.getEmail())).thenReturn(Optional.ofNullable(refugee1));
        when(agreementCommunicationInterface.getAgreementByRefugeeEmail(refugee1.getEmail())).thenReturn(Optional.empty());

         // action
        RefugeeDTO result = underTest.deleteAccount(refugee1.getEmail());

        // testing
        verify(refugeeCommunication).getRefugeeByEmail(refugee1.getEmail());
        verify(agreementCommunicationInterface).getAgreementByRefugeeEmail(refugee1.getEmail());
        verify(agreementCommunicationInterface, never()).deleteAgreement(anyLong());
        verify(refugeeCommunication).deleteAccount(refugee1.getEmail());
        assertEquals("",result.getErrorMessage());
    }

    @Test
    @DirtiesContext
    void deleteRefugee_existingActiveAgreement()
    {
        // setup
        Agreement agreement = new Agreement(1L,host1,availableHousing1,refugee1,true);
        when(refugeeCommunication.getRefugeeByEmail(refugee1.getEmail())).thenReturn(Optional.ofNullable(refugee1));
        when(agreementCommunicationInterface.getAgreementByRefugeeEmail(refugee1.getEmail())).thenReturn(Optional.of(agreement));

        // action
        RefugeeDTO result = underTest.deleteAccount(refugee1.getEmail());

        // testing
        verify(refugeeCommunication).getRefugeeByEmail(refugee1.getEmail());
        verify(agreementCommunicationInterface).getAgreementByRefugeeEmail(refugee1.getEmail());
        verify(agreementCommunicationInterface, never()).deleteAgreement(anyLong());
        verify(refugeeCommunication, never()).deleteAccount(refugee1.getEmail());
        assertEquals("Unable to delete, due to refugee being part of an accepted agreement",result.getErrorMessage());
    }

    @Test
    @DirtiesContext
    void deleteRefugee_existingNotActiveAgreement()
    {
        // setup
        Agreement agreement = new Agreement(1L,host1,availableHousing1,refugee1,false);
        when(refugeeCommunication.getRefugeeByEmail(refugee1.getEmail())).thenReturn(Optional.ofNullable(refugee1));
        when(agreementCommunicationInterface.getAgreementByRefugeeEmail(refugee1.getEmail())).thenReturn(Optional.of(agreement));

        // action
        RefugeeDTO result = underTest.deleteAccount(refugee1.getEmail());

        // testing
        verify(refugeeCommunication).getRefugeeByEmail(refugee1.getEmail());
        verify(agreementCommunicationInterface).getAgreementByRefugeeEmail(refugee1.getEmail());
        verify(agreementCommunicationInterface).deleteAgreement(anyLong());
        verify(refugeeCommunication).deleteAccount(refugee1.getEmail());
        assertEquals("",result.getErrorMessage());
    }

    @Test
    @DirtiesContext
    void deleteRefugee_noRefugeeFound()
    {
        // setup
        Agreement agreement = new Agreement(1L,host1,availableHousing1,refugee1,false);
        when(refugeeCommunication.getRefugeeByEmail(refugee1.getEmail())).thenReturn(Optional.empty());
        when(agreementCommunicationInterface.getAgreementByRefugeeEmail(refugee1.getEmail())).thenReturn(Optional.of(agreement));

        // action
        RefugeeDTO result = underTest.deleteAccount(refugee1.getEmail());

        // testing
        verify(refugeeCommunication).getRefugeeByEmail(refugee1.getEmail());
        verify(agreementCommunicationInterface, never()).getAgreementByRefugeeEmail(refugee1.getEmail());
        verify(agreementCommunicationInterface, never()).deleteAgreement(anyLong());
        verify(refugeeCommunication, never()).deleteAccount(refugee1.getEmail());
        assertEquals("No refugee with email: " + refugee1.getEmail() + " found.",result.getErrorMessage());
    }

    @Test
    @DirtiesContext
    void updateRefugee_successfully()
    {
        // setup
        when(refugeeCommunication.getRefugeeByEmail(refugee1.getEmail())).thenReturn(Optional.ofNullable(refugee1));
        // test
        underTest.updateInformation(new RefugeeUpdateDTO(refugee1.getEmail(), "new", 'O', "new", "new", "new", "new",5,"new"));
        // verify
        ArgumentCaptor<Refugee> argCaptor = ArgumentCaptor.forClass(Refugee.class);
        verify(refugeeCommunication).updateInformation(argCaptor.capture());
        verify(refugeeCommunication).getRefugeeByEmail(refugee1.getEmail());
        assertEquals(refugee1,argCaptor.getValue());
    }

    @Test
    @DirtiesContext
    void updateRefugee_whenRefugeeNotFound()
    {
        // setup
        when(refugeeCommunication.getRefugeeByEmail(refugee1.getEmail())).thenReturn(Optional.empty());
        // test
        RefugeeDTO result = underTest.updateInformation(new RefugeeUpdateDTO(refugee1.getEmail(), "new", 'O', "new", "new", "new", "new",5,"new"));
        // verify
        verify(refugeeCommunication, never()).updateInformation(any());
        verify(refugeeCommunication).getRefugeeByEmail(refugee1.getEmail());
        assertEquals("The refugee with the given email does not exist.", result.getErrorMessage());
    }

    @Test
    @DirtiesContext
    @Disabled
    void getRefugeeById_successfully()
    {
        // setup
        when(refugeeCommunication.getRefugeeByEmail(refugee1.getEmail())).thenReturn(Optional.ofNullable(refugee1));
        // test
        RefugeeDTO result = underTest.getRefugeeById(refugee1.getEmail());
        // verify
        verify(refugeeCommunication).getRefugeeByEmail(refugee1.getEmail());
        assertEquals("",result.getErrorMessage());
        assertEquals(refugee1,result.getRefugee());
    }

    @Test
    @DirtiesContext
    void getRefugeeById_noRefugeeFound()
    {
        // setup
        when(refugeeCommunication.getRefugeeByEmail(refugee1.getEmail())).thenReturn(Optional.empty());
        // test
        RefugeeDTO result = underTest.getRefugeeById(refugee1.getEmail());
        // verify
        verify(refugeeCommunication).getRefugeeByEmail(refugee1.getEmail());
        assertEquals("Refugee with this email can not be found.",result.getErrorMessage());
    }

}