package org.adaptiveplatform.adapt.commons.validation.constraints.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.adaptiveplatform.adapt.commons.validation.constraints.NonBlank;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author Rafal Jamroz
 */
public class NonBlankStringValidator implements ConstraintValidator<NonBlank, String> {

    @Override
    public void initialize(NonBlank constraintAnnotation) {
        // noop
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return StringUtils.isNotBlank(value);
    }
}
