package via.sep3.group11.tier3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import via.sep3.group11.tier3.DAO.DAOImplementations.HostDAOImplementation;
import via.sep3.group11.tier3.model.Date;
import via.sep3.group11.tier3.model.Host;
import via.sep3.group11.tier3.repository.HostRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class Tier3HostPersistenceTests {

    @Autowired
    HostDAOImplementation hostDao;

    @Autowired
    HostRepository hostRepository;
    List<Host> allHosts = new ArrayList<>();



    @BeforeEach
            void emptyList() {
     for (int i = 0; i < allHosts.size(); i++) {
         allHosts.remove(i);
     }

        System.out.println("List cleared!");
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
}
