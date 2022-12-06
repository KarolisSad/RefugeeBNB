using Shared.Domain;

namespace LogicForPages;

public class MenuService
{
    private bool _refugee;
    private string _refugeeLogged;
    public bool Refugee
    {
        get
        {
            return _refugee;
        }
        set
        {
            _refugee = value;
            NotifyDataChanged();
        }
    }

    public string RefugeeLogged
    {
        get
        {
            return _refugeeLogged;
        }
        set
        {
            _refugeeLogged = value;
        }
    }


    private bool _host;
    private string _hostLogged;
    public bool Host
    {
        get
        {
            return _host;
        }
        set
        {
            _host = value;
            NotifyDataChanged();
        }
    }

    public string HostLogged
    {
        get
        {
            return _hostLogged;
        }
        set
        {
            _hostLogged = value;
        }
    }

    public event Action OnChange;

    private void NotifyDataChanged() => OnChange?.Invoke();

}