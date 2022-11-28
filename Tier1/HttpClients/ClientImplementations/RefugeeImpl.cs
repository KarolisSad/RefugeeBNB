using System.Net.Http.Json;
using System.Text.Json;
using HttpClients.ClientInterfaces;
using Shared.Domain;
using Shared.DTOs;

namespace HttpClients.ClientImplementations;

public class RefugeeImpl:RefugeeInterface
{
    private readonly HttpClient client;

    public RefugeeImpl(HttpClient client)
    {
        this.client = client;
    }

    public async Task RegisterRefugee(RefugeeRegisterDTO dto)
    {
        HttpResponseMessage responseMessage = await client.PostAsJsonAsync("/refugee", dto);
        if (!responseMessage.IsSuccessStatusCode)
        {
            string content = await responseMessage.Content.ReadAsStringAsync();
            throw new Exception(content);
        }
    }

    public async Task<Refugee> LoginRefugee(LoginDTO dto)
    {
        HttpResponseMessage responseMessage = await client.PostAsJsonAsync("/refugee/login", dto);
        
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

    /**
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
    */
}