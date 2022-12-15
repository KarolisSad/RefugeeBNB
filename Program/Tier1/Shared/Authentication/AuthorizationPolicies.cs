using Microsoft.Extensions.DependencyInjection;

namespace Shared.Authentication;

public static class AuthorizationPolicies
{
    public static void AddPolicies(IServiceCollection services)
    {
        services.AddAuthorizationCore(options =>
        {
            options.AddPolicy("MustBeHost", a => a.RequireAuthenticatedUser().RequireClaim("Role", "HOST"));
            options.AddPolicy("MustBeRefugee", a => a.RequireAuthenticatedUser().RequireClaim("Role", "REFUGEE"));
        });
    }
}