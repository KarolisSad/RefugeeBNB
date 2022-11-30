package via.sep3.group11.tier2.shared.domain;

public class Agreement {
    private Long agreementId;

    private Host host;
    private Housing housing;
    private Refugee refugee;

    public Agreement(Long agreementId, Host host, Housing housing, Refugee refugee) {
        this.agreementId = agreementId;
        this.host = host;
        this.housing = housing;
        this.refugee = refugee;
    }
}
