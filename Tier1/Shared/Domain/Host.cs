
namespace Shared.Domain;

public class Host
{
    public string Email { get; set; }
    public string Password { get; set; }
    public char Gender { get; set; }
    public string Nationality { get; set; }
    public string FirstName { get; set; }
    public string MiddleName { get; set; }
    public string LastName { get; set; }
    
    
    public Date DateOfBirth { get; set; }
    public ICollection<Housing> MyHousings { get; set; }

    public Host(string firstName, string email, string password, char gender, string nationality,
        string middleName, string lastName, Date dateOfBirth)
    {
        Email = email;
        Password = password;
        Gender = gender;
        Nationality = nationality;
        FirstName = firstName;
        LastName = lastName;
        MiddleName = middleName;
        DateOfBirth = dateOfBirth;
        MyHousings = new List<Housing>();
    }

    public Host(string email, string password, char gender, string nationality, string firstName, string middleName, string lastName, Date dateOfBirth, ICollection<Housing> myHousings)
    {
        Email = email;
        Password = password;
        Gender = gender;
        Nationality = nationality;
        FirstName = firstName;
        MiddleName = middleName;
        LastName = lastName;
        DateOfBirth = dateOfBirth;
        MyHousings = myHousings;
    }

    public Host()
    {
    }

}