package via.sep3.group11.tier3.model;

import java.time.LocalDate;

/**
     * Class representing a specific date.
     * @version 27/11-2022
     * @author Group 11
     */
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

    public static LocalDate convertDateObjectToLocalDate(Date date) {
        return LocalDate.of(date.getYear(), date.getMonth(), date.getDay());
    }

    public static Date convertLocalDateToDateObject(LocalDate date) {
            return new Date(date.getDayOfMonth(), date.getMonthValue(), date.getYear());
    }

    @Override
    public String toString() {
        return "Date{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }
}
