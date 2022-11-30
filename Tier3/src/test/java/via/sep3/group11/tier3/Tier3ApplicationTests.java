package via.sep3.group11.tier3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import via.sep3.group11.tier3.DAO.DAOImplementations.HostDAOImplementation;
import via.sep3.group11.tier3.DAO.DAOImplementations.HousingDAOImplementation;
import via.sep3.group11.tier3.model.Address;
import via.sep3.group11.tier3.model.Date;
import via.sep3.group11.tier3.model.Host;
import via.sep3.group11.tier3.model.Housing;

@SpringBootTest
class Tier3ApplicationTests {

    @Autowired
    HostDAOImplementation hostDao;
    @Autowired
    HousingDAOImplementation housingDAO;

    @Test
    void contextLoads() {
    }

    @Test
    void addHostTest() {
        Host host = new Host(
                "test@test.dk",
                "Bob",
                "teh",
                "Builder",
                "bobpassword",
                "Danish",
                'M',
                new Date(1,1,1992)
        );

        hostDao.createHost(host);
    }

    @Test
    void addMultipleHostTest() {
        Host host = new Host(
                "test@test.dk",
                "Bob",
                "teh",
                "Builder",
                "bobpassword",
                "Danish",
                'M',
                new Date(1,1,1992)
        );

        Host host1 = new Host(
                "wendy@test.dk",
                "Bob",
                "teh",
                "Builder",
                "bobpassword",
                "Danish",
                'M',
                new Date(1,1,1992)
        );

        Host host2 = new Host(
                "anothertest@test.dk",
                "Bob",
                "teh",
                "Builder",
                "bobpassword",
                "Danish",
                'M',
                new Date(1,1,1992)
        );

        hostDao.createHost(host);
        hostDao.createHost(host1);
        hostDao.createHost(host2);
    }

    @Test
    void addHousingTest() {
        Housing housing = new Housing(
                1,
                new Address("Denmark", "Horsens", "Ryesgade", "4F", "1.02", "8700")
        );

        housingDAO.addHousing(housing, "test@test.dk");
    }

}
