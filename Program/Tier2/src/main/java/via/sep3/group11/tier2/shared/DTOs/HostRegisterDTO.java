package via.sep3.group11.tier2.shared.DTOs;

import via.sep3.group11.tier2.shared.domain.Date;

/**
 * Domain Transfer Object used to register Hosts in the system.
 * @version 27/11-2022
 * @author Group 11
 *
 */
public class HostRegisterDTO {
    private String email;
    private String password;
    private char gender;
    private String nationality;
    private String firstName;
    private String middleName;
    private String lastName;
    private Date dateOfBirth;
    private String errorMessage;

    /**
     * All-argument constructor used to create an instance of the DTO with all variables set.
     *
     * @param email: Represents the email of the Host.
     * @param password: Represents the password of the host.
     * @param gender: Represents the gender of the host.
     * @param nationality: Represents the nationality of the host.
     * @param firstName: Represents the first name of the host.
     * @param middleName: Represents the middle name of the host.
     * @param lastName: Represents the last name of the host.
     * @param dob: Represents the date of birth of the host.
     */
    public HostRegisterDTO(String email, String password, char gender, String nationality, String firstName, String middleName, String lastName, Date dob, String errorMessage) {
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.nationality = nationality;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dateOfBirth = dob;
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

    public String getErrorMessage() {
        return errorMessage;
    }
}
