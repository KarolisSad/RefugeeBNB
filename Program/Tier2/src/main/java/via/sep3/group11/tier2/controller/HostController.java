package via.sep3.group11.tier2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import via.sep3.group11.tier2.logicInterfaces.HostInterface;
import via.sep3.group11.tier2.shared.DTOs.*;
import via.sep3.group11.tier2.shared.domain.Host;
import via.sep3.group11.tier2.shared.exceptions.NotUniqueException;
import via.sep3.group11.tier2.shared.exceptions.ValidationException;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class HostController {
    /**
     * Host controller
     *
     * @author Group 11
     * @version 28/11/22
     */

    HostInterface hostLogic;

    public HostController(HostInterface hostLogic) {
        this.hostLogic = hostLogic;
    }


    @GetMapping("/host/housing/{housingId}")
    public ResponseEntity<HostDTO> getHostByHousingId(@PathVariable ("housingId") long housingId) {
        try {
            HostDTO hostById = hostLogic.getHostByHousingId(housingId);
            return new ResponseEntity<>(hostById, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/host/delete/{email}")
    public ResponseEntity<HostDTO> deleteAccount(@PathVariable("email") String email) {
        try {
            HostDTO host = hostLogic.deleteAccount(email);
            return new ResponseEntity<>(host, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/host/update")
    public ResponseEntity<HostDTO> updateAccount(@RequestBody HostUpdateDTO dto) {
        try {
            HostDTO host = hostLogic.updateInformation(dto);
            return new ResponseEntity<>(host, HttpStatus.OK);
        }

        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    


@GetMapping("/host/{email}")
    public ResponseEntity<HostDTO> getHost(@PathVariable("email") String email){
        try {
            HostDTO host = hostLogic.getHostById(email);
            return new ResponseEntity<>(host, HttpStatus.OK);
        }

        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
