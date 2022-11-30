using System.Runtime.CompilerServices;
using Shared.Domain;

namespace Shared.DTOs;

public class HousingListDTO
{
    public List<Housing> HousingList;
    public string ErrorMessage;

    public HousingListDTO(List<Housing> housingList, string errorMessage)
    {
        HousingList = housingList;
        ErrorMessage = errorMessage;
    }
}