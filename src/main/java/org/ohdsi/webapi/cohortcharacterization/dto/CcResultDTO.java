package org.ohdsi.webapi.cohortcharacterization.dto;

import org.ohdsi.webapi.cohortcharacterization.CcResultType;

public class CcResultDTO {
    private CcResultType type;

    public CcResultType getType() {
        return type;
    }

    public void setType(final CcResultType type) {
        this.type = type;
    }
}