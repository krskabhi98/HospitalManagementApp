package com.hospital.mapper;
import com.hospital.business.domain.ActionStatus;
import com.hospital.model.ResponseCodeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IResponseCodeMapper {

    @Mapping(source = "key.majorCode", target = "major")
    @Mapping(source = "key.minorCode", target = "minor")
    @Mapping(source = "level", target = "level")
    @Mapping(source = "message", target = "message")
    ActionStatus toActionStatus(ResponseCodeEntity responseCodeEntity);



    @Mapping(source = "major", target = "key.majorCode")
    @Mapping(source = "minor", target = "key.minorCode")
    @Mapping(source = "level", target = "level")
    @Mapping(source = "message" , target = "message")
    ResponseCodeEntity toResponseCodeEntity(ActionStatus actionStatus);
}
