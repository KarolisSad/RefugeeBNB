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
@Table(name = "host")
public class Host {

    @Id
    private String email;

    @Column(name = "fName")
    private String fName;

    @Column(name = "mName")
    private String mName;

    @Column(name = "lName")
    private String lName;

    @Column(name = "password")
    private String password;

    //todo
    @Column(name = "dob")
    private Date dob;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "gender")
    private char gender;
}
