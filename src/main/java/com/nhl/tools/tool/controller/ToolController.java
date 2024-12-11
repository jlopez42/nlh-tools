package com.nhl.tools.tool.controller;

import com.nhl.tools.tool.payloads.request.DocumentRequest;
import com.nhl.tools.tool.payloads.response.DocumentResponse;
import com.nhl.tools.tool.service.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/tool")
public class ToolController {

    @Autowired
    private ToolService service;

    public ToolController(ToolService service) {
        this.service = service;
    }

    @PostMapping("document/create")
    public ResponseEntity<DocumentResponse> createProject(@RequestBody DocumentRequest document){
        return ResponseEntity.ok(service.newDocument(document));
    }

    @GetMapping("document/list")
    public ResponseEntity<DocumentResponse> listProject(){
        return ResponseEntity.ok(service.list());
    }
}
