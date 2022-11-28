package via.sep3.group11.tier2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import via.sep3.group11.tier2.logicInterfaces.RefugeeInterface;
import via.sep3.group11.tier2.shared.DTOs.LoginDTO;
import via.sep3.group11.tier2.shared.DTOs.RefugeeRegisterDTO;
import via.sep3.group11.tier2.shared.domain.Host;
import via.sep3.group11.tier2.shared.domain.Refugee;
import via.sep3.group11.tier2.shared.exceptions.NotUniqueException;
import via.sep3.group11.tier2.shared.exceptions.ValidationException;

import java.util.Optional;

@RestController
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

    /**
     * Creates a refugee !!
     * @param refugee
     * @return
     */
    @PostMapping(value ="/refugee",produces ={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Refugee> createRefugee(@RequestBody RefugeeRegisterDTO refugee){

        try{
            Refugee created = refugeeInterface.RegisterRefugee(refugee);
            return new ResponseEntity<>(created,HttpStatus.CREATED);
        }
        catch (NotUniqueException e)
        {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
        catch (ValidationException e)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Gets refugee by email!!
     * @param
     * @return
     */
    @GetMapping("/refugee/login")
    public ResponseEntity<Refugee> getRefugeeByEmail(@RequestBody LoginDTO loginDTO) {
        try {
            Refugee refugee = refugeeInterface.LoginRefugee(loginDTO);
            return new ResponseEntity<>(refugee, HttpStatus.OK);
        }
        catch (NullPointerException e)
        {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, e.getMessage());
        }
        catch (ValidationException e)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
