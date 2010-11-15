package org.adaptiveplatform.adapt.commons.validation.constraints.impl;

import org.adaptiveplatform.adapt.commons.validation.constraints.NonBlank;

class NonBlankTestDto {

    private String nonBlankField;

    public NonBlankTestDto(String nonBlankField) {
        this.nonBlankField = nonBlankField;
    }

    @NonBlank
    public String getNonBlankField() {
        return nonBlankField;
    }

    public void setNonBlankField(String nonBlankField) {
        this.nonBlankField = nonBlankField;
    }
}
