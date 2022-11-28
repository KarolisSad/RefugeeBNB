package via.sep3.group11.tier2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class HousingController {
    /**
     *
     *  Housing controller
     * @author Group 11
     * @version 28/11/22
     */
    @Autowired
    HousingDAO housingDAO;

    /**
     *  Adds housing !
     * @param housing
     * @return
     */
    @PostMapping(value ="/housing",produces ={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Housing> addHousing(@RequestBody Housing housing){

        try{
            Housing created = housingDAO.save(new Housing(housing.addHousing);
            return new ResponseEntity<>(created, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
