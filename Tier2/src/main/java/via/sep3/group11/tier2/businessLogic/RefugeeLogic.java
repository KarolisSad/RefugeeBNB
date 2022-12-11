package via.sep3.group11.tier2.businessLogic;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import via.sep3.group11.tier2.CommunicationInterfaces.AgreementCommunicationInterface;
import via.sep3.group11.tier2.CommunicationInterfaces.RefugeeCommunicationInterface;
import via.sep3.group11.tier2.logicInterfaces.RefugeeInterface;
import via.sep3.group11.tier2.shared.DTOs.*;
import via.sep3.group11.tier2.shared.domain.Agreement;
import via.sep3.group11.tier2.shared.domain.Date;
import via.sep3.group11.tier2.shared.domain.Host;
import via.sep3.group11.tier2.shared.domain.Refugee;
import via.sep3.group11.tier2.shared.exceptions.NotUniqueException;
import via.sep3.group11.tier2.shared.exceptions.ValidationException;

import java.util.Optional;

/**
 * Class implementing RefugeeInterface
 * Class is implented with @Service-annotation to mark it as a Spring-component.
 * @see via.sep3.group11.tier2.logicInterfaces.RefugeeInterface
 * @version 27/11-2022
 * @author Group 11
 */
@Service
public class RefugeeLogic implements RefugeeInterface {

    private RefugeeCommunicationInterface refugeeDAO;
    private AgreementCommunicationInterface agreementCommunicationInterface;
    private PasswordEncoder passwordEncoder;


    /**
     * Constructor used to inject the DAO needed for communicating with the data-tier.
     * @param refugeeDAO: Data Access Object used access Refugee information from the Data-tier.
     */
    public RefugeeLogic(RefugeeCommunicationInterface refugeeDAO, AgreementCommunicationInterface agreementCommunicationInterface, PasswordEncoder passwordEncoder) {
        this.refugeeDAO = refugeeDAO;
        this.agreementCommunicationInterface = agreementCommunicationInterface;
        this.passwordEncoder = passwordEncoder;

    }

