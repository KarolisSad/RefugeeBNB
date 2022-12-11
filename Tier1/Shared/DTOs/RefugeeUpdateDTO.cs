namespace Shared.DTOs;

public class RefugeeUpdateDTO
{
    public string Email { get; }
    public string? Password { get; }
    public char? Gender { get; }
    public string? Nationality { get; }
    public string? FirstName { get; }
    public string? MiddleName { get; }
    public string? LastName { get; }
    public int? FamilySize { get; }
    public string? Description { get; }

    public RefugeeUpdateDTO(string email, string? password, char? gender, string? nationality, string? firstName, string? middleName, string? lastName, int? familySize, string? description)
    {
        Email = email;
        Password = password;
        Gender = gender;
        Nationality = nationality;
        FirstName = firstName;
        MiddleName = middleName;
        LastName = lastName;
        FamilySize = familySize;
        Description = description;
    }
}