package via.sep3.group11.tier2.shared.domain;

import via.sep3.group11.tier2.shared.exceptions.ValidationException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class Host {
    private String firstName;
    private String email;
    private String password;
    private char gender;
    private String nationality;
    private String middleName;
    private String lastName;

    private Date dateOfBirth;
    private Collection<Housing> housings;

    public Host(String firstName, String email, String password, char gender, String nationality, Optional<String> middleName, String lastName, Date dateOfBirth, Collection<Housing> housings) throws ValidationException {
        setFirstName(firstName);
        setMiddleName(middleName);
        setLastName(lastName);
        setEmail(email);
        setPassword(password);
        setGender(gender);

        setNationality(nationality);
        setDateOfBirth(dateOfBirth);


        this.housings = new ArrayList<>();
    }

    // Not sure if needed - test!
    public Host() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws ValidationException {
        if (firstName == null || firstName.isBlank()) {
            throw new ValidationException("First name should not be empty.");
        }
        this.firstName = firstName;
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

        switch (Character.toUpperCase(gender)) {
            case 'M', 'O', 'F' -> this.gender = gender;
            default ->
                    throw new ValidationException("Gender should be one of the following: M(ale), F(emale) or O(ther).");
        }
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) throws ValidationException {

        if (nationality == null || nationality.isBlank()) {
            throw new ValidationException("Nationality should not be null or empty.");
        }
        this.nationality = nationality;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(Optional<String> middleName) throws ValidationException {
        if (middleName.isPresent()) {
            if (middleName.get().isBlank()) {
                throw new ValidationException("Middle name should not be empty if specified");
            }

            this.middleName = middleName.get();
        } else {
            this.middleName = "";
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws ValidationException {
        if (lastName == null || lastName.isBlank()) {
            throw new ValidationException("Last name should not be empty.");
        }

        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Collection<Housing> getHousings() {
        return housings;
    }

    public void setHousings(Collection<Housing> housings) throws ValidationException {
        if (housings == null) {
            throw new ValidationException("Can not set housing collection to null.");
        }
        this.housings = housings;
    }

    private void ValidateEmail(String email) throws ValidationException {
        if (email.isBlank()) {
            throw new ValidationException("Email should not be empty or null.");
        }

        if (!email.contains(".") || !email.contains("@")) {
            throw new ValidationException("Email: <" + email + "> is not in corrent format: xxxx@xxx.xx");
        }
    }

    private void ValidatePassword(String password) throws ValidationException {

        if (password == null || password.isBlank()) {
            throw new ValidationException("Password should not be null or empty");
        }
    }
}
