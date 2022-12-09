package via.sep3.group11.tier3.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import via.sep3.group11.tier3.model.Date;
import via.sep3.group11.tier3.model.Host;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
/*
@DataJpaTest
class HostRepositoryTest {
/*
    @Autowired
    private HostRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void deleteExistingHost() {
        // given
        String email = "Bob@gmail.com";
        Host host = new Host(
                email,
                "Bob",
                "",
                "Builder",
                "builder",
                "Denmark",
                'M',
                new Date(01,01,1999)
        );
        underTest.save(host);

        // when
        underTest.deleteHostByEmail(email);
        //then
        assertThat(underTest.findById(email)).isEmpty();
    }

//  ---------  Already tested  ---------
    @Test
    void addOneHost() {
        // given
        String email = "Bob@gmail.com";
        Host host = new Host(
                email,
                "Bob",
                "",
                "Builder",
                "builder",
                "Denmark",
                'M',
                new Date(01,01,1999)
        );
        underTest.save(host);

        // when
        Optional<Host> expected = underTest.findById(email);
        //then
        assertThat(expected.get().getEmail()).contains(email);
    }

    @Test
    void gettingNonExistentHost() {
        // given
        String email = "Bob@gmail.com";

        // when
        Optional<Host> expected = underTest.findById(email);
        //then
        assertThat(expected.isEmpty());
    }

 */
}
