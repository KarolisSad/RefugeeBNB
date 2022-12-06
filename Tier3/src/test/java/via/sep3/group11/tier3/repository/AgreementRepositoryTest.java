package via.sep3.group11.tier3.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import via.sep3.group11.tier3.model.*;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class AgreementRepositoryTest {

    private final Host host = new Host("Bob@gmail.com","Bob","","Builder","bob","DK",'M',new Date(01,01,1999));
    private final Refugee refugee = new Refugee("Refugee@gmail.com","Refugee","","Refugee","refugee","O",'M',new Date(01,01,1999));
    private final Address address = new Address("housing", "Horsens", "Ryesgade", "4F", "1.02", "8700");
    private final Housing housing = new Housing(1L,3,true,new Address("housing", "Horsens", "Ryesgade", "4F", "1.02", "8700"));
    private final Agreement agreement = new Agreement(new Date(01,01,1999),refugee,housing,host);

    @Autowired
    private AgreementRepository underTest;
    @Autowired
    private HostRepository hostRepository;
    @Autowired
    private RefugeeRepository refugeeRepository;
    @Autowired
    private HousingRepository housingRepository;
    @Autowired
    private AddressRepository addressRepository;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void findAgreementsByHost_Email_WhenNoAgreementsFound() {
        // given
        String email = "Bob@gmail.com";
        // when
        List<Agreement> expected = underTest.findAgreementsByHost_Email(email);
        // then
        assertThat(expected).asList().isEmpty();
    }

    @Test
    @Disabled
    void findAgreementsByHost_Email_WhenOneAgreementIsFound() {
        // given
        String email = "Bob@gmail.com";

        Host host1 = hostRepository.save(host);
//        assertThat(host1).isNotNull();

        Refugee refugee1 = refugeeRepository.save(refugee);
//        assertThat(refugee1).isNotNull();

        Address address1 = addressRepository.save(address);

        Housing housing1 = housingRepository.save(housing);
        assertThat(housing1).isNotNull();

        // when
//        List<Agreement> expected = underTest.findAgreementsByHost_Email(agreement.getHost().getEmail());
//        // then
//        assertThat(expected).asList().isNullOrEmpty();
    }



    @Test
    @Disabled
    void findAgreementsByAcceptedIsFalseAndHost_Email() {

    }

    @Test
    @Disabled
    void findAgreementsByHousing_HousingId() {
    }
}