namespace Shared.Domain;


public class Date
{
    private int Day { get; set; }
    private int Month { get; set; }
    private int Year { get; set; }

    public Date(int day, int month, int year)
    {
        Day = day;
        Month = month;
        Year = year;
    }

    public Date()
    {
    }
}