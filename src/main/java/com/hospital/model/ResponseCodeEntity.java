package com.hospital.model;

import jakarta.persistence.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;


@Entity(name = "ResponseCode")
@Table(name = "RSPNS_TYP")
@Cacheable
public class ResponseCodeEntity implements Serializable {
    private static final long serialVersionUID=1L;

    @EmbeddedId
    @AttributeOverrides({@AttributeOverride(column = @Column(name = "MAJ_CDE"), name="key.majorCode"),
                        @AttributeOverride(column = @Column(name="MNR_CDE"), name="key.minorCode")})
    private ResponseCodeEntityPk key;

    @Column(name="RSPNS_LVL_VAL", nullable=false, columnDefinition = "VARCHAR2(1)")
    private Character level;

    @Column(name = "RSPNS_MSG_TXT", length =255, nullable = false )
    private String message;

    public ResponseCodeEntityPk getKey() {
        return key;
    }

    public void setKey(ResponseCodeEntityPk key) {
        this.key = key;
    }

    public Character getLevel() {
        return level;
    }

    public void setLevel(Character level) {
        this.level = level;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseCodeEntity that = (ResponseCodeEntity) o;
        return new EqualsBuilder()
                .append(getKey(), that.getKey())
                .isEquals();
       }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17,37).
                append(getKey())
                .toHashCode();
    }
}
