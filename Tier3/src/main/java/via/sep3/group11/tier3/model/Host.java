package via.sep3.group11.tier3.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
@Entity
@Table(name = "host")
public class Host {

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

    @OneToMany(mappedBy = "host")
    private List<Housing> housing;

//    @OneToOne
//    @JoinColumn(name = "address")
//    private Address address;

    public Host() {}

    public Host(String email, String firstName, String middleName, String lastName, String password, String nationality, char gender, via.sep3.group11.tier3.model.Date dateOfBirth) {
        this.email = email;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.password = password;
        this.nationality = nationality;
        this.gender = gender;
        this.dateOfBirth = convertDateObjectToLocalDate(dateOfBirth);
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

    public List<Housing> getHousing() {
        return housing;
    }

    public Date getDateOfBirth() {
        return convertLocalDateToDateObject(dateOfBirth);
    }
}
