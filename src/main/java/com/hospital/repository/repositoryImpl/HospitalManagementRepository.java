package com.hospital.repository.repositoryImpl;

import com.hospital.business.domain.ActionStatus;
import com.hospital.business.domain.ActionStatusType;
import com.hospital.dao.impl.jpa.AbstractHospitalManagementDAO;
import com.hospital.mapper.IResponseCodeMapper;
import com.hospital.model.ResponseCodeEntity;
import com.hospital.model.ResponseCodeEntityPk;
import com.hospital.repository.IHospitalManagementRepository;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class HospitalManagementRepository extends AbstractHospitalManagementDAO implements IHospitalManagementRepository {

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Override
    public ActionStatus getResponseCodeByMajorMinor(Long majorCode, Long minorCode) {
        ResponseCodeEntityPk primaryKey=new ResponseCodeEntityPk();
        primaryKey.setMajorCode(majorCode);
        primaryKey.setMinorCode(minorCode);

        ResponseCodeEntity responseCodeEntity=getHospitalEntityManager().find(ResponseCodeEntity.class,primaryKey);

        if(null == responseCodeEntity){
            primaryKey.setMajorCode(ActionStatusType.FATAL.getMajor());
            primaryKey.setMinorCode(ActionStatusType.FATAL.getMinor());

            responseCodeEntity=getHospitalEntityManager().find(ResponseCodeEntity.class,primaryKey);
        }
        IResponseCodeMapper mapper= Mappers.getMapper(IResponseCodeMapper.class);

        return mapper.toActionStatus(responseCodeEntity);
    }
}
