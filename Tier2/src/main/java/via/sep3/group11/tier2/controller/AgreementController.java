package via.sep3.group11.tier2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import via.sep3.group11.tier2.logicInterfaces.AgreementInterface;
import via.sep3.group11.tier2.shared.DTOs.AgreementDTO;
import via.sep3.group11.tier2.shared.DTOs.AgreementsByHostDTO;
import via.sep3.group11.tier2.shared.DTOs.RequestAgreementDTO;
import via.sep3.group11.tier2.shared.DTOs.RespondAgreementDTO;
import via.sep3.group11.tier2.shared.domain.Agreement;

import java.util.List;
@RestController
public class AgreementController {

    AgreementInterface agreementInterface;

    public AgreementController(AgreementInterface agreementInterface) {
        this.agreementInterface = agreementInterface;
    }

    public ResponseEntity<AgreementDTO> requestAgreement(@RequestBody RequestAgreementDTO dto){
    //
        try {
           AgreementDTO created = agreementInterface.requestAgreement(dto);
           return new ResponseEntity<>(created, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
