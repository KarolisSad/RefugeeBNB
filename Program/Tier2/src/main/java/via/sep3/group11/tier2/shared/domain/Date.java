package via.sep3.group11.tier2.shared.domain;

import lombok.Data;
import via.sep3.group11.tier2.shared.exceptions.ValidationException;

/**
 * Class representing a specific date.
 * @version 27/11-2022
 * @author Group 11
 */
@Data
public class Date {
    private int day;
    private int month;
    private int year;

    /**
     * All-argument constructor used to create an instance of the Date object.
     * Each parameter is assigned, and the ValidateDate method is then called to validate the information.
     * @param day: The integer representation of the day of the month.
     * @param month: The integer representation of the month number.
     * @param year: The integer representation of the year.
     * @throws ValidationException if the ValidateDate-method throws an exception.
     */
    public Date(int day, int month, int year) {

        this.day = day;
        this.month = month;
        this.year = year;
    }

    /**
     * Getter-method for getting the day variable.
     * @return the day variable.
     */
    public int getDay() {
        return day;
    }

    /**
     * Getter-method for getting the month variable.
     * @return the month variable.
     */
    public int getMonth() {
        return month;
    }

    /**
     * Getter-method for getting the year variable.
     * @return the year variable.
     */
    public int getYear() {
        return year;
    }

    /**
     * Private method called from the contructor.
     * Used to validate the date given as arguments.
     * @param day: The integer representation of the day of the month.
     * @param month: The integer representation of the month number.
     * @param year: The integer representation of the year.
     * @throws ValidationException either if the year given as argument is before 1900 (to prevent data redundancy),
     * or if the ValidateMonthAndDay throws an exception.
     */
    private void validateDate(int day, int month, int year) throws ValidationException {
        if (1900 > year) {
            throw new ValidationException("Year should not be before 1900.");
        }
        validateMonthAndDay(day, month, year);
    }

    /**
     * Private method called from the ValidateDate-method.
     * Used to validate the date (day and month) taking into account number of days in the month and leap-years.
     * @param day: The integer representation of the day of the month.
     * @param month: The integer representation of the month number.
     * @param year: The integer representation of the year.
     * @throws ValidationException
     *      - If the month given corresponds to either January, March, May, July, August, October or December
     *      and the day is not between 1 and 31.
     *      - If the month given corresponds to either April, June, September or November
     *      and the day is not between 1 and 30.
     *      - If the month given corresponds to February, the year corresponds to a leap year
     *      and the day is not between 1 and 29.
     *      - If the month given corresponds to February, the year corresponds to a non-leap year
     *      and the day is not between 1 and 28.
     *      - If the month given does not correspond to an actual month.
     */
    private void validateMonthAndDay(int day, int month, int year) throws ValidationException {
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
