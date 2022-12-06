package via.sep3.group11.tier3;

import org.junit.jupiter.api.BeforeEach;
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
import via.sep3.group11.tier3.repository.HostRepository;
import via.sep3.group11.tier3.repository.HousingRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
/*
@SpringBootTest
public class Tier3HostPersistenceTests {

    @Autowired
    HostDAOImplementation hostDao;

    @Autowired
    HousingDAOImplementation housingDAO;

    @Autowired
    HostRepository hostRepository;
    @Autowired
    HousingRepository housingRepo;

    List<Host> allHosts;



    @BeforeEach
    void setup() {

        allHosts = new ArrayList<>();
        System.out.println("List cleared!");

        housingRepo.deleteAll();
        hostRepository.deleteAll();
        System.out.println("Database cleared!");
    }

    @Test
    void addOneHostTest() {
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

        allHosts = hostRepository.findAll();
        Assert.isTrue(allHosts.size() == 1, "FAILED! Actual size = " + allHosts.size());
    }

    @Test
    void getHostByHousingId() {
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
                "test123@test.dk",
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

        Housing housing1 = new Housing(
                1,
                new Address("Denmark", "Horsens", "Ryesgade", "4F", "1.02", "8700")
        );

        Housing housing2 = new Housing(
                1,
                new Address("Denmark", "Horsens", "Ryesgade", "4F", "1.02", "8700")
        );

        housing1 = housingDAO.addHousing(housing1, "test@test.dk");
        housing2 = housingDAO.addHousing(housing2, "test123@test.dk");

        Optional<Host> get1 = hostDao.getHostByHousingId(housing1.getHousingId());
        Optional<Host> get2 = hostDao.getHostByHousingId(housing2.getHousingId());

        Assert.isTrue(get1.get().getEmail().equals(housing1.host.getEmail()), "WRONG: " + housing1.host.getEmail());
        Assert.isTrue(get2.get().getEmail().equals(housing2.host.getEmail()), "WRONG: " + housing2.host.getEmail());
    }
}

 */
