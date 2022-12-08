namespace Shared.DTOs;

public class HostUpdateDTO
{
    public string? Password { get; }
    public char? Gender { get; }
    public string? Nationality { get; }
    public string? FirstName { get; }
    public string? MiddleName { get;  }
    public string? LastName { get; }
    public string ErrorMessage { get; }

    public HostUpdateDTO(string? password, char? gender, string? nationality, string? firstName, string? middleName, string? lastName, string errorMessage)
    {
        Password = password;
        Gender = gender;
        Nationality = nationality;
        FirstName = firstName;
        MiddleName = middleName;
        LastName = lastName;
        ErrorMessage = errorMessage;
    }
}