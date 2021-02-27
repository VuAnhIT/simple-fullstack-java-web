package com.theanh.fullstack.web.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class ClientSubmissionTest {
    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    final String blankMessage = "must not be blank";
    final String emailInvalidMessage = "must match \"" + ClientSubmission.EMAIL_PATTERN + "\"";
    String nameProperty = "name";
    String emailProperty = "email";
    String messageProperty = "message";
    ClientSubmission target = null;

    @BeforeEach
    void setUp() {
        target = new ClientSubmission();
    }

    private List<ConstraintViolation<ClientSubmission>> getPropertyViolations(Set<ConstraintViolation<ClientSubmission>> constraintViolations, String property) {
        return constraintViolations.stream()
                .filter(violation -> violation.getPropertyPath().toString().equals(property))
                .collect(Collectors.toList());
    }

    @Test
    public void testClientSubmission_InputValidValue_ReturnOk() throws Exception {
        // Setup target
        target.setName("test");
        target.setEmail("test@gmail.com");
        target.setMessage("this is a message");

        //Number of all errors
        Set<ConstraintViolation<ClientSubmission>> constraintViolations = validator
                .validate(target);
        assertEquals(0, constraintViolations.size());
    }

    @Test
    public void testClientSubmission_InputNullAll_ReturnCorrectErrorField() throws Exception {
        //Number of all errors
        Set<ConstraintViolation<ClientSubmission>> constraintViolations = validator
                .validate(target);
        assertEquals(3, constraintViolations.size());

        //Check each property errors
        List<ConstraintViolation<ClientSubmission>> nameViolations = getPropertyViolations(constraintViolations, nameProperty);
        assertEquals(1, nameViolations.size());
        for (ConstraintViolation<ClientSubmission> nameViolation : nameViolations) {
            assertEquals(blankMessage, nameViolation.getMessage());
        }

        List<ConstraintViolation<ClientSubmission>> emailViolations = getPropertyViolations(constraintViolations, emailProperty);
        assertEquals(1, emailViolations.size());
        for (ConstraintViolation<ClientSubmission> emailViolation : emailViolations) {
            assertEquals(blankMessage, emailViolation.getMessage());
        }

        List<ConstraintViolation<ClientSubmission>> messageViolations = getPropertyViolations(constraintViolations, messageProperty);
        assertEquals(1, messageViolations.size());
        for (ConstraintViolation<ClientSubmission> messageViolation : messageViolations) {
            assertEquals(blankMessage, messageViolation.getMessage());
        }
    }

    @Test
    public void testClientSubmission_InputSomeNull_ReturnCorrectErrorField() throws Exception {
        // Setup target
        target.setName("test");
        target.setEmail(null);
        target.setMessage(null);

        //Number of all errors
        Set<ConstraintViolation<ClientSubmission>> constraintViolations = validator
                .validate(target);
        assertEquals(2, constraintViolations.size());

        //Check each property errors
        List<ConstraintViolation<ClientSubmission>> nameViolations = getPropertyViolations(constraintViolations, nameProperty);
        assertEquals(0, nameViolations.size());

        List<ConstraintViolation<ClientSubmission>> emailViolations = getPropertyViolations(constraintViolations, emailProperty);
        assertEquals(1, emailViolations.size());
        for (ConstraintViolation<ClientSubmission> emailViolation : emailViolations) {
            assertEquals(blankMessage, emailViolation.getMessage());
        }

        List<ConstraintViolation<ClientSubmission>> messageViolations = getPropertyViolations(constraintViolations, messageProperty);
        assertEquals(1, messageViolations.size());
        for (ConstraintViolation<ClientSubmission> messageViolation : messageViolations) {
            assertEquals(blankMessage, messageViolation.getMessage());
        }

        // Setup target
        target.setName(null);
        target.setEmail(null);
        target.setMessage("test mess");

        //Number of all errors
        constraintViolations = validator
                .validate(target);
        assertEquals(constraintViolations.size(), 2);

        //Check each property errors
        nameViolations = getPropertyViolations(constraintViolations, nameProperty);
        assertEquals(1, nameViolations.size());
        for (ConstraintViolation<ClientSubmission> nameViolation : nameViolations) {
            assertEquals(blankMessage, nameViolation.getMessage());
        }

        emailViolations = getPropertyViolations(constraintViolations, emailProperty);
        assertEquals(1, emailViolations.size());
        for (ConstraintViolation<ClientSubmission> emailViolation : emailViolations) {
            assertEquals(blankMessage, emailViolation.getMessage());
        }

        messageViolations = getPropertyViolations(constraintViolations, messageProperty);
        assertEquals(0, messageViolations.size());
    }

    @Test
    public void testClientSubmission_InputBlankSpace_ReturnCorrectErrorField() throws Exception {
        // Setup target
        target.setName("   ");
        target.setEmail("      ");
        target.setMessage("   ");

        //Number of all errors
        Set<ConstraintViolation<ClientSubmission>> constraintViolations = validator
                .validate(target);
        assertEquals(4, constraintViolations.size());

        //Check each property errors
        List<ConstraintViolation<ClientSubmission>> nameViolations = getPropertyViolations(constraintViolations, nameProperty);
        assertEquals(1, nameViolations.size());
        for (ConstraintViolation<ClientSubmission> nameViolation : nameViolations) {
            assertEquals(blankMessage, nameViolation.getMessage());
        }

        List<ConstraintViolation<ClientSubmission>> emailViolations = getPropertyViolations(constraintViolations, emailProperty);
        assertEquals(2, emailViolations.size());
        for (ConstraintViolation<ClientSubmission> emailViolation : emailViolations) {
            switch (emailViolation.getMessage()) {
                case blankMessage:
                case emailInvalidMessage:
                    break;
                default:
                    fail("This message is unexpected: " + emailViolation.getMessage());
            }
        }

        List<ConstraintViolation<ClientSubmission>> messageViolations = getPropertyViolations(constraintViolations, messageProperty);
        assertEquals(1, messageViolations.size());
        for (ConstraintViolation<ClientSubmission> messageViolation : messageViolations) {
            assertEquals(blankMessage, messageViolation.getMessage());
        }

    }

    @Test
    public void testClientSubmission_InputEmptySpace_ReturnCorrectErrorField() {
        // Setup target
        target.setName("");
        target.setEmail("");
        target.setMessage("");

        //Number of all errors
        Set<ConstraintViolation<ClientSubmission>> constraintViolations = validator
                .validate(target);
        assertEquals(4, constraintViolations.size());

        //Check each property errors
        List<ConstraintViolation<ClientSubmission>> nameViolations = getPropertyViolations(constraintViolations, nameProperty);
        assertEquals(1, nameViolations.size());
        for (ConstraintViolation<ClientSubmission> nameViolation : nameViolations) {
            assertEquals(blankMessage, nameViolation.getMessage());
        }

        List<ConstraintViolation<ClientSubmission>> emailViolations = getPropertyViolations(constraintViolations, emailProperty);
        assertEquals(2, emailViolations.size());
        for (ConstraintViolation<ClientSubmission> emailViolation : emailViolations) {
            switch (emailViolation.getMessage()) {
                case blankMessage:
                case emailInvalidMessage:
                    break;
                default:
                    fail("This message is unexpected: " + emailViolation.getMessage());
            }
        }

        List<ConstraintViolation<ClientSubmission>> messageViolations = getPropertyViolations(constraintViolations, messageProperty);
        assertEquals(1, messageViolations.size());
        for (ConstraintViolation<ClientSubmission> messageViolation : messageViolations) {
            assertEquals(blankMessage, messageViolation.getMessage());
        }

    }

    private void validatingInvalidEmailOf(String email) {
        target.setEmail(email);
        //Number of all errors
        Set<ConstraintViolation<ClientSubmission>> constraintViolations = validator
                .validate(target);
        assertEquals(1, constraintViolations.size());

        //Check email property errors
        List<ConstraintViolation<ClientSubmission>> emailViolations = getPropertyViolations(constraintViolations, emailProperty);
        assertEquals(1, emailViolations.size());
        for (ConstraintViolation<ClientSubmission> emailViolation : emailViolations) {
            assertEquals(emailInvalidMessage, emailViolation.getMessage());
        }
    }

    @Test
    public void testClientSubmission_InputInvalidEmail_ReturnCorrectErrorField() throws Exception {
        // Setup target
        target.setName("test");
        target.setMessage("test");
        // Start validating
        validatingInvalidEmailOf("test");
        validatingInvalidEmailOf("test@");
        validatingInvalidEmailOf("test@gmaa");
        validatingInvalidEmailOf("test@gmaa.");
        validatingInvalidEmailOf("test.");
        validatingInvalidEmailOf("test.com");
        validatingInvalidEmailOf("@gmail");
        validatingInvalidEmailOf("@gmail.com");
        validatingInvalidEmailOf("test@@gmail.com");
    }
}