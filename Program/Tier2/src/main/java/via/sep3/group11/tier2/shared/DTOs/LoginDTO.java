package via.sep3.group11.tier2.shared.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Domain Transfer Object used to log in users in the system.
 * @version 27/11-2022
 * @author Group 11
 *
 */
@AllArgsConstructor
@Data
public class LoginDTO {

    private String email;
    private String password;

    // Added lombok instead of manually declaring stuff.
}
