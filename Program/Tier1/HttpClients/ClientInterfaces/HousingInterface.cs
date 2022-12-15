using Shared.DTOs;

namespace HttpClients.ClientInterfaces;

public interface HousingInterface
{
    Task<HousingDTO> AddHousingAsync(HousingCreationDTO dto);
    Task<HousingListDTO> GetAvailableHousingAsync();
    Task<HousingDTO> RemoveHousingAsync(HousingIdDTO dto);
    Task<HousingListDTO> GetHousingByHostIdAsync(string ownerEmail);
}
