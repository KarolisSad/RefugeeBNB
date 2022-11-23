package via.sep3.group11.tier2.shared.domain;

import via.sep3.group11.tier2.shared.exceptions.ValidationException;

public class Date {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) throws ValidationException {

        this.day = day;
        this.month = month;
        this.year = year;
        ValidateDate(day, month, year);
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
    
    private void ValidateDate(int day, int month, int year) throws ValidationException {
        if (1900 > year) {
            throw new ValidationException("Year should not be before 1900.");
        }
        ValidateMonthAndDay(day, month, year);
    }

    private void ValidateMonthAndDay(int day, int month, int year) throws ValidationException {
        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> {
                if (!(day > 0 && day <= 31 )) {
                    throw new ValidationException("Date incorrect.");
                }
            }

            case 4, 6, 9, 11 -> {
                if (!(day > 0 && day <= 30 )) {
                    throw new ValidationException("Date incorrect.");
                }
            }

            case 2 -> {
                if (year%4 == 0 || year%100 == 0 && year%400 == 0 ) {
                    if (!(day > 0 && day <= 29)) {
                        throw new ValidationException(year + " is a leap year, so February has 29 days.");
                    }
                }

                else {
                    if (!(day > 0 && day <= 28)) {
                        throw new ValidationException(year + " is not a leap year, so February has 28 days.");
                    }
                }
            }

            default -> throw new ValidationException("A year has 12 months.");
        }
    }
}
