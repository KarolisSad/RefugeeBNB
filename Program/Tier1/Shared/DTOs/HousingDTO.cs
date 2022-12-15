using Shared.Domain;

namespace Shared.DTOs;

public class HousingDTO
{
    public Housing Housing{ get; }
    public string ErrorMessage{ get; }

    public HousingDTO(Housing housing, string errorMessage)
    {
        Housing = housing;
        ErrorMessage = errorMessage;
    }
}