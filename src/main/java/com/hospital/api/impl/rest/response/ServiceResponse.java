package com.hospital.api.impl.rest.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.List;

@JsonInclude(value = Include.NON_NULL)
public class ServiceResponse implements IServiceResponse<Status> {
    private String id;
    private List<Status> status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public List<Status> getStaus() {
        return status;
    }

    @Override
    public void setStatus(List<Status> status) {
        this.status = status;
    }

    @Override
    @JsonIgnore
    public String toString() {
        return "ServiceResponse{" +
                "status=" + status +
                '}';
    }
}
