package via.sep3.group11.tier3;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.jdbc.JdbcTestUtils;
import org.springframework.util.Assert;
import via.sep3.group11.tier3.DAO.DAOImplementations.HostDAOImplementation;
import via.sep3.group11.tier3.DAO.DAOImplementations.HousingDAOImplementation;
import via.sep3.group11.tier3.model.Address;
import via.sep3.group11.tier3.model.Date;
import via.sep3.group11.tier3.model.Host;
import via.sep3.group11.tier3.model.Housing;

import java.util.ArrayList;
import java.util.List;
/*
@SpringBootTest
public class Tier3HousingPersistenceTests {

    @Autowired
    HostDAOImplementation hostDao;
    @Autowired
    HousingDAOImplementation housingDAO;

    String email = "test@test.dk";

    List<Housing> housingList;

    @BeforeEach
    void addOneHost() {
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
        System.out.println("<STARTING> Host: " + host.getEmail() + " added!");
    }

    @BeforeEach
    void emptyList() {
        housingList = new ArrayList<>();

        System.out.println("<STARTING> List reset to empty!");
    }

    @Test
    void contextLoads() {
    }

    @Test
    void housingTest() {
        Housing housing1 = new Housing(
                1,
                new Address("Denmark", "Horsens", "Ryesgade", "4F", "1.02", "8700")
        );

        Housing housing2 = new Housing(
                1,
                new Address("Denmark", "Horsens", "Ryesgade", "4F", "1.02", "8700")
        );

        Housing housing3 = new Housing(
                1,
                new Address("THREE", "Horsens", "Ryesgade", "4F", "1.02", "8700")
        );

        Housing housing4 = new Housing(
                1,
                new Address("Denmark", "Horsens", "Ryesgade", "4F", "1.02", "8700")
        );

        housingDAO.addHousing(housing1, email);
        housingList = housingDAO.getAvailableHousing();
        Assert.isTrue(housingList.size() == 1, "FAILED! Size is " + housingList.size());

        housingDAO.addHousing(housing2, email);
        housingList = housingDAO.getAvailableHousing();
        Assert.isTrue(housingList.size() == 2, "FAILED! Size is " + housingList.size());


        housingDAO.addHousing(housing3, email);
        housingList = housingDAO.getAvailableHousing();
        Assert.isTrue(housingList.size() == 3, "FAILED! Size is " + housingList.size());


        housingDAO.addHousing(housing4, email);
        housingList = housingDAO.getAvailableHousing();
        Assert.isTrue(housingList.size() == 4, "FAILED! Size is " + housingList.size());

        housingDAO.removeHousing(4);
        housingList = housingDAO.getAvailableHousing();
        Assert.isTrue(housingList.size() == 3, "FAILED! Size is " + housingList.size());

        Housing h = housingDAO.getHousingById(3).get();
        Assert.isTrue(h.getAddress().getCountry().equals("THREE"), "FAILED! Country is " + h.getAddress().getCountry());




    }

    /*
    @Test
    void addOneHousing() {
        Housing housing = new Housing(
                1,
                new Address("Denmark", "Horsens", "Ryesgade", "4F", "1.02", "8700")
        );

        housingDAO.addHousing(housing, email);
        housingList = housingDAO.getAvailableHousing();

        Assert.isTrue(housingList.size() == 1, "FAILED! Size is " + housingList.size());
    }

    @Test
    void getOneHousing() {
        Housing housing = housingDAO.getHousingById(1).get();

        System.out.println(housing.getHousingId() + " " + housing.host.getFirstName());
    }

     */