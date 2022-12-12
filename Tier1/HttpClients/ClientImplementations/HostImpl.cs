using System.Net.Http.Headers;
using System.Net.Http.Json;
using System.Text.Json;
using HttpClients.ClientInterfaces;
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
        try
        {
            client.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue("Bearer", JwtAuthImpl.Jwt);
            Console.WriteLine("HousingID: " + housingId);
            HttpResponseMessage responseMessage = await client.GetAsync($"/api/host/housing/{housingId}");
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
        catch (Exception e)
        {
            Console.WriteLine("CRASH" + e);
            throw;
        }
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

    public async Task<HostDTO> UpdateInformation(HostUpdateDTO dto)
    {
        client.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue("Bearer", JwtAuthImpl.Jwt);
        HttpResponseMessage responseMessage = await client.PostAsJsonAsync($"/api/host/update", dto);
        
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

    public async Task<HostDTO> GetHost(string email)
    {
        client.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue("Bearer", JwtAuthImpl.Jwt);
        HttpResponseMessage responseMessage = await client.GetAsync($"/api/host/{email}");
        string content = await responseMessage.Content.ReadAsStringAsync();
        if (!responseMessage.IsSuccessStatusCode)
        {
            throw new Exception(content);
        }

        HostDTO result = JsonSerializer.Deserialize<HostDTO>(content, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;
        
        return result;
    }
}