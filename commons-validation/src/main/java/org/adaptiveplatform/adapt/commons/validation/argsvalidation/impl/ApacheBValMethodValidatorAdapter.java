package org.adaptiveplatform.adapt.commons.validation.argsvalidation.impl;

import java.lang.reflect.Method;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import javax.validation.groups.Default;
import org.adaptiveplatform.adapt.commons.validation.argsvalidation.MethodCallArgumentsValidator;
import org.apache.bval.jsr303.extensions.MethodValidator;

/**
 *  Validates arguments of a method invocation using underlying Apache bval
 * {@link org.apache.bval.jsr303.extensions.MethodValidator}.
 */
public class ApacheBValMethodValidatorAdapter implements MethodCallArgumentsValidator {

    private static final Class[] GROUPS = new Class[]{Default.class};
    private MethodValidator validator;

    /**
     * @param validator must unwrap a {@link org.apache.bval.jsr303.extensions.MethodValidator}
     *        instance.
     */
    public ApacheBValMethodValidatorAdapter(Validator validator) {
        this.validator = validator.unwrap(MethodValidator.class);
    }

    @Override
    public void validateArguments(Method method, Object arguments[]) {
        Class declaringClass = method.getDeclaringClass();
        @SuppressWarnings("unchecked")
        final Set<ConstraintViolation<?>> violations =
                validator.validateParameters(declaringClass, method, arguments, GROUPS);
        throwExceptionIfViolationsOccured(violations);
    }

    private void throwExceptionIfViolationsOccured(final Set<ConstraintViolation<?>> violations) {
        if (violations.size() > 0) {
            throw new ConstraintViolationException(violations);
        }
    }
}
