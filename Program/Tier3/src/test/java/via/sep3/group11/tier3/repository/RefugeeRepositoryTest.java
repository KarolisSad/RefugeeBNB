package via.sep3.group11.tier3.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import via.sep3.group11.tier3.model.Date;
import via.sep3.group11.tier3.model.Refugee;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
/*
@DataJpaTest
class RefugeeRepositoryTest {
/*
    @Autowired
    private RefugeeRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void deleteExistingHost() {
        // given
        String email = "Bob@gmail.com";
        Refugee refugee = new Refugee(
                email,
                "Bob",
                "",
                "Builder",
                "builder",
                "Denmark",
                'M',
                new Date(01,01,1999),
                1,
                ""
        );
        underTest.save(refugee);
        assertThat(underTest.findById("Bob@gmail.com")).isNotEmpty();
        // when
        underTest.deleteByEmail(email);
        //then
        assertThat(underTest.findById(email)).isEmpty();
    }


}

 */

