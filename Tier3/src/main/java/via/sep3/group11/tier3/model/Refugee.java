package via.sep3.group11.tier3.model;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;

import static via.sep3.group11.tier3.model.Date.convertDateObjectToLocalDate;
import static via.sep3.group11.tier3.model.Date.convertLocalDateToDateObject;

/**
 * A class responsible for creating an Address table.
 * Contains an entity annotation that persists to the database
 * and Data annotation in order to inject all the necessary constructors and methods
 *
 * @author Group 11
 * @version 28/11/22
 */
@Data
@Entity
@Table(name = "refugee")
public class Refugee {

    @Id
    private String email;

    @Column(name = "fName")
    private String firstName;

    @Column(name = "mName")
    private String middleName;

    @Column(name = "lName")
    private String lastName;

    @Column(name = "password")
    private String password;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "gender")
    private char gender;

    @Column(name = "dob")
    private LocalDate dateOfBirth;

    @Column(name = "familySize")
    private int familySize;

    @Column(name = "description")
    private String description;

    public Refugee() {}

    public Refugee(String email, String firstName, String middleName, String lastName, String password, String nationality, char gender, Date dateOfBirth, int familySize, String description) {
        this.email = email;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.password = password;
        this.nationality = nationality;
        this.gender = gender;
        this.dateOfBirth = convertDateObjectToLocalDate(dateOfBirth);
        this.familySize = familySize;
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getNationality() {
        return nationality;
    }

    public char getGender() {
        return gender;
    }

    public Date getDateOfBirth() {
        return convertLocalDateToDateObject(dateOfBirth);
    }

    public int getFamilySize() {
        return familySize;
    }

    public String getDescription() {
        return description;
    }
}
