package via.sep3.group11.tier3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import via.sep3.group11.tier3.model.Agreement;

import java.util.List;

public interface AgreementRepository extends JpaRepository<Agreement, Long> {
    List<Agreement> findAgreementsByHost_Email(String hostEmail);
    List<Agreement> findAgreementsByAcceptedIsFalseAndHost_Email(String hostEmail);
    List<Agreement> findAgreementsByHousing_HousingId(long housingId);
    Agreement findAgreementByRefugee_Email(String refugeeEmail);
}
