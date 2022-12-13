using System.Net.Http.Headers;
using System.Net.Http.Json;
using System.Text.Json;
using HttpClients.ClientInterfaces;
using Shared.Domain;
using Shared.DTOs;

namespace HttpClients.ClientImplementations;

public class AgreementImpl:AgreementInterface
{
    private readonly HttpClient client;


    public AgreementImpl(HttpClient client)
    {
        this.client = client;
    }


    public async Task<RequestAgreementDTO> RequestAgreementAsync(RequestAgreementDTO dto)
    {
        client.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue("Bearer", JwtAuthImpl.Jwt);
        HttpResponseMessage responseMessage = await client.PostAsJsonAsync("/api/agreements", dto);
               
               string content = await responseMessage.Content.ReadAsStringAsync();
               if (!responseMessage.IsSuccessStatusCode)
               {
                   throw new Exception(content);
               }
       
               RequestAgreementDTO agreement = JsonSerializer.Deserialize<RequestAgreementDTO>(content, new JsonSerializerOptions
               {
                   PropertyNameCaseInsensitive = true
               })!;
               
               return agreement;
    }

    public async Task<RespondAgreementDTO> RespondToAgreementAsync(RespondAgreementDTO dto)
    {
        client.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue("Bearer", JwtAuthImpl.Jwt);
        HttpResponseMessage responseMessage = await client.PostAsJsonAsync("/api/agreements/respond", dto);
               
        string content = await responseMessage.Content.ReadAsStringAsync();
        if (!responseMessage.IsSuccessStatusCode)
        {
            throw new Exception(content);
        }
       
        RespondAgreementDTO agreement = JsonSerializer.Deserialize<RespondAgreementDTO>(content, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;
               
        return agreement;
    }

    public async Task<AgreementListDTO> GetAllRequestsByHostDTOAsync(AgreementsByHostDTO dto)
    {
        client.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue("Bearer", JwtAuthImpl.Jwt);
        HttpResponseMessage responseMessage = await client.PostAsJsonAsync("/api/agreements/host", dto);
               
        string content = await responseMessage.Content.ReadAsStringAsync();
        if (!responseMessage.IsSuccessStatusCode)
        {
            throw new Exception(content);
        }
       
        AgreementListDTO agreements = JsonSerializer.Deserialize<AgreementListDTO>(content, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;
               
        return agreements;
    }

    public async Task<AgreementDTO> GetAgreementByRefugeeEmail(string refugeeEmail)
    {
        client.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue("Bearer", JwtAuthImpl.Jwt);
        HttpResponseMessage responseMessage = await client.GetAsync($"/api/agreements/refugee/{refugeeEmail}");

        string content = await responseMessage.Content.ReadAsStringAsync();
        if (!responseMessage.IsSuccessStatusCode)
        {
            throw new Exception(content);
        }

        AgreementDTO dto = JsonSerializer.Deserialize<AgreementDTO>(content, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;

        if (!string.IsNullOrWhiteSpace(dto.ErrorMessage))
        {
            throw new Exception(dto.ErrorMessage);
        }

        return dto;
    }
}