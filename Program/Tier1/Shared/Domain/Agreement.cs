namespace Shared.Domain;

public class Agreement
{
    public long AgreementId { get; set; }

    public Date Date { get; set; }

    public Refugee Refugee { get; set; }

    public Housing Housing { get; set; }

    public Host Host { get; set; }

    public bool Accepted { get; set; }

    public Agreement(long agreementId, Date date, Refugee refugee, Housing housing, Host host, bool accepted)
    {
        AgreementId = agreementId;
        Date = date;
        Refugee = refugee;
        Housing = housing;
        Host = host;
    }
    public Agreement(Date date, Refugee refugee, Housing housing, Host host, bool accepted)
    {
        Date = date;
        Refugee = refugee;
        Housing = housing;
        Host = host;
        Accepted = accepted;
    }

    public Agreement()
    {
        
    }
}