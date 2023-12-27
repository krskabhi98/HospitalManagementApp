package com.hospital.api.impl.rest.response;

import com.hospital.business.domain.ActionStatus;
import com.hospital.business.domain.ActionStatusType;
import com.hospital.repository.IHospitalManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActionStatusManager implements IActionStatusNanager{

    @Autowired
    private IHospitalManagementRepository hospitalmanagementRepository;


    @Override
    public ActionStatus getActionStatus(ActionStatusType actionStatusType) {
        return null;
    }

    @Override
    public Exception getReportableException(ActionStatusType actionStatusType) {
        return null;
    }
}
