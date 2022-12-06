using Shared.DTOs;

namespace HttpClients.ClientInterfaces;

public interface HousingInterface
{
    Task<HousingDTO> AddHousingAsync(HousingCreationDTO dto);
    Task<HousingListDTO> GetAvailableHousing();
    Task<HousingDTO> RemoveHousing(HousingIdDTO dto);
    Task<HousingListDTO> GetHousingByHostId(string ownerEmail);
}
