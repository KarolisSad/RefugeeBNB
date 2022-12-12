package via.sep3.group11.tier2.shared.DTOs;

import lombok.Data;
import via.sep3.group11.tier2.shared.domain.Date;

@Data
public class NewRefugeeRegisterDTO {
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
}
