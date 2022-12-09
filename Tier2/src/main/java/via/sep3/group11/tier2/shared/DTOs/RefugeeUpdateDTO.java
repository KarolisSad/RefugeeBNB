package via.sep3.group11.tier2.shared.DTOs;

public class RefugeeUpdateDTO {
    private String email;
    private String password;
    private char gender;
    private String nationality;
    private String firstName;
    private String middleName;
    private String lastName;
    private int familySize;
    private String description;

    public RefugeeUpdateDTO(String email, String password, char gender, String nationality, String firstName, String middleName, String lastName, int familySize, String description) {
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.nationality = nationality;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.familySize = familySize;
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public char getGender() {
        return gender;
    }

    public String getNationality() {
        return nationality;
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

    public int getFamilySize() {
        return familySize;
    }

    public String getDescription() {
        return description;
    }
}
