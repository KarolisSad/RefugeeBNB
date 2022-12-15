package via.sep3.group11.tier3.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import via.sep3.group11.tier3.model.Address;
import via.sep3.group11.tier3.model.Date;
import via.sep3.group11.tier3.model.Host;
import via.sep3.group11.tier3.model.Housing;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
/*
@DataJpaTest
class HousingRepositoryTest {
/*
    @Autowired
    private HousingRepository underTest;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private HostRepository hostRepository;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
        addressRepository.deleteAll();
        hostRepository.deleteAll();
    }

    @Test
    void findAllByAvailableTrue() {
        // given
        Address address = new Address("Denmark", "Horsens", "Ryesgade", "4F", "1.02", "8700");
        Housing housing1 = new Housing(1,2,true, address);
        Housing housing2 = new Housing(2,2,false, address);
        Housing housing3 = new Housing(3,2,true, address);
        addressRepository.save(address);
        underTest.save(housing1);
        underTest.save(housing2);
        underTest.save(housing3);
        // when
        //then
        assertThat(underTest.findAllByAvailableTrue().size() == 2).isTrue();
    }

    @Test
    void findAllHousingsByHost_Email() {
        // given
        Address address = new Address("Denmark", "Horsens", "Ryesgade", "4F", "1.02", "8700");
        Housing housing1 = new Housing(1,2,true, address);
        Housing housing2 = new Housing(2,2,false, address);
        Housing housing3 = new Housing(3,2,true, address);
        addressRepository.save(address);
        Host host = new Host("Bob@gmail.com", "Bob", "", "Builder", "builder", "Denmark", 'M', new Date(01,01,1999));
        hostRepository.save(host);
        housing1.host = host;
        housing2.host = host;
        underTest.save(housing1);
        underTest.save(housing2);
        underTest.save(housing3);
        //when
        //then
        assertThat(underTest.findAllByHost_Email("Bob@gmail.com").size() == 2).isTrue();
    }

 */
}

