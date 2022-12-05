namespace LogicForPages;

public class MenuService
{
    private bool _refugee;
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
    
    
    
    private bool _host;
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

    public event Action OnChange;

    private void NotifyDataChanged() => OnChange?.Invoke();

}