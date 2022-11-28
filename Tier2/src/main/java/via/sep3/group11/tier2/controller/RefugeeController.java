package via.sep3.group11.tier2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    RefugeeDao refugeeDAO;

    /**
     * Creates a refugee !!
     * @param refugee
     * @return
     */
    @PostMapping(value ="/refugee",produces ={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Refugee> createRefugee(@RequestBody Refugee refugee){

        try{
            Refugee created = refugeeDAO.save(new Refugee(refugee.createRefugee();
            return new ResponseEntity<>(created,HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Gets refugee by email!!
     * @param email
     * @return
     */
    @GetMapping("/refugee/{email}")
    public ResponseEntity<Optional<Refugee>> getRefugeeByEmail(@PathVariable("email")long email) {
        try{
            List<Refugee> refugee = refugeeDAO.findByEmail(email);

            if (refugee.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(animal, HttpStatus.OK);
            } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
