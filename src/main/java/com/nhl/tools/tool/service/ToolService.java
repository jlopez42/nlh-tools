package com.nhl.tools.tool.service;

import com.nhl.tools.tool.model.Document;
import com.nhl.tools.tool.payloads.request.DocumentRequest;
import com.nhl.tools.tool.payloads.response.DocumentResponse;
import com.nhl.tools.tool.payloads.response.Documents;
import com.nhl.tools.tool.repository.DocumentationRepository;
import com.nhl.tools.tool.util.WrapperTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToolService {

    @Autowired
    private DocumentationRepository repository;

    public ToolService(DocumentationRepository repository) {
        this.repository = repository;
    }
    public DocumentResponse newDocument(DocumentRequest request){

        if(!repository.existsByProjectId(request.getDocument().getProjectId())){
            Document document = repository.save(request.getDocument());
            return new DocumentResponse("Document has associated to project successfully",
                    "201",
                    List.of(new Documents(
                            document.getId(),
                            document.getTitle(),
                            document.getCreatedAt())));
        }
        return new DocumentResponse("This document have not been associated","409");
    }

    public DocumentResponse list(){
            List<Document> document = repository.findAll();
            if(!document.isEmpty()) {
                return new DocumentResponse("Document associated",
                        "201",
                        WrapperTool.convertTo(document));
            }
        return new DocumentResponse("Does not exist documents associated","409");
    }
}
