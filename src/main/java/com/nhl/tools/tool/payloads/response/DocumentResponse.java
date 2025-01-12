package com.nhl.tools.tool.payloads.response;

import java.util.Date;
import java.util.List;

public class DocumentResponse extends MessageResponse{

    private List<Documents> documents;

    public DocumentResponse(String message, String code) {
        super(message, code);
    }

    public DocumentResponse(String message, String code, List<Documents> documents) {
        super(message, code);
        this.documents = documents;
    }

    public DocumentResponse() {
        super();
    }

    public List<Documents> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Documents> documents) {
        this.documents = documents;
    }
}
