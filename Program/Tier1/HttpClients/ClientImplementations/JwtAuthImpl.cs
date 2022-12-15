using System.Net;
using System.Net.Http.Json;
using System.Security.Claims;
using System.Text.Json;
using HttpClients.ClientInterfaces;
using Shared.Domain;
using Shared.DTOs;

namespace HttpClients;

public class JwtAuthImpl : AuthInterface
{

    private readonly HttpClient client;
    public static string? Jwt { get; private set; } = "";


    public JwtAuthImpl(HttpClient client)
    {
        this.client = client;
    }


    public string GetEmail()
    {
        Task<ClaimsPrincipal> principal = GetAuthAsync();
        
        return principal.Result.Claims.First().Value;
    }

    public Action<ClaimsPrincipal> OnAuthStateChanged { get; set; } = null!;


    public async Task<AuthResponseDTO> LoginAsync(LoginDTO dto)
    {
        HttpResponseMessage responseMessage = await client.PostAsJsonAsync("/api/auth/login", dto);
        string responseContent = await responseMessage.Content.ReadAsStringAsync();

        if (!responseMessage.IsSuccessStatusCode)
        {
            if (responseMessage.StatusCode == HttpStatusCode.BadRequest)
            {
                throw new Exception("Error in username or password.");
            }

            throw new Exception(responseContent);
        }

        AuthResponseDTO responseDto = JsonSerializer.Deserialize<AuthResponseDTO>(responseContent,
            new JsonSerializerOptions
            {
                PropertyNameCaseInsensitive = true
            })!;
        

        string token = responseDto.AccessToken;
        Jwt = token;

        ClaimsPrincipal claimsPrincipal = CreateClaimsPrincipal();
        
        OnAuthStateChanged.Invoke(claimsPrincipal);

        return responseDto;
    }

    public Task LogoutAsync()
    {
        Jwt = null;
        ClaimsPrincipal principal = new();
        OnAuthStateChanged.Invoke(principal);
        return Task.CompletedTask;
    }

    public async Task<HostDTO> RegisterHostAsync(HostRegisterDTO dto)
    {
        HttpResponseMessage responseMessage = await client.PostAsJsonAsync<HostRegisterDTO>("/api/auth/register/host", dto);
        string content = await responseMessage.Content.ReadAsStringAsync();

        if (!responseMessage.IsSuccessStatusCode)
        {
            if (responseMessage.StatusCode == HttpStatusCode.BadRequest)
            {
                throw new Exception("Email already in use.");
            }

            throw new Exception(content);
        }

        HostDTO result = JsonSerializer.Deserialize<HostDTO>(content, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;

        return result;
    }

    public async Task<RefugeeDTO> RegisterRefugeeAsync(RefugeeRegisterDTO dto)
    {
        HttpResponseMessage responseMessage = await client.PostAsJsonAsync<RefugeeRegisterDTO>("/api/auth/register/refugee", dto);
        string content = await responseMessage.Content.ReadAsStringAsync();

        if (!responseMessage.IsSuccessStatusCode)
        {
            if (responseMessage.StatusCode == HttpStatusCode.BadRequest)
            {
                throw new Exception("Email already in use.");
            }

            throw new Exception(content);
        }

        RefugeeDTO result = JsonSerializer.Deserialize<RefugeeDTO>(content, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;

        if (!result.ErrorMessage.Equals(""))
        {
            throw new Exception(result.ErrorMessage);
        }

        return result;
    }

    public Task<ClaimsPrincipal> GetAuthAsync()
    {
        ClaimsPrincipal principal = CreateClaimsPrincipal();
        return Task.FromResult(principal);
    }

    
    // Below methods stolen from https://github.com/SteveSandersonMS/presentation-2019-06-NDCOslo/blob/master/demos/MissionControl/MissionControl.Client/Util/ServiceExtensions.cs
    private static IEnumerable<Claim> ParseClaimsFromJwt(string jwt)
    {
        string payload = jwt.Split('.')[1];
        byte[] jsonBytes = ParseBase64WithoutPadding(payload);
        Dictionary<string, object>? keyValuePairs = JsonSerializer.Deserialize<Dictionary<string, object>>(jsonBytes);
        return keyValuePairs!.Select(kvp => new Claim(kvp.Key, kvp.Value.ToString()!));
    }

    private static byte[] ParseBase64WithoutPadding(string base64)
    {
        switch (base64.Length % 4)
        {
            case 2:
                base64 += "==";
                break;
            case 3:
                base64 += "=";
                break;
        }

        return Convert.FromBase64String(base64);
    }

    private static ClaimsPrincipal CreateClaimsPrincipal()
    {
        if (string.IsNullOrEmpty(Jwt))
        {
            return new ClaimsPrincipal();
        }

        IEnumerable<Claim> claims = ParseClaimsFromJwt(Jwt);

        ClaimsIdentity identity = new(claims, "JWT");

        ClaimsPrincipal principal = new(identity);
        
        return principal;
    }
}