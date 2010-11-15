package org.adaptiveplatform.adapt.commons.validation.argsvalidation;

import java.lang.reflect.Method;
import javax.validation.ConstraintViolationException;

public interface MethodCallArgumentsValidator {

    /**
     * Validates actual arguments of a method call. If constraints defined for this method's
     * parameters (for example using JSR-303 annotations) are violated
     * {@link ConstraintViolationException} will be thrown. Actual configuration of constraints is
     * implementation-dependent.
     */
    void validateArguments(Method method, Object[] arguments) throws ConstraintViolationException;
}
