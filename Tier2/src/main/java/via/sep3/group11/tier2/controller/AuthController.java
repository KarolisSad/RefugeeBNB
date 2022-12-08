package via.sep3.group11.tier2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import via.sep3.group11.tier2.logicInterfaces.AuthInterface;
import via.sep3.group11.tier2.logicInterfaces.RefugeeInterface;
import via.sep3.group11.tier2.shared.DTOs.NewRefugeeRegisterDTO;
import via.sep3.group11.tier2.shared.DTOs.RefugeeRegisterDTO;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthenticationManager authenticationManager;
    private AuthInterface authInterface;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager,
                          AuthInterface authInterface) {
        this.authenticationManager = authenticationManager;
        this.authInterface = authInterface;
    }

    @PostMapping("register/refugee")
    public ResponseEntity<String> registerRefugee(@RequestBody NewRefugeeRegisterDTO refugeeRegisterDTO) {
        try {
            if (authInterface.existsByEmail(refugeeRegisterDTO.getEmail())) {
                return new ResponseEntity<>(
                        "User with email: " + refugeeRegisterDTO.getEmail() + " already exists.",
                        HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(authInterface.newRegisterRefugee(refugeeRegisterDTO), HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
