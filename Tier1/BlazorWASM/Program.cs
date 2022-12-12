using Microsoft.AspNetCore.Components.Web;
using Microsoft.AspNetCore.Components.WebAssembly.Hosting;
using BlazorWASM;
using BlazorWASM.Auth;
using HttpClients;
using HttpClients.ClientImplementations;
using HttpClients.ClientInterfaces;
using LogicForPages;
using Microsoft.AspNetCore.Components.Authorization;
using Radzen;
using Radzen.Blazor;
using Shared.Authentication;

var builder = WebAssemblyHostBuilder.CreateDefault(args);

builder.RootComponents.Add<App>("#app");
builder.RootComponents.Add<HeadOutlet>("head::after");

builder.Services.AddScoped<AuthenticationStateProvider, CustomAuthProvider>();
builder.Services.AddScoped<AuthInterface, JwtAuthImpl>();
builder.Services.AddScoped<HostInterface, HostImpl>();
builder.Services.AddScoped<RefugeeInterface, RefugeeImpl>();
builder.Services.AddScoped<HousingInterface, HousingImpl>();
builder.Services.AddScoped<AgreementInterface, AgreementImpl>();
builder.Services.AddSingleton<MenuService>();

AuthorizationPolicies.AddPolicies(builder.Services);
builder.Services.AddScoped(sp => new HttpClient { BaseAddress = new Uri("http://localhost:8081") });



//RADZEN stuff
builder.Services.AddScoped<DialogService>();
builder.Services.AddScoped<NotificationService>();
builder.Services.AddScoped<TooltipService>();
builder.Services.AddScoped<ContextMenuService>();



await builder.Build().RunAsync();