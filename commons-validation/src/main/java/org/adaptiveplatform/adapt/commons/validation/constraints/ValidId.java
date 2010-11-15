package org.adaptiveplatform.adapt.commons.validation.constraints;

import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Used to indicate that given element must be a valid identifier, that is a not null value
 * greater than 0 (this is a workaround around Spring's BlazeDS bridge which passes value 0 where
 * you would normally expect 0 in regular Java code).
 */
@NotNull
@Min(1L)
@Documented
@Constraint(validatedBy = {})
@Target(value = {METHOD, FIELD, ANNOTATION_TYPE, PARAMETER})
@Retention(value = RUNTIME)
public @interface ValidId {

    String message() default "Not a valid identifier";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
