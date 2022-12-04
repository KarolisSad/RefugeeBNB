using System.Runtime.Versioning;

namespace LogicForPages;

public interface IMenuService
{
    
    event Action OnChanged;
    public void NotifyStateChanged();
    void setRefugee();

    void setHost();

    bool isAnyoneLogged();

    bool isRefugeeLogged();
}