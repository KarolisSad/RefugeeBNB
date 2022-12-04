using Microsoft.AspNetCore.Components.Web;
using Microsoft.AspNetCore.Components.WebAssembly.Hosting;
using BlazorWASM;
using HttpClients.ClientImplementations;
using HttpClients.ClientInterfaces;
using LogicForPages;
using Radzen;
using Radzen.Blazor;

var builder = WebAssemblyHostBuilder.CreateDefault(args);

builder.RootComponents.Add<App>("#app");
builder.RootComponents.Add<HeadOutlet>("head::after");

builder.Services.AddScoped(sp => new HttpClient { BaseAddress = new Uri("http://localhost:8081") });
builder.Services.AddScoped<HostInterface, HostImpl>();
builder.Services.AddScoped<RefugeeInterface, RefugeeImpl>();
builder.Services.AddScoped<HousingInterface, HousingImpl>();
builder.Services.AddScoped<AgreementInterface, AgreementImpl>();
builder.Services.AddScoped<IMenuService, MenuService>();

//RADZEN stuff
builder.Services.AddScoped<DialogService>();
builder.Services.AddScoped<NotificationService>();
builder.Services.AddScoped<TooltipService>();
builder.Services.AddScoped<ContextMenuService>();



await builder.Build().RunAsync();