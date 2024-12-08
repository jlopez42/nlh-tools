package com.nhl.tools.tool.payloads.response;

import java.util.Date;

public class DocumentResponse extends MessageResponse{

    private Long id;
    private Date createdAt;

    public DocumentResponse(String message, String code) {
        super(message, code);
    }

    public DocumentResponse(String message, String code, Long id, Date createdAt) {
        super(message, code);
        this.id = id;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
