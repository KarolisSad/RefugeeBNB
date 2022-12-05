package via.sep3.group11.tier2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import via.sep3.group11.tier2.logicInterfaces.HostInterface;
import via.sep3.group11.tier2.logicInterfaces.HousingInterface;
import via.sep3.group11.tier2.shared.DTOs.HousingCreationDTO;
import via.sep3.group11.tier2.shared.DTOs.HousingDTO;
import via.sep3.group11.tier2.shared.DTOs.HousingIdDTO;
import via.sep3.group11.tier2.shared.DTOs.HousingListDTO;
import via.sep3.group11.tier2.shared.domain.Address;
import via.sep3.group11.tier2.shared.domain.Housing;
import via.sep3.group11.tier2.shared.exceptions.ValidationException;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class HousingController {
    /**
     * Housing controller
     *
     * @author Group 11
     * @version 28/11/22
     */
    HostInterface hostInterface;
    HousingInterface housingInterface;

    public HousingController(HostInterface hostInterface, HousingInterface housingInterface) {
        this.hostInterface = hostInterface; //todo never used???
        this.housingInterface = housingInterface;
    }

    /**
     * Adds housing !
     *
     * @param housing
     * @return
     */
    @CrossOrigin
    @PostMapping(value = "/housing", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<HousingDTO> addHousing(@RequestBody HousingCreationDTO housing) {
        try {
            HousingDTO created = housingInterface.addHousing(housing);
            return new ResponseEntity<>(created, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }


        //return new ResponseEntity<>(new HousingDTO(new Housing(1,new Address("DummyData","DummyData","DummyData","DummyData","DummyData","DummyData"),false), ""), HttpStatus.CREATED);

    }

    @GetMapping("/housing")
    public ResponseEntity<HousingListDTO> getAvailableHousing() {
        try {
            HousingListDTO availableHousing = housingInterface.getAvailableHousing();
            System.out.println(availableHousing.getHousingList().get(0));
            return new ResponseEntity<>(availableHousing, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

   @DeleteMapping("/housing")
    public ResponseEntity<HousingDTO> removeHousing(@RequestBody HousingIdDTO dto) {
        try {
            HousingDTO remove = housingInterface.removeHousing(dto);
            return new ResponseEntity<>(remove, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
