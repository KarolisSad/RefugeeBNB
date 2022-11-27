package via.sep3.group11.tier2.shared.domain;

import via.sep3.group11.tier2.shared.exceptions.ValidationException;

import java.util.Optional;

import static via.sep3.group11.tier2.shared.domain.ValidationHelper.*;

public class Refugee {
    private String email;
    private String password;
    private char gender;
    private String nationality;
    private String firstName;
    private String middleName;
    private String lastName;
    private Date dateOfBirth;

    public Refugee(String email, String password, char gender, String nationality, String firstName, Optional<String> middleName, String lastName, Date dateOfBirth) throws ValidationException {
        setFirstName(firstName);
        setMiddleName(middleName);
        setLastName(lastName);
        setEmail(email);
        setPassword(password);
        setGender(gender);
        setNationality(nationality);
        setDateOfBirth(dateOfBirth);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws ValidationException {
        ValidateEmail(email);
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws ValidationException {
        ValidatePassword(password);
        this.password = password;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) throws ValidationException {
        this.gender = ValidateGender(gender);
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) throws ValidationException {
        ValidateNationality(nationality);
        this.nationality = nationality;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws ValidationException {
        ValidateFirstName(firstName);
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(Optional<String> middleName) throws ValidationException {
        this.middleName = ValidateMiddleName(middleName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws ValidationException {
        ValidateLastName(lastName);
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
