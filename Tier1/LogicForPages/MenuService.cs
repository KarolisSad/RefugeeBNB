namespace LogicForPages;

public class MenuService:IMenuService
{
    public List<MenuItem>? AdditionalMenuItems { get; set; }if


    public event Action? OnChanged;

    public MenuService()
    {
    }

    public void NotifyStateChanged() => OnChanged?.Invoke();
    
    public void AddMenuItems(List<MenuItem> newMenuItems)
    {
        AdditionalMenuItems?.AddRange(
                new List<MenuItem>());
        Console.WriteLine("Added: " + newMenuItems.First().Name);
        NotifyStateChanged();
    }

    public void DeleteMenuItem(MenuItem menuItem)
    {
        AdditionalMenuItems?.Remove(menuItem);
        Console.WriteLine("item deleted: " + menuItem.Name);
        NotifyStateChanged();
    }
    
}