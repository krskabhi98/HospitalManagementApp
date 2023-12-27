package com.hospital.business.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public class ActionStatus implements Serializable {

    public static final Long SUCCESSFUL_STATUS_MAJOR_CODE=0L;
    public static final Long SUCCESSFUL_STATUS_MINOR_CODE=0L;
    public static final String SUCCESSFUL_STATUS_MESSAGE="Operation completed successfully";

    private static final long serialVersionUID=1L;
    private static final Long UNABLE_TO_RETRIVE_STATUS_MAJOR_CODE = 302L;
    private static final Long UNABLE_TO_RETRIVE_STATUS_MINOR_CODE = 1L;
    private static final String UNABLE_TO_RETRIVE_STATUS_ERROR_MESSAGE = "Data access error -  Unable to retrive error definition";

    @Min(0)
    @Max(99999)
    private Long major;

    @Min(0)
    @Max(99999)
    private Long minor;

    private Character level;

    @Size(min=1, max=255)
    private String message;

    @JsonIgnore
    private Long entityId;

    public static final ActionStatus successStatus(){
        ActionStatus result=new ActionStatus();
        result.setMajor(SUCCESSFUL_STATUS_MAJOR_CODE);
        result.setMinor(SUCCESSFUL_STATUS_MINOR_CODE);
        result.setMessage(SUCCESSFUL_STATUS_MESSAGE);
        result.setLevel(StatusCodeLevel.SUCCESS.getCode());

        return result;
    }

    public static final ActionStatus unableToRetriveActionStatus(){
        ActionStatus result=new ActionStatus();
        result.setMajor(UNABLE_TO_RETRIVE_STATUS_MAJOR_CODE);
        result.setMinor(UNABLE_TO_RETRIVE_STATUS_MINOR_CODE);
        result.setMessage(UNABLE_TO_RETRIVE_STATUS_ERROR_MESSAGE);
        result.setLevel(StatusCodeLevel.FATAL.getCode());
        return result;
    }

    public Long getMajor() {
        return major;
    }

    public void setMajor(Long major) {
        this.major = major;
    }

    public Long getMinor() {
        return minor;
    }

    public void setMinor(Long minor) {
        this.minor = minor;
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

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }
}
