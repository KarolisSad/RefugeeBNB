using System.Collections.ObjectModel;
using System.Runtime.CompilerServices;
using Shared.Domain;

namespace Shared.DTOs;

public class HousingListDTO
{
    public Collection<Housing> HousingList;
    public string ErrorMessage;

    public HousingListDTO(Collection<Housing> housingList, string errorMessage)
    {
        HousingList = housingList;
        ErrorMessage = errorMessage;
    }
}