package via.sep3.group11.tier2.shared.DTOs;

import via.sep3.group11.tier2.shared.domain.Date;

/**
 * Domain Transfer Object used to register Refugees in the system.
 * @version 27/11-2022
 * @author Group 11
 */
public class RefugeeRegisterDTO {

    private String email;
    private String password;
    private char gender;
    private String nationality;
    private String firstName;
    private String middleName;
    private String lastName;
    private Date dateOfBirth;
    private int familySize;
    private String description;
    private String errorMessage;
    /**
     * All-argument constructor used to create an instance of the DTO with all variables set.
     *
     * @param email: Represents the email of the Refugee.
     * @param password: Represents the password of the Refugee.
     * @param gender: Represents the gender of the Refugee.
     * @param nationality: Represents the nationality of the Refugee.
     * @param firstName: Represents the first name of the Refugee.
     * @param middleName: Represents the middle name of the Refugee.
     * @param lastName: Represents the last name of the Refugee.
     * @param dateOfBirth: Represents the date of birth of the Refugee.
     */
    public RefugeeRegisterDTO(String email, String password, char gender, String nationality, String firstName, String middleName, String lastName, Date dateOfBirth, int familySize, String description, String errorMessage) {
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.nationality = nationality;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.familySize = familySize;
        this.description = description;
        this.errorMessage = errorMessage;
    }

    /**
     * Simple getter method for email.
     * @return the email of the DTO.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Simple getter method for password.
     * @return the password of the DTO.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Simple getter method for gender.
     * @return the gender of the DTO.
     */
    public char getGender() {
        return gender;
    }

    /**
     * Simple getter method for nationality.
     * @return the nationality of the DTO.
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * Simple getter method for first name.
     * @return the first name of the DTO.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Simple getter method for middle name.
     * @return the middle name of the DTO.
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Simple getter method for last name.
     * @return the last name of the DTO.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Simple getter method for date.
     * @return the date of the DTO.
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public int getFamilySize() {
        return familySize;
    }

    public String getDescription() {
        return description;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
