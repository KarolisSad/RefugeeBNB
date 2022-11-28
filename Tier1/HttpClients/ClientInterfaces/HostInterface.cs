using Shared.Domain;

namespace HttpClients.ClientInterfaces;

public interface HostInterface
{
    Task RegisterHostAsync(Host host);
    Task<Host> LoginHostAsync(string username, string password);
    Task<Host> AddHousingAsync(Housing housing, string email);
}