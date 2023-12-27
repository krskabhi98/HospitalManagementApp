package com.hospital.api.impl.rest.response;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Status  implements IStatus{

    private String majorCode;
    private String minorCode;
    private String level;
    private String message;


    public Status(String majorCode, String minorCode, String level, String message) {
        this.majorCode = majorCode;
        this.minorCode = minorCode;
        this.level = level;
        this.message = message;
    }

    public String getMajorCode() {
        return majorCode;
    }

    public void setMajorCode(String majorCode) {
        this.majorCode = majorCode;
    }

    public String getMinorCode() {
        return minorCode;
    }

    public void setMinorCode(String minorCode) {
        this.minorCode = minorCode;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    @JsonIgnore
    public String toString() {
        return "Status{" +
                "majorCode='" + majorCode + '\'' +
                ", minorCode='" + minorCode + '\'' +
                ", level='" + level + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
