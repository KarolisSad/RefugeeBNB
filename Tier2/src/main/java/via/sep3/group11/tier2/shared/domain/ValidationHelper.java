package via.sep3.group11.tier2.shared.domain;

import via.sep3.group11.tier2.shared.exceptions.ValidationException;

import java.util.Optional;

public class ValidationHelper {

    protected static void ValidateFirstName(String firstName) throws ValidationException {
        SimpleValidateString(firstName, "First name");
    }

    protected static void ValidateLastName(String lastName) throws ValidationException {
        SimpleValidateString(lastName, "Last name");

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
        SimpleValidateString(email, "Email");


        if (!email.contains(".") || !email.contains("@")) {
            throw new ValidationException("Email: <" + email + "> is not in current format: xxxx@xxx.xx");
        }
    }

    protected static void ValidatePassword(String password) throws ValidationException {
        SimpleValidateString(password, "Password");

    }

    protected static void ValidateNationality(String nationality) throws ValidationException {
        SimpleValidateString(nationality, "Nationality");

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

    protected static void SimpleValidateString(String toValidate, String paramName) throws ValidationException {
        if (toValidate == null || toValidate.isBlank()) {
            throw new ValidationException(paramName + " should not be null or empty.");
        }
    }
}
