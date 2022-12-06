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

@DataJpaTest
class HousingRepositoryTest {

    @Autowired
    private HousingRepository underTest;
    @Autowired
    private AddressRepository addressRepository;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
        addressRepository.deleteAll();
    }

    @Test
    void findAllByAvailableTrue() {
        // given
        Address address = new Address("Denmark", "Horsens", "Ryesgade", "4F", "1.02", "8700");
        Housing housing1 = new Housing(1,2,true, address);
        Housing housing2 = new Housing(1,2,false, address);
        Housing housing3 = new Housing(1,2,true, address);

        // when
        addressRepository.save(address);
        underTest.save(housing1);
        underTest.save(housing2);
        underTest.save(housing3);
        //then
        assertThat(underTest.findAll()).satisfies();
    }

    @Test
    void findAllByHost_Email() {
    }
}