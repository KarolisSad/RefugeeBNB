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

    public async Task<HostDTO> RegisterHostAsync(HostRegisterDTO host)
    {
        HttpResponseMessage responseMessage = await client.PostAsJsonAsync("/api/host", host);
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

    public async Task<HostDTO> LoginHostAsync(LoginDTO dto)
    {
        HttpResponseMessage responseMessage = await client.PostAsJsonAsync("/api/host/login", dto);
        
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

    public async Task<HousingDTO> AddHousingAsync(HousingCreationDTO housing)
    {
        //We create housing in Database
        HttpResponseMessage created = await client.PostAsJsonAsync("/api/housing", housing);
        string result = await created.Content.ReadAsStringAsync();
        
        if (!created.IsSuccessStatusCode)
        {
            throw new Exception(result);
        }
        
        HousingDTO housingCreated = JsonSerializer.Deserialize<HousingDTO>(result, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;

        return housingCreated;
    }

}