package com.hotjoe.services.model.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class HeartbeatResponse {
    private String status;

    public HeartbeatResponse() {
    }

    public HeartbeatResponse(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
