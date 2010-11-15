package org.adaptiveplatform.adapt.commons.validation.constraints.impl;

import org.junit.Test;

public class NonBlankValidatorTest extends BaseValidationTest {

    @Test
    public void shouldRejectNullStringAsInvalid() throws Exception {
        whenValidatingValueThatShouldNotBeNullOrBlankString(null);
        expectAtLeastOneConstraintViolationReported();
    }

    @Test
    public void shouldRejectEmptyStringAsInvalid() throws Exception {
        whenValidatingValueThatShouldNotBeNullOrBlankString("");
        expectAtLeastOneConstraintViolationReported();
    }

    @Test
    public void shouldRejectBlankStringAsInvalid() throws Exception {
        whenValidatingValueThatShouldNotBeNullOrBlankString(" \t\r\n");
        expectAtLeastOneConstraintViolationReported();
    }

    @Test
    public void shouldNotRejectNotBlankString() throws Exception {
        whenValidatingValueThatShouldNotBeNullOrBlankString("non blank string");
        expectNoConstraintViolations();
    }
    // =============================================================================================
    // ============================= BORING TEST IMPLEMENTATION DETAILS ============================
    // =============================================================================================

    private void whenValidatingValueThatShouldNotBeNullOrBlankString(String validatedValue) {
        validateObject(new NonBlankTestDto(validatedValue));
    }
}
