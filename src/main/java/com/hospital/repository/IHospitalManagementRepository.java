package com.hospital.repository;

import com.hospital.business.domain.ActionStatus;

public interface IHospitalManagementRepository {
    ActionStatus getResponseCodeByMajorMinor(Long majorCode, Long minorCode);
}
