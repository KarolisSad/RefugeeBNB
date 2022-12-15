namespace Shared.DTOs;

public class AuthResponseDTO
{
    public string AccessToken { get; set; }
    public string TokenType { get; } = "Bearer ";

    public AuthResponseDTO(string accessToken)
    {
        AccessToken = accessToken;
    }
}