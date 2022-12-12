using System.Net.Http.Headers;
using System.Net.Http.Json;
using System.Text.Json;
using HttpClients.ClientInterfaces;
using Shared.DTOs;

namespace HttpClients.ClientImplementations;

public class HousingImpl:HousingInterface
{
    private readonly HttpClient client;

    public HousingImpl(HttpClient client)
    {
        this.client = client;
    }

    public async Task<HousingDTO> AddHousingAsync(HousingCreationDTO dto)
    {
        client.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue("Bearer", JwtAuthImpl.Jwt);
        //We create housing in Database
        HttpResponseMessage created = await client.PostAsJsonAsync("/api/housing", dto);
        string result = await created.Content.ReadAsStringAsync();
        
        if (!created.IsSuccessStatusCode)
        {
            throw new Exception(result);
        }
        
        HousingDTO housingCreated = JsonSerializer.Deserialize<HousingDTO>(result, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;

        if (!string.IsNullOrWhiteSpace(housingCreated.ErrorMessage))
        {
            throw new Exception(housingCreated.ErrorMessage);
        }

        return housingCreated;
    }
    

    public async Task<HousingListDTO> GetAvailableHousingAsync()
    {
        client.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue("Bearer", JwtAuthImpl.Jwt);
        HttpResponseMessage message = await client.GetAsync("/api/housing");
        string result = await message.Content.ReadAsStringAsync();
        
        if (!message.IsSuccessStatusCode)
        {
            throw new Exception(result);
        }
        
        HousingListDTO housingCreated = JsonSerializer.Deserialize<HousingListDTO>(result, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;

        return housingCreated;
    }

    public async Task<HousingDTO> RemoveHousingAsync(HousingIdDTO dto)
    {
        client.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue("Bearer", JwtAuthImpl.Jwt);
        HttpResponseMessage created = await client.PostAsJsonAsync("/api/housing/delete", dto);
        string result = await created.Content.ReadAsStringAsync();
        
        if (!created.IsSuccessStatusCode)
        {
            throw new Exception(result);
        }
        
        HousingDTO housingDeleted = JsonSerializer.Deserialize<HousingDTO>(result, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;

        return housingDeleted;
    }

    public async Task<HousingListDTO> GetHousingByHostIdAsync(string ownerEmail)
    {
        client.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue("Bearer", JwtAuthImpl.Jwt);
        HttpResponseMessage created = await client.GetAsync($"/api/housing/{ownerEmail}");
        string result = await created.Content.ReadAsStringAsync();
        
        if (!created.IsSuccessStatusCode)
        {
            throw new Exception(result);
        }
        
        HousingListDTO housings = JsonSerializer.Deserialize<HousingListDTO>(result, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;

        if (!string.IsNullOrEmpty(housings.ErrorMessage))
        {
            throw new Exception(housings.ErrorMessage);
        }

        return housings;
    }
}