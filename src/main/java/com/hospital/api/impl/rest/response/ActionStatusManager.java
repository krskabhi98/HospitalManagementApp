package com.hospital.api.impl.rest.response;

import com.hospital.business.domain.ActionStatus;
import com.hospital.business.domain.ActionStatusType;
import com.hospital.repository.IHospitalManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActionStatusManager implements IActionStatusNanager{

    @Autowired
    private IHospitalManagementRepository hospitalManagementRepository;


    @Override
    public ActionStatus getActionStatus(Long majorCode, Long minorCode) {

        ActionStatus actionStatus=hospitalManagementRepository.getResponseCodeByMajorMinor(majorCode,minorCode);

        if(null !=actionStatus){
            return actionStatus;
        }

        return ActionStatus.unableToRetriveActionStatus();
    }

    @Override
    public Exception getReportableException(ActionStatusType actionStatusType) {
        return null;
    }
}
