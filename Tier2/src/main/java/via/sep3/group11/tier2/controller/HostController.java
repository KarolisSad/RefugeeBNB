package via.sep3.group11.tier2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class HostController {
    /**
     *
     *  Host controller
     * @author Group 11
     * @version 28/11/22
     */

    @Autowired hostDAO;

    /**
     *  Creates a host!
     * @param host
     * @return
     */
    @PostMapping(value ="/host",produces ={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Host> createHost(@RequestBody Host host){

        try{
            Host created = hostDAO.save(new Host(host.createHost);
            return new ResponseEntity<>(created, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Gets host by email!!!!
     * @param email
     * @return
     */
    @GetMapping("/host/{email}")
    public ResponseEntity<Optional<Host>> getHostByEmail(@PathVariable("email") long email){
        try {
            Optional<Host> host = hostDAO.findByEmail(email);

            if (animal.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(host, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
