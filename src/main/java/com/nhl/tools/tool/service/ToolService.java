package com.nhl.tools.tool.service;

import com.nhl.tools.tool.model.Document;
import com.nhl.tools.tool.payloads.request.DocumentRequest;
import com.nhl.tools.tool.payloads.response.DocumentResponse;
import com.nhl.tools.tool.repository.DocumentationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToolService {

    @Autowired
    private DocumentationRepository repository;

    public ToolService(DocumentationRepository repository) {
        this.repository = repository;
    }
    public DocumentResponse newDocument(DocumentRequest request){

        if(repository.existsByProjectId(request.getDocument().getProjectId())){
            Document document = repository.save(request.getDocument());
            return new DocumentResponse("Document has associated to project successfully",
                    "201",
                    document.getId(),
                    document.getCreatedAt());
        }
        return new DocumentResponse("This document have not been associated","409");
    }
}
