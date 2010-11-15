package org.adaptiveplatform.adapt.commons.validation.constraints;

import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.constraints.NotNull;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import org.adaptiveplatform.adapt.commons.validation.constraints.impl.NonBlankStringValidator;

/**
 * Requires a string to be neither null nor containig whitespace characters only.
 */
@NotNull
@Documented
@Constraint(validatedBy = {NonBlankStringValidator.class})
@Target(value = {METHOD, FIELD, ANNOTATION_TYPE, PARAMETER})
@Retention(value = RUNTIME)
public @interface NonBlank {

    String message() default "A blank string";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
