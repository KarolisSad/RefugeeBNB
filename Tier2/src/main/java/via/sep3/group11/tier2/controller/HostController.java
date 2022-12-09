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
     *
     *  Host controller
     * @author Group 11
     * @version 28/11/22
     */

    HostInterface hostLogic;

    public HostController(HostInterface hostLogic)
    {
        this.hostLogic = hostLogic;
    }

    /**
     *  Creates a host!
     * @param host
     * @return
     */
    @CrossOrigin
    @PostMapping(value ="/host",produces ={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<HostDTO> createHost(@RequestBody HostRegisterDTO host) {

        try{
            HostDTO created = hostLogic.registerHost(host);
            return new ResponseEntity<>(created, HttpStatus.CREATED);
        }

        catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }



        //return new ResponseEntity<>(host, HttpStatus.CREATED);
     // return new ResponseEntity<HostDTO>(new HostDTO(new Host(host.getFirstName(), host.getEmail(), host.getPassword(), host.getGender(), host.getNationality(), host.getMiddleName(), host.getLastName(), host.getDateOfBirth()), ""), HttpStatus.CREATED);
        //return new ResponseEntity<>(new Host(host.getFirstName(), host.getEmail(), host.getPassword(), host.getGender(), host.getNationality(), host.getMiddleName(), host.getLastName(), host.getDateOfBirth()), HttpStatus.CREATED);
    }

    /**
     * Gets host by email!!!!
     * @param
     * @return
     */

    @PostMapping("/host/login")
    public ResponseEntity<HostDTO> loginHost(@RequestBody LoginDTO loginDTO) {
        try {
            HostDTO host = hostLogic.loginHost(loginDTO);
            return new ResponseEntity<>(host, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/host/{housingId}")
    public ResponseEntity<HostDTO> getHostByHousingId(@PathVariable ("housingId") long housingId) {
        try {
            HostDTO hostById = hostLogic.getHostByHousingId(housingId);
            return new ResponseEntity<>(hostById, HttpStatus.OK);
        }
         catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @DeleteMapping("/host/delete/{email}")
    public ResponseEntity<HostDTO> deleteAccount(@PathVariable("email") String email) {
        try {
            HostDTO host = hostLogic.deleteAccount(email);
            return new ResponseEntity<>(host, HttpStatus.OK);
        }

        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/host")
    public ResponseEntity<HostDTO> updateInformation(@RequestBody HostUpdateDTO hostUpdateDTO) {
        try {
            HostDTO host = hostLogic.updateInformation(hostUpdateDTO);
            return new ResponseEntity<>(host, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
