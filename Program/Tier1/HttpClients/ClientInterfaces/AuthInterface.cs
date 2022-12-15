using System.Security.Claims;
using Shared.DTOs;

namespace HttpClients.ClientInterfaces;

public interface AuthInterface
{
    public Task<AuthResponseDTO> LoginAsync(LoginDTO dto);
    public Task LogoutAsync();
    public Task<HostDTO> RegisterHostAsync(HostRegisterDTO dto);
    public Task<RefugeeDTO> RegisterRefugeeAsync(RefugeeRegisterDTO dto);
    public Task<ClaimsPrincipal> GetAuthAsync();
    public string GetEmail();

    public Action<ClaimsPrincipal> OnAuthStateChanged { get; set; }
}