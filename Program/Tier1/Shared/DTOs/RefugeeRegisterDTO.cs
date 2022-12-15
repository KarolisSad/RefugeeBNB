using Shared.Domain;

namespace Shared.DTOs;

public class RefugeeRegisterDTO
{
    public string Email{ get; }
    public string Password{ get; }
    public char Gender{ get; }
    public string Nationality{ get; }
    public string FirstName{ get; }
    public string MiddleName{ get; }
    public string LastName{ get; }
    public Date DateOfBirth { get; }
    public int FamilySize { get; }
    public string Description { get; }
    public string ErrorMessage { get; }


    public RefugeeRegisterDTO(string email, string password, char gender, string nationality, string firstName, string middleName, string lastName, Date dateOfBirth, int familySize, string description)
    {
        Email = email;
        Password = password;
        Gender = gender;
        Nationality = nationality;
        FirstName = firstName;
        MiddleName = middleName;
        LastName = lastName;
        DateOfBirth = dateOfBirth;
        FamilySize = familySize;
        Description = description;
    }

    /*
    public RefugeeRegisterDTO(string email, string password, char gender, string nationality,
        string firstName, string middleName, string lastName, Date dateOfBirth, int familySize, string description,
        string errorMessage)
    {
        Email = email;
        Password = password;
        Gender = gender;
        Nationality = nationality;
        FirstName = firstName;
        MiddleName = middleName;
        LastName = lastName;
        DateOfBirth = dateOfBirth;
        FamilySize = familySize;
        Description = description;
        ErrorMessage = errorMessage;
    }
    

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
        ErrorMessage = "";
    }
    */
}