package via.sep3.group11.tier2.shared.DTOs;

import via.sep3.group11.tier2.shared.domain.Refugee;

public class AgreementsByHostDTO {
    private String hostEmail;
    private Refugee refugee;

    public AgreementsByHostDTO(String hostEmail, Refugee refugee) {
        this.hostEmail = hostEmail;
        this.refugee = refugee;
    }
}
