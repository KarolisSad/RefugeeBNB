using Shared.Domain;
using Shared.DTOs;

namespace HttpClients.ClientInterfaces;

public interface RefugeeInterface
{
   // Task<RefugeeDTO> RegisterRefugeeAsync(RefugeeRegisterDTO dto);
    //Task<RefugeeDTO> LoginRefugeeAsync(LoginDTO dto);
    Task<RefugeeDTO> DeleteAccountAsync(string email);
    Task<RefugeeDTO> UpdateInformation(RefugeeUpdateDTO dto);
    Task<RefugeeDTO> GetRefugee(string email);


}