    /**
     * Implementation of method used to create a new refugee in the data-tier.
     * This is implemented by creating an empty Refugee-object, and adding all information stored in the DTO to this, by using the set methods specified.
     * @see Refugee for documentation of set methods.
     * @param dto: a Domain Transfer Object containing all relevant attributes needed to create a new Refugee.
     * @return An object representation of the newly created Refugee-entry in the data-tier.
     * @throws NotUniqueException: If a refugee-entry with an identical email is already present in the data-tier.
     * @throws ValidationException: If any of the validation checks on the values ion the DTO fails.
     */
    @Override
    public RefugeeDTO registerRefugee(RefugeeRegisterDTO dto) {
        try {
            //TODO JUST FOR TESTING

            Refugee toRegister;
            if (dto.getDescription() == null) {
                toRegister = new Refugee(dto.getEmail(), dto.getPassword(), dto.getGender(), dto.getNationality(), dto.getFirstName(), dto.getMiddleName(), dto.getLastName(), dto.getDateOfBirth(), 1, "");
            }
            else {
                toRegister = new Refugee(dto.getEmail(), dto.getPassword(), dto.getGender(), dto.getNationality(), dto.getFirstName(), dto.getMiddleName(), dto.getLastName(), dto.getDateOfBirth(), dto.getFamilySize(), dto.getDescription());
            }
            // refugee check
            Optional<Refugee> existing = refugeeDAO.getRefugeeByEmail(toRegister.getEmail());
            // if no refugee found - create
            return existing.map
                            (refugee -> new RefugeeDTO(toRegister, "Host with email " + refugee.getEmail() + " already exists."))
                    .orElseGet(() -> new RefugeeDTO(refugeeDAO.createRefugee(toRegister), ""));
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;

    }

    /**
     * Implementation of method used to log in an already existing Refugee.
     * This is implemented by creating an empty Refugee-object, and adding the email and password information from the DTO to it.
     * A call is then made to the data-tier to find a refugee with the specified email.
     * If such a refugee is found, it is verified that the password given in the DTO matches the password stored.
     * @param dto: A domain transfer object containing the email and password of the refugee trying to log in.
     * @return An object representation of the logged in refugee gotten from the Data-tier.
     */
    @Override
    public RefugeeDTO loginRefugee(LoginDTO dto) {
        Refugee dummyRefugee = new Refugee("DummyRefugee@gmail.com","DummyRefugee",'O',"DummyRefugee","DummyRefugee","DummyRefugee","DummyRefugee",new Date(01,01,2021), -1, "");

        // refugee check
        Optional<Refugee> refugee = refugeeDAO.getRefugeeByEmail(dto.getEmail());
        if (refugee.isEmpty())
        {
            return new RefugeeDTO(dummyRefugee, "Refugee with email " + refugee.get().getEmail() + " doesn't exist.");
        }

        // username & password check
        if (dto.getPassword().equals(refugee.get().getPassword()))
        {
            return new RefugeeDTO(refugee.get(),"");
        }
        return new RefugeeDTO(dummyRefugee,"Password is incorrect");
    }

    @Override
    public RefugeeDTO deleteAccount(String email) {

        // Check if refugee exists
        Optional<Refugee> existing = refugeeDAO.getRefugeeByEmail(email);
        if (existing.isEmpty()) {
            return new RefugeeDTO(null, "No refugee with email: " + email + " found.");
        }

        // Check if refugee is part of any agreements. If yes, check if agreement is pending or accepted. If pending -> remove it, else unable to delete.


        Optional<Agreement> existingAgreement = agreementCommunicationInterface.getAgreementByRefugeeEmail(email); //TODO

        if (existingAgreement.isPresent()) {
            if (existingAgreement.get().isAccepted()) {
                return new RefugeeDTO(null, "Unable to delete, due to refugee being part of an accepted agreement");
            }
            else {
                agreementCommunicationInterface.deleteAgreement(existingAgreement.get().getAgreementId());
            }
        }

        refugeeDAO.deleteAccount(email);

        System.out.println("Refugee with email: " + email + " deleted");

        return new RefugeeDTO(null, "");
    }

    @Override
    public RefugeeDTO updateInformation(RefugeeUpdateDTO dto) {

        System.out.println("DTO SIZE CHECK: " + dto.getFamilySize());
        Optional<Refugee> refugee = refugeeDAO.getRefugeeByEmail(dto.getEmail());
        if(refugee.isEmpty())
        {
            return new RefugeeDTO(null, "The refugee with the given email does not exist.");
        }
        else {

            Refugee toBeUpdated = refugee.get();

            if (!dto.getFirstName().isBlank()) {
                toBeUpdated.setFirstName(dto.getFirstName());
                System.out.println("UPDATING FIRST NAME");
            }

            toBeUpdated.setMiddleName(dto.getMiddleName());
            System.out.println("UPDATING MIDDLE NAME");

            if (!dto.getLastName().isBlank()) {
                toBeUpdated.setLastName(dto.getLastName());
                System.out.println("UPDATING LAST NAME");
            }
            if (!dto.getPassword().isBlank()) {
                toBeUpdated.setPassword(passwordEncoder.encode(dto.getPassword()));
                System.out.println("UPDATING PASSWORD");
            }
            toBeUpdated.setGender(dto.getGender());
            System.out.println("UPDATING GENDER");
            if (!dto.getNationality().isBlank()) {
                toBeUpdated.setNationality(dto.getNationality());
                System.out.println("UPDATING NATIONALITY");
            }
            if (!dto.getDescription().isBlank()) {
                toBeUpdated.setDescription(dto.getDescription());
            }
            toBeUpdated.setFamilySize(dto.getFamilySize());

           Refugee updated = refugeeDAO.updateInformation(toBeUpdated);
            return new RefugeeDTO(updated, "");
        }
    }

    @Override
    public RefugeeDTO getRefugeeById(String email) {
        Optional<Refugee> refugee = refugeeDAO.getRefugeeByEmail(email);
        if (refugee.isEmpty()) {
            return new RefugeeDTO(null, "Refugee with this email can not be found.");
        }
        return new RefugeeDTO(refugeeDAO.getRefugeeByEmail(email).get(), "");
    }

}
