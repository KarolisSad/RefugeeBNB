namespace LogicForPages;

public class MenuItem
{
    public string Link;
    public string Name;

    public MenuItem(string link, string name)
    {
        Link = link;
        Name = name;
    }

    public override string ToString()
    {
        return Name;
    }
}