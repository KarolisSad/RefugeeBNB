package via.sep3.group11.tier3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import via.sep3.group11.tier3.model.Refugee;

public interface RefugeeRepository extends JpaRepository<Refugee, String> {
}
