package via.sep3.group11.tier2.shared.domain;

public class Agreement {
    private Long agreementId;

    private Host host;
    private Housing housing;
    private Refugee refugee;
    private boolean isAccepted;

    public Agreement(Long agreementId, Host host, Housing housing, Refugee refugee, boolean isAccepted) {
        this.agreementId = agreementId;
        this.host = host;
        this.housing = housing;
        this.refugee = refugee;
        this.isAccepted = isAccepted;
    }

    // Used when creating new Agreement - we don't know ID yet
    public Agreement(Host host, Housing housing, Refugee refugee) {
        this.host = host;
        this.housing = housing;
        this.refugee = refugee;
        this.isAccepted = false;
    }

    public Long getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(Long agreementId) {
        this.agreementId = agreementId;
    }

    public Host getHost() {
        return host;
    }

    public void setHost(Host host) {
        this.host = host;
    }

    public Housing getHousing() {
        return housing;
    }

    public void setHousing(Housing housing) {
        this.housing = housing;
    }

    public Refugee getRefugee() {
        return refugee;
    }

    public void setRefugee(Refugee refugee) {
        this.refugee = refugee;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }
}
