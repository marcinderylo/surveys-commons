package org.adaptiveplatform.adapt.commons.validation.constraints.impl;

import org.adaptiveplatform.adapt.commons.validation.constraints.ValidId;

class ValidIdTestDto {

    private Long validId;

    public ValidIdTestDto(Long validId) {
        this.validId = validId;
    }

    @ValidId
    public Long getValidId() {
        return validId;
    }

    public void setValidId(Long validId) {
        this.validId = validId;
    }
}
