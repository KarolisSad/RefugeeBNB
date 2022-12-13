using System.Net.Http.Json;
using System.Text.Json;
using HttpClients.ClientInterfaces;
using Shared.Domain;
using Shared.DTOs;

namespace HttpClients.ClientImplementations;

public class AgreementImpl:AgreementInterface
{
    private HttpClient Client;

    public AgreementImpl(HttpClient client)
    {
        Client = client;
    }

    public async Task<RequestAgreementDTO> RequestAgreementAsync(RequestAgreementDTO dto)
    {
        Console.WriteLine(dto.HostEmail);
        HttpResponseMessage responseMessage = await Client.PostAsJsonAsync("/api/agreements", dto);
               
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
        Console.Write("hello");
        HttpResponseMessage responseMessage = await Client.PostAsJsonAsync("/api/agreements/respond", dto);
               
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
        Console.Write("HEY");
        HttpResponseMessage responseMessage = await Client.PostAsJsonAsync("/api/agreements/host", dto);
               
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
}