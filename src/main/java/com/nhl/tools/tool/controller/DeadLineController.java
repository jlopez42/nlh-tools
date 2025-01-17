package com.nhl.tools.tool.controller;

import com.nhl.tools.tool.payloads.request.DeadLineRequest;
import com.nhl.tools.tool.payloads.response.DeadLineResponse;
import com.nhl.tools.tool.service.DeadLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/support/deadline")
public class DeadLineController {

    @Autowired
    private DeadLineService service;

    public DeadLineController(DeadLineService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<DeadLineResponse> createProject(@RequestBody DeadLineRequest deadLine){
        return ResponseEntity.ok(service.newDeadLine(deadLine));
    }

    @GetMapping("/list")
    public ResponseEntity<DeadLineResponse> listProject(){
        return ResponseEntity.ok(service.list());
    }

    @PutMapping("/{deadlineId}")
    public ResponseEntity<DeadLineResponse> createProject(@RequestBody DeadLineRequest deadLine, @PathVariable int deadlineId){
        return ResponseEntity.ok(service.updateDeadLine(deadLine, deadlineId));
    }

    @RequestMapping(value="/{deadlineId}", method=RequestMethod.DELETE)
    public ResponseEntity<DeadLineResponse> remove(@PathVariable Long deadlineId){
        return ResponseEntity.ok(service.removeDeadLine(deadlineId));
    }
}
