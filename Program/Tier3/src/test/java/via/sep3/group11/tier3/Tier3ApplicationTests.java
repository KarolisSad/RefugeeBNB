package via.sep3.group11.tier3;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import via.sep3.group11.tier3.DAO.DAOImplementations.HostDAOImplementation;
import via.sep3.group11.tier3.DAO.DAOImplementations.HousingDAOImplementation;
import via.sep3.group11.tier3.model.Address;
import via.sep3.group11.tier3.model.Date;
import via.sep3.group11.tier3.model.Host;
import via.sep3.group11.tier3.model.Housing;

import java.util.List;
/*
@SpringBootTest
class Tier3ApplicationTests {

    @Autowired
    HostDAOImplementation hostDao;
    @Autowired
    HousingDAOImplementation housingDAO;

    Housing housing = new Housing(
            1,
            new Address("Denmark", "Horsens", "First", "4F", "1.02", "8700")
    );

    Housing housing1 = new Housing(
            1,
            new Address("Denmark", "Horsens", "Second", "4F", "1.02", "8700")
    );

    Housing housing2 = new Housing(
            1,
            new Address("Denmark", "Horsens", "Third", "4F", "1.02", "8700")
    );

    Housing housing3 = new Housing(
            1,
            new Address("Denmark", "Horsens", "Fourth", "4F", "1.02", "8700")
    );

    Housing housing4 = new Housing(
            1,
            new Address("Denmark", "Horsens", "Fifth", "4F", "1.02", "8700")
    );

    String email = "test@test.dk";

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

    @Test
    void addMultipleHousingTest() {
        housingDAO.addHousing(housing, email);
        housingDAO.addHousing(housing1, email);
        housingDAO.addHousing(housing2, email);
        housingDAO.addHousing(housing3, email);
        housingDAO.addHousing(housing4, email);

        List<Housing> availableHousing = housingDAO.getAvailableHousing();

        System.out.println("SIZE: " + availableHousing.size());
        housingDAO.removeHousing(availableHousing.get(1).getHousingId());

        availableHousing = housingDAO.getAvailableHousing();

        Assert.isTrue(availableHousing.size() == 4, "FAILED: Actual number is: " + availableHousing.size());
    }
}


 */