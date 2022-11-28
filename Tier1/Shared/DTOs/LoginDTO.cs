namespace Shared.DTOs;

public class LoginDTO
{
    private string Email { get; }
    private string Password { get; }

    public LoginDTO(string email, string password)
    {
        this.Email = email;
        this.Password = password;
    }
}