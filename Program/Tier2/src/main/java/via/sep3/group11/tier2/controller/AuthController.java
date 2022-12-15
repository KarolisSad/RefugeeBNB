package via.sep3.group11.tier2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;
import via.sep3.group11.tier2.logicInterfaces.AuthInterface;
import via.sep3.group11.tier2.shared.DTOs.*;

@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class AuthController {

    private AuthInterface authInterface;

    @Autowired
    public AuthController(AuthInterface authInterface) {
        this.authInterface = authInterface;
    }

    @PostMapping("register/refugee")
    public ResponseEntity<RefugeeDTO> registerRefugee(@RequestBody NewRefugeeRegisterDTO refugeeRegisterDTO) {
        try {
            if (authInterface.existsByEmail(refugeeRegisterDTO.getEmail())) {
                return new ResponseEntity<>(new RefugeeDTO(null, "Email already in use."),
                        HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(authInterface.registerRefugee(refugeeRegisterDTO), HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(new RefugeeDTO(null, e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("register/host")
    public ResponseEntity<HostDTO> registerHost(@RequestBody NewHostRegisterDTO hostRegisterDTO) {
        try {
            if (authInterface.existsByEmail(hostRegisterDTO.getEmail())) {
                return new ResponseEntity<>(new HostDTO(null, "Email already in use."),
                        HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(authInterface.registerHost(hostRegisterDTO), HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(new HostDTO(null, e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDTO loginDTO) {
        try {
            AuthResponseDTO response = authInterface.login(loginDTO);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (BadCredentialsException be) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}
