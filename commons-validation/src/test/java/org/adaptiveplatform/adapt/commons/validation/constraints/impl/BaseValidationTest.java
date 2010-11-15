package org.adaptiveplatform.adapt.commons.validation.constraints.impl;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import org.junit.Before;

import javax.validation.groups.Default;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author Rafal Jamroz
 */
public abstract class BaseValidationTest {

    private static final Class[] GROUPS = new Class[]{Default.class};
    private Validator validator;
    private Set<ConstraintViolation<Object>> violations;

    public BaseValidationTest() {
    }

    protected void expectAtLeastOneConstraintViolationReported() {
        assertTrue(violations.size() > 0);
    }

    protected void expectNoConstraintViolations() {
        assertEquals(violations.size(), 0);
    }

    @Before
    public void setUp() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    protected void validateObject(Object validatedValue) {
        violations = validator.validate(validatedValue, GROUPS);
    }
}
