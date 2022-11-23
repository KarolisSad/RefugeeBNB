package via.sep3.group11.tier2.shared.domain;

import lombok.Data;

@Data
public class Refugee {
    private String email;
    private String password;
    private char gender;
    private String nationality;
    private String firstName;
    private String middleName;
    private String lastName;
    private Date dateOfBirth;

    // todo validation - maybe ditch lombok??
}
