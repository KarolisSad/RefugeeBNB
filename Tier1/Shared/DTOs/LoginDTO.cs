namespace Shared.DTOs;

public class LoginDTO
{
    public string Email { get; }
    public string Password { get; }

    public LoginDTO(string email, string password)
    {
        this.Email = email;
        this.Password = password;
    }
}