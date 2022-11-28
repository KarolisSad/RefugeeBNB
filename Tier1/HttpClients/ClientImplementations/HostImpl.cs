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

    public async Task RegisterHostAsync(HostRegisterDTO host)
    {
        HttpResponseMessage responseMessage = await client.PostAsJsonAsync("/host", host);
        if (!responseMessage.IsSuccessStatusCode)
        {
            string content = await responseMessage.Content.ReadAsStringAsync();
            throw new Exception(content);
        }
    }

    public async Task<Host> LoginHostAsync(LoginDTO dto)
    {
        HttpResponseMessage responseMessage = await client.PostAsJsonAsync("/host/login", dto);
        
        string content = await responseMessage.Content.ReadAsStringAsync();
        if (!responseMessage.IsSuccessStatusCode)
        {
            throw new Exception(content);
        }

        Host host = JsonSerializer.Deserialize<Host>(content, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;
        
        return host;
    }

    public async Task<Housing> AddHousingAsync(HousingCreationDTO housing)
    {
        //We create housing in Database
        HttpResponseMessage created = await client.PostAsJsonAsync("/housing", housing);
        string result = await created.Content.ReadAsStringAsync();
        
        if (!created.IsSuccessStatusCode)
        {
            throw new Exception(result);
        }
        
        Housing housingCreated = JsonSerializer.Deserialize<Housing>(result, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;

        return housingCreated;
    }

    /**
    public async Task<Host> getHostAsync(string email)
    {
        HttpResponseMessage responseMessage = await client.GetAsync($"/host/{email}");
        string content = await responseMessage.Content.ReadAsStringAsync();
        if (!responseMessage.IsSuccessStatusCode)
        {
            throw new Exception(content);
        }

        Host host = JsonSerializer.Deserialize<Host>(content, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;
        
        return host;
    }
*/

}