package via.sep3.group11.tier2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import via.sep3.group11.tier2.logicInterfaces.HostInterface;
import via.sep3.group11.tier2.shared.DTOs.HousingCreationDTO;
import via.sep3.group11.tier2.shared.domain.Housing;
import via.sep3.group11.tier2.shared.exceptions.ValidationException;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class HousingController {
    /**
     *
     *  Housing controller
     * @author Group 11
     * @version 28/11/22
     */
    HostInterface hostInterface;

    public HousingController(HostInterface hostInterface)
    {
        this.hostInterface = hostInterface;
    }

    /**
     *  Adds housing !
     * @param housing
     * @return
     */
    @CrossOrigin
    @PostMapping(value ="/housing",produces ={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Housing> addHousing(@RequestBody HousingCreationDTO housing){

        try{
            Housing created = hostInterface.addHousing(housing);
            return new ResponseEntity<>(created, HttpStatus.CREATED);
        }
        catch (IllegalArgumentException | ValidationException e)
        {
            System.out.println(e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
