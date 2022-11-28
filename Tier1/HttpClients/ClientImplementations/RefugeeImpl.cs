using System.Net.Http.Json;
using System.Text.Json;
using HttpClients.ClientInterfaces;
using Shared.Domain;

namespace HttpClients.ClientImplementations;

public class RefugeeImpl:RefugeeInterface
{
    private readonly HttpClient client;

    public RefugeeImpl(HttpClient client)
    {
        this.client = client;
    }

    public async Task RegisterRefugee(Refugee refugee)
    {
        HttpResponseMessage responseMessage = await client.PostAsJsonAsync("/refugee", refugee);
        if (!responseMessage.IsSuccessStatusCode)
        {
            string content = await responseMessage.Content.ReadAsStringAsync();
            throw new Exception(content);
        }
        
    }

    public async Task<Refugee> LoginRefugee(string email, string password)
    {
        Refugee existing = await GetRefugeeAsync(email);
        
        //password check
        if (existing.Password.Equals(password))
        {
            throw new Exception("Your password does not match");
        }

        return existing;
    }

    private async Task<Refugee> GetRefugeeAsync(string email)
    {
        HttpResponseMessage responseMessage = await client.GetAsync($"/refugee/{email}");
        string content = await responseMessage.Content.ReadAsStringAsync();
        if (!responseMessage.IsSuccessStatusCode)
        {
            throw new Exception(content);
        }

        Refugee refugee = JsonSerializer.Deserialize<Refugee>(content, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;
        
        return refugee;
    }
}