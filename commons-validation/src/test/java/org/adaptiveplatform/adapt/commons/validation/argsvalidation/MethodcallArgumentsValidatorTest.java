package org.adaptiveplatform.adapt.commons.validation.argsvalidation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import org.adaptiveplatform.adapt.commons.validation.argsvalidation.impl.ApacheBValMethodValidatorAdapter;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.fail;

public class MethodcallArgumentsValidatorTest {

    @Test(expected = ConstraintViolationException.class)
    public void shouldValidateAnnotatedParameters() throws Exception {
        final String invalidParameter = null;
        methodCallValidatingObject.methodWithValidatableParameter(invalidParameter);
        fail("Exception should have been thrown");
    }

    @Test(expected = ConstraintViolationException.class)
    public void shouldValidateRecursivelyParametersWithAtValidAnnotation() throws Exception {
        final ValidatableDto invalidDto = new ValidatableDto(null);
        methodCallValidatingObject.methodWithRecursivelyValidatableParameter(invalidDto);
        fail("Exception should have been thrown");
    }

    @Test
    public void shouldAcceptValidValuesInAnnotatedParamters() throws Exception {
        final String validParameter = "foobar";
        methodCallValidatingObject.methodWithValidatableParameter(validParameter);
    }

    @Test
    public void shouldAcceptValidValuesInRecursivelyValidatedParameters() throws Exception {
        final ValidatableDto validDto = new ValidatableDto(32);
        methodCallValidatingObject.methodWithRecursivelyValidatableParameter(validDto);
    }
    // =============================================================================================
    // ============================= BORING TEST IMPLEMENTATION DETAILS ============================
    // =============================================================================================
    private MethodCallArgumentsValidator validator;
    private MethodsWithValidatableArguments methodCallValidatingObject;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = new ApacheBValMethodValidatorAdapter(factory.getValidator());
        methodCallValidatingObject = validatingProxy();
    }

    /**
     * Creates a dynamic proxy for {@link MethodsWithValidatableArguments} interface that invokes
     * method arguments validation using configured {@link #validator}. This is a simple &
     * lightweight mock of what would happen in AOP-enabled environment, for example Spring app.
     */
    private MethodsWithValidatableArguments validatingProxy() {
        final ClassLoader classloader = getClass().getClassLoader();
        final Class[] interfaces = new Class[]{MethodsWithValidatableArguments.class};
        final ValidatingInvocationHandler invocationHandler = new ValidatingInvocationHandler();
        Object proxy = Proxy.newProxyInstance(classloader, interfaces, invocationHandler);
        return (MethodsWithValidatableArguments) proxy;
    }

    private class ValidatingInvocationHandler implements InvocationHandler {

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            validator.validateArguments(method, args);
            return null;
        }
    }
}
