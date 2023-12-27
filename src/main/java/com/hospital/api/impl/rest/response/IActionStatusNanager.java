package com.hospital.api.impl.rest.response;

import com.hospital.business.domain.ActionStatus;
import com.hospital.business.domain.ActionStatusType;

public interface IActionStatusNanager {

    ActionStatus getActionStatus(Long majorCode, Long minorCode);

    Exception getReportableException(ActionStatusType actionStatusType);
}
