package org.adaptiveplatform.adapt.commons.validation.argsvalidation;

import org.adaptiveplatform.adapt.commons.validation.constraints.ValidId;

class ValidatableDto {

    private Integer foo;

    public ValidatableDto(Integer foo) {
        this.foo = foo;
    }

    @ValidId
    public Integer getFoo() {
        return foo;
    }
}
