package via.sep3.group11.tier2.shared.domain;

import via.sep3.group11.tier2.shared.exceptions.ValidationException;

import java.util.Optional;

/**
 * Helper class used to validate various values.
 * @version 27/11-2022
 * @author Group 11
 */
public class ValidationHelper {

    /**
     * Method used for validating a string representing a first name.
     * Validation is done by calling the SimpleValidateString-method with the parameter, and the parameter name.
     * @param firstName: The value to be validated.
     * @throws ValidationException if the SimpleValidateString-method throws an exception.
     */
    protected static void validateFirstName(String firstName) throws ValidationException {
        simpleValidateString(firstName, "First name");
    }

    /**
     * Method used for validating a string representing a last name.
     * Validation is done by calling the SimpleValidateString-method with the parameter, and the parameter name.
     * @param lastName: The value to be validated.
     * @throws ValidationException if the SimpleValidateString-method throws an exception.
     */
    protected static void validateLastName(String lastName) throws ValidationException {
        simpleValidateString(lastName, "Last name");

    }

    /**
     * Method used for validating an optional string representing a middle name.
     * If the parameter has content, a check is made to make sure that it is not an empty string.
     * If the parameter is empty, the method returns an empty string.
     * @param middleName: The optional value to set the middle name to.
     * @return The string value to assign to the middlename of the calling object.
     * @throws ValidationException if parameter contains an empty string.
     */
    protected static String validateMiddleName(Optional<String> middleName) throws ValidationException {
        if (middleName.isPresent()) {
            if (middleName.get().isBlank()) {
                throw new ValidationException("Middle name should not be empty if specified");
            }
            return middleName.get();
        } else {
            return "";
        }
    }

    /**
     * Method used for validating a string representing an email address.
     * Validation is done by calling the SimpleValidateString-method with the parameter, and the parameter name.
     * After this, it is verified that the email contains a dot(.) and an at(@).
     * @param email: The value to be validated.
     * @throws ValidationException if the SimpleValidateString-method throws an exception or if the email does not contain . or @.
     */
    protected static void validateEmail(String email) throws ValidationException {
        simpleValidateString(email, "Email");


        if (!email.contains(".") || !email.contains("@")) {
            throw new ValidationException("Email: <" + email + "> is not in current format: xxxx@xxx.xx");
        }
    }

    /**
     * Method used for validating a string representing a password.
     * Validation is done by calling the SimpleValidateString-method with the parameter, and the parameter name.
     * @param password: The value to be validated.
     * @throws ValidationException if the SimpleValidateString-method throws an exception.
     */
    protected static void validatePassword(String password) throws ValidationException {
        simpleValidateString(password, "Password");

    }

    /**
     * Method used for validating a string representing a nationality.
     * Validation is done by calling the SimpleValidateString-method with the parameter, and the parameter name.
     * @param nationality: The value to be validated.
     * @throws ValidationException if the SimpleValidateString-method throws an exception.
     */
    protected static void validateNationality(String nationality) throws ValidationException {
        simpleValidateString(nationality, "Nationality");

    }

    /**
     * Method used for validating and returning a char representing a gender.
     * @param gender The char to validate
     * @return the char representation of the gender to be assigned to the calling object.
     * @throws ValidationException if parameter is not M/m, F/f or O/o.
     */
    protected static char validateGender(char gender) throws ValidationException {
        switch (Character.toUpperCase(gender)) {
            case 'M', 'O', 'F' -> {
                return Character.toUpperCase(gender);
            }
            default ->
                    throw new ValidationException("Gender should be one of the following: M(ale), F(emale) or O(ther).");
        }
    }

    /**
     * Simple validation method used to verify that a String has content.
     * @param toValidate: The string to validate.
     * @param paramName: The name of the parameter from the calling method.
     * @throws ValidationException if the toValidate parameter is null or an empty string.
     */
    protected static void simpleValidateString(String toValidate, String paramName) throws ValidationException {
        if (toValidate == null || toValidate.isBlank()) {
            throw new ValidationException(paramName + " should not be null or empty.");
        }
    }
}
