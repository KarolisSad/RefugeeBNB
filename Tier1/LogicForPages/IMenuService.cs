using System.Runtime.Versioning;

namespace LogicForPages;

public interface IMenuService
{
    List<MenuItem> AdditionalMenuItems { get; set; }
    event Action OnChanged;
    public void NotifyStateChanged();
    void AddMenuItems(List<MenuItem> newMenuItems);
    void DeleteMenuItem(MenuItem menuItem);
}