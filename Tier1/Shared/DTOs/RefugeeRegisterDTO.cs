using Shared.Domain;

namespace Shared.DTOs;

public class RefugeeRegisterDTO
{
    private string Email{ get; }
    private string Password{ get; }
    private char Gender{ get; }
    private string Nationality{ get; }
    private string FirstName{ get; }
    private string MiddleName{ get; }
    private string LastName{ get; }
    private Date DateOfBirth { get; }

    public RefugeeRegisterDTO(string email, string password, char gender, string nationality, string firstName, string middleName, string lastName, Date dateOfBirth)
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
}