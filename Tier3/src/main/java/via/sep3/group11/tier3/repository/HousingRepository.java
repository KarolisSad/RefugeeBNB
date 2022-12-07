package via.sep3.group11.tier3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import via.sep3.group11.tier3.model.Host;
import via.sep3.group11.tier3.model.Housing;

import java.util.List;
import java.util.Optional;

/**
 * Class extends JPA Repository, provides functionality for managing and structuring the database
 *
 * @version 28/11/22
 * @author Group 11
 */
public interface HousingRepository extends JpaRepository<Housing, Long> {
    List<Housing> findAllByAvailableTrue();
    List<Housing> findAllByHost_Email(String email);
}
