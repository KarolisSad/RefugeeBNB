package via.sep3.group11.tier2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import via.sep3.group11.tier2.logicInterfaces.RefugeeInterface;
import via.sep3.group11.tier2.shared.DTOs.HostDTO;
import via.sep3.group11.tier2.shared.DTOs.LoginDTO;
import via.sep3.group11.tier2.shared.DTOs.RefugeeDTO;
import via.sep3.group11.tier2.shared.DTOs.RefugeeRegisterDTO;
import via.sep3.group11.tier2.shared.DTOs.RefugeeUpdateDTO;
import via.sep3.group11.tier2.shared.domain.Refugee;
import via.sep3.group11.tier2.shared.exceptions.NotUniqueException;
import via.sep3.group11.tier2.shared.exceptions.ValidationException;

import java.sql.Ref;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class RefugeeController {
    /**
     *
     * Refugee controller
     * @author 28/11/22
     * @version 28/11/22
     */

    RefugeeInterface refugeeInterface;

    public RefugeeController(RefugeeInterface refugeeInterface)
    {
        this.refugeeInterface = refugeeInterface;
    }

    /*
    /**
     * Creates a refugee !!
     * @param refugee
     * @return


    @PostMapping(value ="/refugee",produces ={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<RefugeeDTO> createRefugee(@RequestBody RefugeeRegisterDTO refugee){

        try{
            RefugeeDTO created = refugeeInterface.registerRefugee(refugee);

            return new ResponseEntity<>(created,HttpStatus.CREATED);
        }

        catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Gets refugee by email!!
     * @param
     * @return

    @CrossOrigin
    @PostMapping("/refugee/login")
    public ResponseEntity<RefugeeDTO> loginRefugee(@RequestBody LoginDTO loginDTO) {
        try {
            RefugeeDTO refugee = refugeeInterface.loginRefugee(loginDTO);
            return new ResponseEntity<>(refugee, HttpStatus.OK);
        }

        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    */



    @CrossOrigin
    @DeleteMapping("/refugee/delete/{email}")
    public ResponseEntity<RefugeeDTO> deleteAccount(@PathVariable("email") String email) {
        try {
            RefugeeDTO refugee = refugeeInterface.deleteAccount(email);
            return new ResponseEntity<>(refugee, HttpStatus.OK);
        }

        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/refugee/update")
    public ResponseEntity<RefugeeDTO> updateAccount(@RequestBody RefugeeUpdateDTO dto) {
        try {
            RefugeeDTO refugee = refugeeInterface.updateInformation(dto);
            return new ResponseEntity<>(refugee, HttpStatus.OK);
        }

        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/refugee/{email}")
    public ResponseEntity<RefugeeDTO> getRefugee(@PathVariable("email") String email){
        try {
            RefugeeDTO refugee = refugeeInterface.getRefugeeById(email);
            return new ResponseEntity<>(refugee, HttpStatus.OK);
        }

        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
