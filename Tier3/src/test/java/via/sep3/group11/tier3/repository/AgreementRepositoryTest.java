package via.sep3.group11.tier3.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import via.sep3.group11.tier3.model.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static via.sep3.group11.tier3.model.Date.convertLocalDateToDateObject;
/*
@DataJpaTest
class AgreementRepositoryTest {

    /*
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
    void findAgreementsByHost_Email() {
        // given
        Address address = new Address("Denmark", "Horsens", "Ryesgade", "4F", "1.02", "8700");
        Housing housing1 = new Housing(1,2,true, address);
        Housing housing2 = new Housing(2,2,false, address);
        addressRepository.save(address);
        Host host1 = new Host("Bob@gmail.com", "Bob", "", "Builder", "builder", "Denmark", 'M', new Date(01,01,1999));
        Host host2 = new Host("John@gmail.com", "John", "", "Builder", "builder", "Denmark", 'M', new Date(01,01,1999));
        hostRepository.save(host1);
        hostRepository.save(host2);
        housing1.host = host1;
        housing2.host = host2;
        housingRepository.save(housing1);
        housingRepository.save(housing2);
        Refugee refugee = new Refugee("Refugee@gmail.com", "Bob", "", "Builder", "builder", "Denmark", 'M', new Date(01,01,1999), 1, "");
        Refugee refugee2 = new Refugee("Refugee2@gmail.com", "Bob", "", "Builder", "builder", "Denmark", 'M', new Date(01,01,1999), 1, "");
        refugeeRepository.save(refugee);
        refugeeRepository.save(refugee2);

        Agreement newAgreement = new Agreement(new Date(01,01,1999),
                refugee, housing1, host1);
        underTest.save(newAgreement);
        assertThat(refugeeRepository.findById("Refugee@gmail.com")).isNotEmpty();
        // when
        // then
//        assertThat(underTest.findAgreementsByHost_Email("Bob@gmail.com")).isNotNull();

    }

    @Test
    @Disabled
    void findAgreementsByHost_Email_WhenOneAgreementIsFound() {
        // given
//        String email = "Bob@gmail.com";
//
//        Host host1 = hostRepository.save(host);
////        assertThat(host1).isNotNull();
//
//        Refugee refugee1 = refugeeRepository.save(refugee);
////        assertThat(refugee1).isNotNull();
//
//        Address address1 = addressRepository.save(address);
//
//        Housing housing1 = housingRepository.save(housing);
//        assertThat(housing1).isNotNull();

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


     */
}
