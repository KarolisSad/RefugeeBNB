using Shared.DTOs;

namespace HttpClients.ClientImplementations;

public interface HousingInterface
{
    Task<HousingDTO> AddHousingAsync(HousingCreationDTO dto);
    Task<HousingListDTO> 
}
