package org.adaptiveplatform.adapt.commons.validation.argsvalidation;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

interface MethodsWithValidatableArguments {

    void methodWithValidatableParameter(@NotNull String foo);

    void methodWithRecursivelyValidatableParameter(@Valid ValidatableDto dto);
}
