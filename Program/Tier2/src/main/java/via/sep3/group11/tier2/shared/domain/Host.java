package via.sep3.group11.tier2.shared.domain;

import via.sep3.group11.tier2.shared.DTOs.LoginDTO;
import via.sep3.group11.tier2.shared.exceptions.ValidationException;

import java.util.List;
import java.util.Optional;

import static via.sep3.group11.tier2.shared.domain.ValidationHelper.*;

/**
 * Class representing a Host.
 * @version 27/11-2022
 * @author Group 11
 */
public class Host {
    private String firstName;
    private String email;
    private String password;
    private char gender;
    private String nationality;
    private String middleName;
    private String lastName;
    private Date dateOfBirth;

    private List<Housing> housingList;


    public Host(String firstName, String email, String password, char gender,
                String nationality,String middleName, String lastName, Date dateOfBirth) {
        this.firstName = firstName;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.nationality = nationality;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.middleName = middleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public char getGender() {
        return gender;
    }

    public String getNationality() {
        return nationality;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Host{" +
                "firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                ", nationality='" + nationality + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", housingList=" + housingList +
                '}';
    }
    //                          GRAVE OF GREAT CODE :(


//    /**
//     * All-argument constructor used to create an instance of the object.
//     * All arguments are initialized by calling their corresponding set-method.
//     * @param firstName: The first name of the host to be created.
//     * @param email: The email of the host to be created.
//     * @param password: The password of the host to be created.
//     * @param gender: The gender of the host to be created.
//     * @param nationality: The nationality of the host to be created.
//     * @param middleName: Optional field representing the middle name of the host to be created.
//     * @param lastName: The last name of the host to be created.
//     * @param dateOfBirth: The date of birth of the host to be created.
//     * @throws ValidationException if any of the set-methods throws exceptions.
//     */
//    public Host(String firstName, String email, String password, char gender, String nationality, Optional<String> middleName, String lastName, Date dateOfBirth) throws ValidationException {
//        setFirstName(firstName);
//        setMiddleName(middleName);
//        setLastName(lastName);
//        setEmail(email);
//        setPassword(password);
//        setGender(gender);
//
//        setNationality(nationality);
//        setDateOfBirth(dateOfBirth);
//    }
//
//
//    /**
//     * Zero-argument constructor used to create an empty instance of a Host-object.
//     */
//    public Host() {
//    }
//
//    /**
//     * Getter-method for the first name of the Host.
//     * @return the first name of the host.
//     */
//    public String getFirstName() {
//        return firstName;
//    }
//
//    /**
//     * Method used for setting the first name of the host.
//     * The parameter is validated by calling the static method ValidateFirstName.
//     * @param firstName: The first name to be set.
//     * @throws ValidationException if validation throws an exception.
//     */
//    public void setFirstName(String firstName) throws ValidationException {
//        validateFirstName(firstName);
//        this.firstName = firstName;
//    }
//
//    /**
//     * Getter-method for the email of the Host.
//     * @return the email of the host.
//     */
//    public String getEmail() {
//        return email;
//    }
//
//    /**
//     * Method used for setting the email of the host.
//     * The parameter is validated by calling the static method ValidateEmail.
//     * @param email: The email to be set.
//     * @throws ValidationException if validation throws an exception.
//     */
//    public void setEmail(String email) throws ValidationException {
//        validateEmail(email);
//        this.email = email;
//    }
//
//    /**
//     * Getter-method for the password of the Host.
//     * @return the password of the host.
//     */
//    public String getPassword() {
//        return password;
//    }
//
//    /**
//     * Method used for setting the password of the host.
//     * The parameter is validated by calling the static method ValidatePassword.
//     * @param password: The password to be set.
//     * @throws ValidationException if validation throws an exception.
//     */
//    public void setPassword(String password) throws ValidationException {
//        validatePassword(password);
//        this.password = password;
//    }
//
//    /**
//     * Getter-method for the gender of the Host.
//     * @return the gender of the host.
//     */
//    public char getGender() {
//        return gender;
//    }
//
//    /**
//     * Method used for setting the gender of the host.
//     * The parameter is validated by calling the static method ValidateGender.
//     * @param gender: The gender to be set.
//     * @throws ValidationException if validation throws an exception.
//     */
//    public void setGender(char gender) throws ValidationException {
//        this.gender = validateGender(gender);
//    }
//
//    /**
//     * Getter-method for the nationality of the Host.
//     * @return the nationality of the host.
//     */
//    public String getNationality() {
//        return nationality;
//    }
//
//    /**
//     * Method used for setting the nationality of the host.
//     * The parameter is validated by calling the static method ValidateNationality.
//     * @param nationality: The nationality to be set.
//     * @throws ValidationException if validation throws an exception.
//     */
//    public void setNationality(String nationality) throws ValidationException {
//        validateNationality(nationality);
//        this.nationality = nationality;
//    }
//
//    /**
//     * Getter-method for the middle name of the Host.
//     * @return the middle name of the host.
//     */
//    public String getMiddleName() {
//        return middleName;
//    }
//
//    public void setMiddleName(Optional<String> middleName) throws ValidationException {
//        this.middleName = validateMiddleName(middleName);
//    }
//
//    /**
//     * Method used for setting the middle name of the host.
//     * The parameter is validated by calling the static method ValidateMiddleName.
//     * @param middleName: The middle name to be set.
//     * @throws ValidationException if validation throws an exception.
//     */
//    public void setMiddleName(Optional<String> middleName) throws ValidationException {
//        this.middleName = validateMiddleName(middleName);
//    }
//
//
//    /**
//     * Getter-method for the last name of the Host.
//     * @return the last name of the host.
//     */
//    public String getLastName() {
//        return lastName;
//    }
//
//    /**
//     * Method used for setting the last name of the host.
//     * The parameter is validated by calling the static method ValidateLastName.
//     * @param lastName: The last name to be set.
//     * @throws ValidationException if validation throws an exception.
//     */
//    public void setLastName(String lastName) throws ValidationException {
//        validateLastName(lastName);
//        this.lastName = lastName;
//    }
//
//
//    /**
//     * Getter-method for the date of birth of the Host.
//     * @return the date of birth of the host.
//     */
//    public Date getDateOfBirth() {
//        return dateOfBirth;
//    }
//
//    /**
//     * Method used for setting the date of birth of the host.
//     * @param dateOfBirth: The date of birth to be set to be set.
//     * @throws ValidationException if parameter is null.
//     */
//    public void setDateOfBirth(Date dateOfBirth) throws ValidationException {
//        if (dateOfBirth == null) {
//            throw new ValidationException("Date of birth should not be null.");
//        }
//        this.dateOfBirth = dateOfBirth;
//    }

}
