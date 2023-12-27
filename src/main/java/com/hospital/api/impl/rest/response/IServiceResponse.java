package com.hospital.api.impl.rest.response;

import java.util.List;

public interface IServiceResponse<T extends IStatus> {

    public List<T> getStaus();

    public void setStatus(List<T> status);
}
