package via.sep3.group11.tier2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import via.sep3.group11.tier2.logicInterfaces.AgreementInterface;
import via.sep3.group11.tier2.shared.DTOs.AgreementDTO;
import via.sep3.group11.tier2.shared.DTOs.AgreementsByHostDTO;
import via.sep3.group11.tier2.shared.DTOs.RequestAgreementDTO;
import via.sep3.group11.tier2.shared.DTOs.RespondAgreementDTO;
import via.sep3.group11.tier2.shared.domain.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api")
public class AgreementController {

    AgreementInterface agreementInterface;

    public AgreementController(AgreementInterface agreementInterface) {
        this.agreementInterface = agreementInterface;
    }

    @PostMapping(value ="/agreements",produces ={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AgreementDTO> requestAgreement(@RequestBody RequestAgreementDTO dto){
        try {
           AgreementDTO created = agreementInterface.requestAgreement(dto);
           return new ResponseEntity<>(created, HttpStatus.CREATED);
        }
        catch (Exception e) {

            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }



        /*
        return new ResponseEntity<>(new AgreementDTO(
                new Agreement(
                        new Host("Christian Hougaard", "315269@via.dk",
                                "asdasd", 'O', "Danish", "",
                                "Pedersen", new Date(11, 11, 2011)),
                        new Housing(1, 2,
                                new Address(1L, "Denmark", "Horsens", "qewrjkldhkasd",
                                        "ljasfn", "1.02", "8700"), true),
                        new Refugee("refugee@test.dk", "1234", 'M',
                                "Lithuanian", "Refugee", "Mother", "Fucker",
                                new Date(11, 11, 2011))
                ), ""
        ), HttpStatus.CREATED);

         */


    }
    public ResponseEntity<AgreementDTO> respondToAgreement(@RequestBody RespondAgreementDTO dto){
        try{
            AgreementDTO respond = agreementInterface.respondToAgreement(dto);
            return new ResponseEntity<>(respond,HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity<List<Agreement>> getAllRequestByHost(@RequestBody AgreementsByHostDTO dto){
        try{
            List<Agreement> requests = agreementInterface.getAllRequestsByHost(dto);

            return new ResponseEntity<>(requests, HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
