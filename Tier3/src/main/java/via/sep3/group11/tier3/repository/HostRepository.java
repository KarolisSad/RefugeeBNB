package via.sep3.group11.tier3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import via.sep3.group11.tier3.model.Host;

import java.util.Optional;

/**
 * Class extends JPA Repository, provides functionality for managing and structuring the database
 *
 * @version 28/11/22
 * @author Group 11
 */
public interface HostRepository extends JpaRepository<Host, String> {
}
