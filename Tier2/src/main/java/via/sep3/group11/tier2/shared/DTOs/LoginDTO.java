package via.sep3.group11.tier2.shared.DTOs;

/**
 * Domain Transfer Object used to log in users in the system.
 * @version 27/11-2022
 * @author Group 11
 *
 */
public class LoginDTO {

    private String email;
    private String password;

    /**
     * All-argument constructor used to create an instance of the DTO with all variables set.
     * @param email: The email of the user to be logged in.
     * @param password: The password of the user to be logged in.
     */
    public LoginDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    /**
     * Simple getter method for email.
     * @return the email of the DTO.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Simple getter method for password.
     * @return the password of the DTO.
     */
    public String getPassword() {
        return password;
    }
}
