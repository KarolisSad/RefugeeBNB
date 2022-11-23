
namespace Shared.Domain;

public class Host
{
    private string firstName = "";
    private string Email { get; set; }
    private string Password { get; set; }
    private char Gender { get; set; }
    private string Nationality { get; set; }
    private string FirstName { get; set; }
    private string MiddleName { get; set; }
    private string LastName { get; set; }
    
    
    private Date DateOfBirth { get; set; }
    private ICollection<Housing> MyHousings { get; set; }

    public Host(string email, string password, char gender, string nationality, string firstName, string lastName, string middleName, Date dateOfBirth, ICollection<Housing> myHousings)
    {
        Email = email;
        Password = password;
        Gender = gender;
        Nationality = nationality;
        FirstName = firstName;
        LastName = lastName;
        MiddleName = middleName;
        DateOfBirth = dateOfBirth;
        MyHousings = myHousings;
    }

    public Host()
    {
    }
}