using System.Collections.ObjectModel;
using System.Runtime.CompilerServices;
using Shared.Domain;

namespace Shared.DTOs;

public class HousingListDTO
{
    public List<Housing> HousingList { get; }
    public string ErrorMessage { get; }

    public HousingListDTO(List<Housing> housingList, string errorMessage)
    {
        HousingList = housingList;
        ErrorMessage = errorMessage;
    }
}