package via.sep3.group11.tier3.model;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;

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
    private java.sql.Date dateOfBirth;

    public Refugee() {}

    public Refugee(String email, String firstName, String middleName, String lastName, String password, String nationality, char gender, via.sep3.group11.tier3.model.Date dateOfBirth) {
        this.email = email;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.password = password;
        this.nationality = nationality;
        this.gender = gender;
        this.dateOfBirth = dateToSqlDate(dateOfBirth);
    }

    public java.sql.Date dateToSqlDate(via.sep3.group11.tier3.model.Date date){
        return new java.sql.Date(date.getYear(),date.getMonth(),date.getDay());
    }

    public via.sep3.group11.tier3.model.Date dateFromSqlDate(java.sql.Date date)
    {
        return new via.sep3.group11.tier3.model.Date(date.getDay(),date.getMonth(),date.getYear());
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
        return dateFromSqlDate(dateOfBirth);
    }
}
