package via.sep3.group11.tier2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import via.sep3.group11.tier2.logicInterfaces.HostInterface;
import via.sep3.group11.tier2.shared.DTOs.HostDTO;
import via.sep3.group11.tier2.shared.DTOs.HostRegisterDTO;
import via.sep3.group11.tier2.shared.DTOs.LoginDTO;
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
    @PostMapping(value ="/host",produces ={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Host> createHost(@RequestBody HostRegisterDTO host) {

        try{
            Host created = hostLogic.registerHost(host);
            return new ResponseEntity<>(created, HttpStatus.CREATED);
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
     * Gets host by email!!!!
     * @param
     * @return
     */

    @PostMapping("/host/login")
    public ResponseEntity<Host> loginHost(@RequestBody LoginDTO loginDTO) {
        try {
            Host host = hostLogic.loginHost(loginDTO);
            return new ResponseEntity<>(host, HttpStatus.OK);
        } catch (NullPointerException e) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, e.getMessage());
        } catch (ValidationException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/host/{housingId}")
        public ResponseEntity<HostDTO> getHostByHousingId(@PathVariable ("housingId") long housingId) {
        try {
            ResponseEntity<HostDTO> hostById = hostLogic.getHostByHousingId(housingId);
        } catch (NullPointerException e){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, e.getMessage());
        } catch (ValidationException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
             // IT SHOULD WORk? right?
    }
}
