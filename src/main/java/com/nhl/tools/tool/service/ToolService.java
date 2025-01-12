package com.nhl.tools.tool.service;

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

}
