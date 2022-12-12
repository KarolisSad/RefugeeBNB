using Shared.Domain;
using Shared.DTOs;

namespace HttpClients.ClientInterfaces;

public interface HostInterface
{
   // Task<HostDTO> RegisterHostAsync(HostRegisterDTO dto);
    //Task<HostDTO> LoginHostAsync(LoginDTO dto);

    Task<HostDTO> GetHostByHousingIdAsync(long housingId);
    
    Task<HostDTO> DeleteAccountAsync(string email);

    Task<HostDTO> UpdateInformation(HostUpdateDTO dto);

    Task<HostDTO> GetHost(string email);

}