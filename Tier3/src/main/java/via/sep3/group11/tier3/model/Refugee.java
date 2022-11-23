package via.sep3.group11.tier3.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "refugee")
public class Refugee {

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

    @Column(name = "dob")
    private LocalDate dob;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "gender")
    private char gender;
}
