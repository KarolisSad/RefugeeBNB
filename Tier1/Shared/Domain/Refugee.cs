namespace Shared.Domain;

public class Refugee
{
    private string Email { get; set; }
    private string Password { get; set; }
    private char Gender { get; set; }
    private string Nationality { get; set; }
    private string FirstName { get; set; }
    private string MiddleName { get; set; }
    private string LastName { get; set; }
    
    private Date DateOfBirth { get; set; }

    public Refugee(string email, string password, char gender, string nationality, string firstName, string middleName, string lastName, Date dateOfBirth)
    {
        Email = email;
        Password = password;
        Gender = gender;
        Nationality = nationality;
        FirstName = firstName;
        MiddleName = middleName;
        LastName = lastName;
        DateOfBirth = dateOfBirth;
    }

    public Refugee()
    {
    }
}