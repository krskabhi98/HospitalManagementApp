package com.hospital.business.domain;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum ActionStatusType {
    SUCCESS(0L, 0L),
    FATAL(99L,1L),
    INVALID_INPUT_RECEIVED(25L,25L);


    private static final Map<String, ActionStatusType> lookup = new HashMap<>(100);
    private Long major;
    private Long minor;

    ActionStatusType(Long major, Long minor) {
        this.major = major;
        this.minor = minor;
    }

    static {
        for (ActionStatusType a : EnumSet.allOf(ActionStatusType.class)) {
                lookup.put(a.name(),a);
                lookup.put(a.name().toUpperCase(),a);
        }
    }

    public static ActionStatusType fromCode(Long major, Long minor) {
        ActionStatusType actionStatusType = null;
        for (Map.Entry<String, ActionStatusType> status : lookup.entrySet()) {
            if (null != status && status.getValue().getMajor().equals(major) && status.getValue().getMinor().equals(minor)) {
                actionStatusType = status.getValue();
            }
        }
        return actionStatusType;
    }


    public Long getMajor() {
        return major;
    }

    public Long getMinor() {
        return minor;
    }
}
