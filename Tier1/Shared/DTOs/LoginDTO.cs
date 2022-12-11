namespace Shared.DTOs;

public class LoginDTO
{
    public string Email { get; }
    public string Password { get; }

   // public string ErrorMessage { get; }

   /*
    public LoginDTO(string email, string password, string errorMessage)
    {
        this.Email = email;
        this.Password = password;
        ErrorMessage = errorMessage;
    }
    */
    
    public LoginDTO(string email, string password)
    {
        this.Email = email;
        this.Password = password;
    }
}