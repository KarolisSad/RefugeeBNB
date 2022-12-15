using System.Net.Http.Headers;
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

    public async Task<RefugeeDTO> DeleteAccountAsync(string email)
    {
        client.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue("Bearer", JwtAuthImpl.Jwt);
        HttpResponseMessage responseMessage = await client.DeleteAsync($"/api/refugee/delete/{email}");
        
        string content = await responseMessage.Content.ReadAsStringAsync();
        if (!responseMessage.IsSuccessStatusCode)
        {
            Console.WriteLine(content);
            throw new Exception(content);
        }

        RefugeeDTO refugee = JsonSerializer.Deserialize<RefugeeDTO>(content, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;
        
        return refugee;
    }

    public async Task<RefugeeDTO> UpdateInformation(RefugeeUpdateDTO dto)
    {
        client.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue("Bearer", JwtAuthImpl.Jwt);
        HttpResponseMessage responseMessage = await client.PostAsJsonAsync($"/api/refugee/update", dto);
        
        string content = await responseMessage.Content.ReadAsStringAsync();
        if (!responseMessage.IsSuccessStatusCode)
        {
            Console.WriteLine(content);
            throw new Exception(content);
        }

        RefugeeDTO refugee = JsonSerializer.Deserialize<RefugeeDTO>(content, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;
        
        return refugee;
    }

    public async Task<RefugeeDTO> GetRefugee(string email)
    {
        client.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue("Bearer", JwtAuthImpl.Jwt);
        HttpResponseMessage responseMessage = await client.GetAsync($"/api/refugee/{email}");
        
        string content = await responseMessage.Content.ReadAsStringAsync();
        if (!responseMessage.IsSuccessStatusCode)
        {
            throw new Exception(content);
        }
        
        RefugeeDTO refugee = JsonSerializer.Deserialize<RefugeeDTO>(content, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;
        
        return refugee;    
    }
}