package com.hospital.mapper.mapperImpl;


import com.hospital.business.domain.ActionStatus;
import com.hospital.mapper.IResponseCodeMapper;
import com.hospital.model.ResponseCodeEntity;
import com.hospital.model.ResponseCodeEntityPk;
import org.springframework.stereotype.Component;

import javax.annotation.processing.Generated;

@Generated(
        value = "org.mapstruct.ap.MappingProcessor",
        date = "2023-12-20T16:24:50+0530",
        comments = "version: 1.4.2"
)
@Component
public class IResponseCodeMapperImpl2  {


//    @Override
    public ActionStatus toActionStatus(ResponseCodeEntity responseCodeEntity) {
        if(null == responseCodeEntity){
            return null;
        }

        ActionStatus actionStatus=new ActionStatus();
        actionStatus.setMajor(responseCodeEntityKeyMajorCode(responseCodeEntity));
        actionStatus.setMinor(responseCodeEntityKeyMinorCode(responseCodeEntity));
        actionStatus.setLevel(responseCodeEntity.getLevel());
        actionStatus.setMessage(responseCodeEntity.getMessage());
        return null;
    }

    private Long responseCodeEntityKeyMinorCode(ResponseCodeEntity responseCodeEntity) {

        if(null == responseCodeEntity.getKey()){
            return null;
        }
        if(null == responseCodeEntity.getKey().getMinorCode()){
            return null;
        }
        return responseCodeEntity.getKey().getMinorCode();
    }

    private Long responseCodeEntityKeyMajorCode(ResponseCodeEntity responseCodeEntity) {

        if(null == responseCodeEntity.getKey()){
            return null;
        }
        if(null == responseCodeEntity.getKey().getMajorCode()){
            return null;
        }
        return responseCodeEntity.getKey().getMajorCode();
    }

//    @Override
    public ResponseCodeEntity toResponseCodeEntity(ActionStatus actionStatus) {
        if(null== actionStatus){
            return null;
        }
        ResponseCodeEntity responseCodeEntity=new ResponseCodeEntity();
        responseCodeEntity.setKey(actionStatusToResponseCodeEntityPk(actionStatus));
        responseCodeEntity.setLevel(actionStatus.getLevel());
        responseCodeEntity.setMessage(actionStatus.getMessage());

        return responseCodeEntity;
    }

    private ResponseCodeEntityPk actionStatusToResponseCodeEntityPk(ActionStatus actionStatus) {

        ResponseCodeEntityPk responseCodeEntityPk= new ResponseCodeEntityPk();

        responseCodeEntityPk.setMajorCode(actionStatus.getMajor());
        responseCodeEntityPk.setMinorCode(actionStatus.getMinor());

        return responseCodeEntityPk;
    }
}
