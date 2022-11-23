package via.sep3.group11.tier2.shared.domain;

import via.sep3.group11.tier2.shared.exceptions.ValidationException;

import java.util.Optional;

public class ValidationHelper {

    protected static void ValidateFirstName(String firstName) throws ValidationException {
        if (firstName == null || firstName.isBlank()) {
            throw new ValidationException("First name should not be empty.");
        }
    }

    protected static void ValidateLastName(String lastName) throws ValidationException {
        if (lastName == null || lastName.isBlank()) {
            throw new ValidationException("Last name should not be empty.");
        }
    }

    protected static String ValidateMiddleName(Optional<String> middleName) throws ValidationException {
        if (middleName.isPresent()) {
            if (middleName.get().isBlank()) {
                throw new ValidationException("Middle name should not be empty if specified");
            }
            return middleName.get();
        } else {
            return "";
        }
    }

    protected static void ValidateEmail(String email) throws ValidationException {
        if (email.isBlank()) {
            throw new ValidationException("Email should not be empty or null.");
        }

        if (!email.contains(".") || !email.contains("@")) {
            throw new ValidationException("Email: <" + email + "> is not in current format: xxxx@xxx.xx");
        }
    }

    protected static void ValidatePassword(String password) throws ValidationException {
        if (password == null || password.isBlank()) {
            throw new ValidationException("Password should not be null or empty");
        }
    }

    protected static void ValidateNationality(String nationality) throws ValidationException {
        if (nationality == null || nationality.isBlank()) {
            throw new ValidationException("Nationality should not be null or empty.");
        }
    }

    protected static char ValidateGender(char gender) throws ValidationException {
        switch (Character.toUpperCase(gender)) {
            case 'M', 'O', 'F' -> {
                return Character.toUpperCase(gender);
            }
            default ->
                    throw new ValidationException("Gender should be one of the following: M(ale), F(emale) or O(ther).");
        }
    }
}
