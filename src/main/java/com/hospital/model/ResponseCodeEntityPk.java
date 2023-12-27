package com.hospital.model;

import jakarta.persistence.Column;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

public class ResponseCodeEntityPk implements Serializable {

    private static final long serialVersionUID=1l;

    @Column(name = "Maj_CDE", columnDefinition = "NUMBER(5)")
    private Long majorCode;

    @Column(name = "MNR_CDE", columnDefinition = "NUMBER(5)")
    private Long minorCode;

    public Long getMajorCode() {
        return majorCode;
    }

    public void setMajorCode(Long majorCode) {
        this.majorCode = majorCode;
    }

    public Long getMinorCode() {
        return minorCode;
    }

    public void setMinorCode(Long minorCode) {
        this.minorCode = minorCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ResponseCodeEntityPk that = (ResponseCodeEntityPk) o;

        return new EqualsBuilder()
                .append(getMajorCode(), that.getMajorCode())
                .append(getMinorCode(), that.getMinorCode())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getMajorCode())
                .append(getMinorCode())
                .toHashCode();
    }
}
