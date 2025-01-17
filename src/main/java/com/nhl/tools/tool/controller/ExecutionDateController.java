package com.nhl.tools.tool.controller;

import com.nhl.tools.tool.payloads.request.ExecutionDateRequest;
import com.nhl.tools.tool.payloads.response.ExecutionDateResponse;
import com.nhl.tools.tool.service.ExecutionDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/support/execution")
public class ExecutionDateController {

    @Autowired
    private ExecutionDateService service;

    public ExecutionDateController(ExecutionDateService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<ExecutionDateResponse> createProject(@RequestBody ExecutionDateRequest executionDateRequest){
        return ResponseEntity.ok(service.newExecution(executionDateRequest));
    }

    @GetMapping("/list")
    public ResponseEntity<ExecutionDateResponse> listProject(){
        return ResponseEntity.ok(service.list());
    }

    @PutMapping("/{executionId}")
    public ResponseEntity<ExecutionDateResponse> createProject(@RequestBody ExecutionDateRequest executionDateRequest, @PathVariable int executionId){
        return ResponseEntity.ok(service.updateExecution(executionDateRequest, executionId));
    }

    @RequestMapping(value="/{executionId}", method=RequestMethod.DELETE)
    public ResponseEntity<ExecutionDateResponse> remove(@PathVariable Long executionId){
        return ResponseEntity.ok(service.removeExecution(executionId));
    }
}
