package org.adaptiveplatform.adapt.commons.validation.constraints.impl;

import org.junit.Test;

public class ValidIdValidatorTest extends BaseValidationTest {

    @Test
    public void shouldConsiderNullAsInvalidValue() throws Exception {
        whenValidatingValueAsAValidIdentifier(null);
        expectAtLeastOneConstraintViolationReported();
    }

    @Test
    public void shouldConsiderZeroAsInvalidValue() throws Exception {
        whenValidatingValueAsAValidIdentifier(0L);
        expectAtLeastOneConstraintViolationReported();
    }

    @Test
    public void shouldConsiderValueGreaterThanZeroAsValidValue() throws Exception {
        whenValidatingValueAsAValidIdentifier(1L);
        expectNoConstraintViolations();
    }
    // =============================================================================================
    // ============================= BORING TEST IMPLEMENTATION DETAILS ============================
    // =============================================================================================

    private void whenValidatingValueAsAValidIdentifier(Long id) {
        validateObject(new ValidIdTestDto(id));
    }
}
