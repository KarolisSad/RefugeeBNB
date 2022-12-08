package via.sep3.group11.tier2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import via.sep3.group11.tier2.logicInterfaces.AuthInterface;
import via.sep3.group11.tier2.shared.DTOs.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthInterface authInterface;

    @Autowired
    public AuthController(AuthInterface authInterface) {
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
            return new ResponseEntity<>(authInterface.registerRefugee(refugeeRegisterDTO), HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("register/host")
    public ResponseEntity<String> registerHost(@RequestBody NewHostRegisterDTO hostRegisterDTO) {
        try {
            if (authInterface.existsByEmail(hostRegisterDTO.getEmail())) {
                return new ResponseEntity<>(
                        "User with email: " + hostRegisterDTO.getEmail() + " already exists.",
                        HttpStatus.BAD_REQUEST);
            }

            return new ResponseEntity<>(authInterface.registerHost(hostRegisterDTO), HttpStatus.OK);
        }
        catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDTO loginDTO) {
        try {
            return new ResponseEntity<>(authInterface.login(loginDTO), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}
