using System.Security.Claims;
using Shared.DTOs;

namespace HttpClients.ClientInterfaces;

public interface AuthInterface
{
    //Task<string> RegisterHostAsync(HostRegisterDTO dto);
    //Task<string> RegisterRefugeeAsync(RefugeeRegisterDTO dto);
    //Task<AuthResponseDTO> LoginAsync(LoginDTO dto);

    public Task LoginAsync(LoginDTO dto);
    public Task LogoutAsync();
    public Task RegisterHostAsync(HostRegisterDTO dto);
    public Task RegisterRefugeeAsync(RefugeeRegisterDTO dto);
    public Task<ClaimsPrincipal> GetAuthAsync();
    
    public Action<ClaimsPrincipal> OnAuthStateChanged { get; set; }
}