package via.sep3.group11.tier2.businessLogic;

import org.springframework.stereotype.Service;
import via.sep3.group11.tier2.daoInterfaces.RefugeeDaoInterface;
import via.sep3.group11.tier2.logicInterfaces.RefugeeInterface;
import via.sep3.group11.tier2.shared.DTOs.LoginDTO;
import via.sep3.group11.tier2.shared.DTOs.RefugeeRegisterDTO;
import via.sep3.group11.tier2.shared.domain.Refugee;
import via.sep3.group11.tier2.shared.exceptions.NotUniqueException;
import via.sep3.group11.tier2.shared.exceptions.ValidationException;

import java.util.Optional;

@Service
public class RefugeeLogic implements RefugeeInterface {

    private RefugeeDaoInterface refugeeDAO;

    public RefugeeLogic(RefugeeDaoInterface refugeeDAO) {
        this.refugeeDAO = refugeeDAO;
    }

    @Override
    public Refugee RegisterRefugee(RefugeeRegisterDTO dto) throws NotUniqueException, ValidationException {
        try {
            Refugee toRegister = new Refugee();

            toRegister.setEmail(dto.getEmail());
            toRegister.setPassword(dto.getPassword());
            toRegister.setGender(dto.getGender());
            toRegister.setNationality(dto.getNationality());
            toRegister.setFirstName(dto.getFirstName());
            toRegister.setMiddleName(Optional.ofNullable(dto.getMiddleName()));
            toRegister.setLastName(dto.getLastName());

            Optional<Refugee> existing = refugeeDAO.getRefugeeByEmail(toRegister.getEmail());

            if (existing.isPresent()) {
                throw new NotUniqueException("Refugee with email " + existing.get().getEmail() + " already exists.");
            }

            return refugeeDAO.createRefugee(toRegister);

        } catch (ValidationException e) {
            throw new ValidationException("Problem with provided information: " + e.getMessage());
        }
    }

    @Override
    public Refugee LoginRefugee(LoginDTO dto) throws ValidationException {
        try {
            Refugee toLogin = new Refugee();

            toLogin.setEmail(dto.getEmail());
            toLogin.setPassword(dto.getPassword());

            Optional<Refugee> loggedIn = refugeeDAO.getRefugeeByEmail(toLogin.getEmail());

            if (loggedIn.isEmpty()) {
                throw new NullPointerException("Refugee with email " + toLogin.getEmail() + " not found.");
            }

            if (!(toLogin.getPassword().equals(loggedIn.get().getPassword()))) {
                throw new ValidationException("Password incorrect.");
            }

            return loggedIn.get();

        } catch (ValidationException e) {
            throw new ValidationException("Problem with provided information: " + e.getMessage());
        }
    }

}
