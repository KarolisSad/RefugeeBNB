//package via.sep3.group11.tier3;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.util.Assert;
//import via.sep3.group11.tier3.DAO.DAOImplementations.AgreementDAOImplementation;
//import via.sep3.group11.tier3.DAO.DAOImplementations.HostDAOImplementation;
//import via.sep3.group11.tier3.DAO.DAOImplementations.HousingDAOImplementation;
//import via.sep3.group11.tier3.DAO.DAOImplementations.RefugeeDAOImplementation;
//import via.sep3.group11.tier3.model.*;
//import via.sep3.group11.tier3.repository.AgreementRepository;
//
//import java.time.LocalDate;
//import java.util.List;
//
//@SpringBootTest
//public class Tier3AgreementPersistenceTests {
//
//    @Autowired
//    HostDAOImplementation hostDao;
//    @Autowired
//    RefugeeDAOImplementation refugeeDao;
//    @Autowired
//    HousingDAOImplementation housingDao;
//    @Autowired
//    AgreementDAOImplementation agreementDao;
//
//    @Autowired
//    AgreementRepository agreementRepo;
//
//    Refugee refugee;
//    Refugee refugee1;
//    Refugee refugee2;
//    Refugee refugee3;
//    Refugee refugee4;
//    Host host;
//    Host host1;
//    Host host2;
//    Host host3;
//    Housing housing;
//    Housing housing1;
//    Housing housing2;
//    Housing housing3;
//    Housing housing4;
//
//    @Test
//    void contextLoads() {
//    }
//
//    @BeforeEach
//    void setup() {
//        System.out.println("<STARTING>...");
//
//        host = new Host(
//                "test@test.dk",
//                "Bob",
//                "teh",
//                "Builder",
//                "bobpassword",
//                "Danish",
//                'M',
//                new Date(1,1,1992)
//        );
//        host1 = new Host(
//                "host1@test.dk",
//                "Bob",
//                "teh",
//                "Builder",
//                "bobpassword",
//                "Danish",
//                'M',
//                new Date(1,1,1992)
//        );
//        host2 = new Host(
//                "host2@test.dk",
//                "Bob",
//                "teh",
//                "Builder",
//                "bobpassword",
//                "Danish",
//                'M',
//                new Date(1,1,1992)
//        );
//        host3 = new Host(
//                "host3@test.dk",
//                "Bob",
//                "teh",
//                "Builder",
//                "bobpassword",
//                "Danish",
//                'M',
//                new Date(1,1,1992)
//        );
//
//        hostDao.createHost(host);
//        hostDao.createHost(host1);
//        hostDao.createHost(host2);
//        hostDao.createHost(host3);
//        System.out.println("Finished setting up hosts");
//
//        refugee = new Refugee(
//                "refugee@test.dk",
//                "Robert",
//                "",
//                "Refugee",
//                "refugeepassword",
//                "danish",
//                'M',
//                new Date(1,1,1)
//        );
//        refugee1 = new Refugee(
//                "refugee@test.dk",
//                "Robert",
//                "",
//                "Refugee",
//                "refugeepassword",
//                "danish",
//                'M',
//                new Date(1,1,1)
//        );
//        refugee2 = new Refugee(
//                "refugee@test.dk",
//                "Robert",
//                "",
//                "Refugee",
//                "refugeepassword",
//                "danish",
//                'M',
//                new Date(1,1,1)
//        );
//        refugee3 = new Refugee(
//                "refugee@test.dk",
//                "Robert",
//                "",
//                "Refugee",
//                "refugeepassword",
//                "danish",
//                'M',
//                new Date(1,1,1)
//        );
//        refugee4 = new Refugee(
//                "refugee@test.dk",
//                "Robert",
//                "",
//                "Refugee",
//                "refugeepassword",
//                "danish",
//                'M',
//                new Date(1,1,1)
//        );
//
//        refugeeDao.createRefugee(refugee);
//        refugeeDao.createRefugee(refugee1);
//        refugeeDao.createRefugee(refugee2);
//        refugeeDao.createRefugee(refugee3);
//        refugeeDao.createRefugee(refugee4);
//        System.out.println("Finished setting up refugees");
//
//        housing = new Housing(
//                1,2,
//                new Address("housing", "Horsens", "Ryesgade", "4F", "1.02", "8700")
//        );
//        housing1 = new Housing(
//                1,2,
//                new Address("housing1", "Horsens", "Ryesgade", "4F", "1.02", "8700")
//        );
//        housing2 = new Housing(
//                1,2,
//                new Address("housing2", "Horsens", "Ryesgade", "4F", "1.02", "8700")
//        );
//        housing3 = new Housing(
//                1,2,
//                new Address("housing3", "Horsens", "Ryesgade", "4F", "1.02", "8700")
//        );
//        housing4 = new Housing(
//                1,2,
//                new Address("housing4", "Horsens", "Ryesgade", "4F", "1.02", "8700")
//        );
//
//        housing = housingDao.addHousing(housing, "test@test.dk");
//        housing = housingDao.addHousing(housing, "host1@test.dk");
//        housing = housingDao.addHousing(housing1, "host1@test.dk");
//        housing = housingDao.addHousing(housing2, "host1@test.dk");
//        housing = housingDao.addHousing(housing3, "host2@test.dk");
//        housing = housingDao.addHousing(housing4, "host3@test.dk");
//        System.out.println("Finished setting up housing");
//
//
//        agreementRepo.deleteAll();
//
//        System.out.println("Finished setup!");
//    }
//
//    @Test
//    void addAndGetAgreement() {
//        Agreement agreement = new Agreement(
//                new Date(30,11,2022),
//                refugee,
//                housing,
//                host
//        );
//
//        Agreement agreementReturned = agreementDao.addAgreement(agreement);
//        Agreement testGet = agreementDao.getAgreementById(agreementReturned.getAgreementId()).get();
//
//        Assert.isTrue(agreementReturned.getHost().getEmail().equals(agreement.getHost().getEmail()), "FAILED!");
//        Assert.isTrue(testGet.getHost().getEmail().equals(agreement.getHost().getEmail()), "FAILED!");
//    }
//
//    @Test
//    void agreementsByHostEmail() {
//        Agreement agreement1 = new Agreement(
//                new Date(30,11,2022),
//                refugee,
//                housing,
//                host1
//        );
//        Agreement agreement2 = new Agreement(
//                new Date(30,11,2022),
//                refugee1,
//                housing1,
//                host1
//        );
//        Agreement agreement3 = new Agreement(
//                new Date(30,11,2022),
//                refugee2,
//                housing2,
//                host1
//        );
//        Agreement agreement4 = new Agreement(
//                new Date(30,11,2022),
//                refugee3,
//                housing3,
//                host2
//        );
//        Agreement agreement5 = new Agreement(
//                new Date(30,11,2022),
//                refugee4,
//                housing4,
//                host3
//        );
//
//
//        agreementDao.addAgreement(agreement1);
//        agreementDao.addAgreement(agreement2);
//        agreementDao.addAgreement(agreement3);
//        agreementDao.addAgreement(agreement4);
//        agreementDao.addAgreement(agreement5);
//
//        List<Agreement> agreementsHost1 = agreementDao.getAgreementsByHostId("host1@test.dk");
//        List<Agreement> agreementsHost2 = agreementDao.getAgreementsByHostId("host2@test.dk");
//        List<Agreement> agreementsHost3 = agreementDao.getAgreementsByHostId("host3@test.dk");
//
//        Assert.isTrue(agreementsHost1.size() == 3, "FAILED HOST1, Actual size: " + agreementsHost1.size());
//        Assert.isTrue(agreementsHost2.size() == 1, "FAILED HOST2, Actual size: " + agreementsHost2.size());
//        Assert.isTrue(agreementsHost3.size() == 1, "FAILED HOST3, Actual size: " + agreementsHost3.size());
//
//    }
//
//    @Test
//    void removeAgreement() {
//        Agreement a1 = new Agreement(
//                new Date(1,12,2022),
//                refugee4,
//                housing1,
//                host1
//        );
//        Agreement a2 = new Agreement(
//                new Date(1,12,2022),
//                refugee3,
//                housing1,
//                host1
//        );
//
//        agreementDao.addAgreement(a1);
//        agreementDao.addAgreement(a2);
//
//        List<Agreement> host1 = agreementDao.getAgreementsByHostId("host1@test.dk");
//
//        Assert.isTrue(host1.size() == 2, "FAILED HOST1, Actual size: " + host1.size());
//
//        agreementDao.deleteAgreement(host1.get(1).getAgreementId());
//
//        host1 = agreementDao.getAgreementsByHostId("host1@test.dk");
//        Assert.isTrue(host1.size() == 1, "FAILED HOST1, Actual size: " + host1.size());
//    }
//
//    @Test
//    void allPendingAgreementsByHostEmail() {
//        // Todo need to be able to set state to test
//    }
//
//    @Test
//    void agreementsByHousingId() {
//        Agreement agreement = new Agreement(
//                new Date(30,11,2022),
//                refugee,
//                housing,
//                host
//        );
//        Agreement agreement1 = new Agreement(
//                new Date(30,11,2022),
//                refugee,
//                housing,
//                host
//        );
//        Agreement agreement2 = new Agreement(
//                new Date(30,11,2022),
//                refugee,
//                housing,
//                host
//        );
//        Agreement agreement3 = new Agreement(
//                new Date(30,11,2022),
//                refugee,
//                housing1,
//                host
//        );
//        Agreement agreement4 = new Agreement(
//                new Date(30,11,2022),
//                refugee,
//                housing1,
//                host
//        );
//        Agreement agreement5 = new Agreement(
//                new Date(30,11,2022),
//                refugee,
//                housing2,
//                host
//        );
//
//        agreementDao.addAgreement(agreement);
//        agreementDao.addAgreement(agreement1);
//        agreementDao.addAgreement(agreement2);
//        agreementDao.addAgreement(agreement3);
//        agreementDao.addAgreement(agreement4);
//        agreementDao.addAgreement(agreement5);
//
//        List<Agreement> housingAgreements = agreementDao.getAllAgreementsByHousingId(housing.getHousingId());
//        List<Agreement> housingAgreements1 = agreementDao.getAllAgreementsByHousingId(housing1.getHousingId());
//        List<Agreement> housingAgreements2 = agreementDao.getAllAgreementsByHousingId(housing2.getHousingId());
//
//        Assert.isTrue(housingAgreements.size() == 3, "Housingagreements failed. Actual size is: " + housingAgreements.size());
//        Assert.isTrue(housingAgreements1.size() == 2, "Housingagreements1 failed. Actual size is: " + housingAgreements1.size());
//        Assert.isTrue(housingAgreements2.size() == 1, "Housingagreements2 failed. Actual size is: " + housingAgreements2.size());
//
//    }
//
//}
//
//
