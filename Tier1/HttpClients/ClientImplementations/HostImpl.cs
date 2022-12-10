using System.Net.Http.Headers;
using System.Net.Http.Json;
using System.Text;
using System.Text.Json;
using HttpClients.ClientInterfaces;
using Shared.Domain;
using Shared.DTOs;

namespace HttpClients.ClientImplementations;

//this is a Http Host Client
public class HostImpl:HostInterface
{

    private readonly HttpClient client;


    public HostImpl(HttpClient client)
    {
        this.client = client;
    }

    public async Task<HostDTO> GetHostByHousingIdAsync(long housingId)
    {
        Console.WriteLine("HousingID: " + housingId);
        HttpResponseMessage responseMessage = await client.GetAsync($"/api/host/{housingId}");
        Console.WriteLine(responseMessage);
        
        string content = await responseMessage.Content.ReadAsStringAsync();
        if (!responseMessage.IsSuccessStatusCode)
        {
            throw new Exception(content);
        }
        
        

        HostDTO host = JsonSerializer.Deserialize<HostDTO>(content, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;
        
        return host;
    }
    
    public async Task<HostDTO> DeleteAccountAsync(string email)
    {
        client.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue("Bearer", JwtAuthImpl.Jwt);
        HttpResponseMessage responseMessage = await client.DeleteAsync($"/api/host/delete/{email}");
        
        string content = await responseMessage.Content.ReadAsStringAsync();
        if (!responseMessage.IsSuccessStatusCode)
        {
            throw new Exception(content);
        }

        HostDTO host = JsonSerializer.Deserialize<HostDTO>(content, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;
        
        if (!host.ErrorMessage.Equals(""))
        {
            throw new Exception(host.ErrorMessage);
        }
        
        return host;
    }
}