using Shared.Domain;

namespace Shared.DTOs;

public class HostDTO
{
    public Host Host { get; }
    public String ErrorMessage { get; }

    public HostDTO(Host host, string errorMessage)
    {
        this.Host = host;
        this.ErrorMessage = errorMessage;
    }
}