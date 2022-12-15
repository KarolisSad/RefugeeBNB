using Shared.Domain;

namespace Shared.DTOs;

public class HostRegisterDTO
{
    public string Email { get; }
    public string Password { get; }
    public char Gender { get; }
    public string Nationality { get; }
    public string FirstName { get; }
    public string MiddleName { get; }
    public string LastName { get; }
    public Date DateOfBirth { get; }
    
    public string ErrorMessage { get; }

    public HostRegisterDTO(string email, string password, char gender, string nationality, string firstName,
        string middleName, string lastName, Date dateOfBirth, string errorMessage)

    {
        Email = email;
        Password = password;
        Gender = gender;
        Nationality = nationality;
        FirstName = firstName;
        MiddleName = middleName;
        LastName = lastName;
        DateOfBirth = dateOfBirth;
        ErrorMessage = errorMessage;
    }
    
    public HostRegisterDTO(string email, string password, char gender, string nationality, string firstName,
        string middleName, string lastName, Date dateOfBirth)

    {
        Email = email;
        Password = password;
        Gender = gender;
        Nationality = nationality;
        FirstName = firstName;
        MiddleName = middleName;
        LastName = lastName;
        DateOfBirth = dateOfBirth;
        ErrorMessage = "";
    }
}