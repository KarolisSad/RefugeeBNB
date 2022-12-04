namespace LogicForPages;

public class MenuService : IMenuService
{
    public bool refugeeLogged { get; set; }
    public bool hostLogged { get; set; }

    public event Action? OnChanged;

    public void NotifyStateChanged() => OnChanged?.Invoke();

    public void setRefugee()
    {
        refugeeLogged = true;
        hostLogged = false;
        NotifyStateChanged();
    }

    public void setHost()
    {
        refugeeLogged = false;
        hostLogged = true;
        NotifyStateChanged();
        Console.WriteLine("host changes in MenuService: " + hostLogged);
    }

    public bool isRefugeeLogged()
    {
        Console.WriteLine(refugeeLogged);
        return refugeeLogged;
    }

    public bool isAnyoneLogged()
    {
        if (hostLogged || refugeeLogged)
        {
            return true;
        }

        return false;
    }

    public void logout()
    {
        refugeeLogged = false;
        hostLogged = false;
        NotifyStateChanged();
    }

}