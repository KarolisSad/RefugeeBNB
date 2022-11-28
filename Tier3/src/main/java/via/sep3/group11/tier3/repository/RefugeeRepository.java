package via.sep3.group11.tier3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import via.sep3.group11.tier3.model.Refugee;

/**
 * An interface that extends JpaRepository
 *
 * @author Group 11
 * @version 28/11/22
 */

/**
 *
 */
public interface RefugeeRepository extends JpaRepository<Refugee, String> {
}
