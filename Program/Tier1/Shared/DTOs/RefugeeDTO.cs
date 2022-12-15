using Shared.Domain;

namespace Shared.DTOs;

public class RefugeeDTO
{
    public Refugee Refugee{ get; }
    public string ErrorMessage{ get; }

    public RefugeeDTO(Refugee refugee, string errorMessage)
    {
        Refugee = refugee;
        ErrorMessage = errorMessage;
    }
}