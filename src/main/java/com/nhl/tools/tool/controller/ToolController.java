package com.nhl.tools.tool.controller;

import com.nhl.tools.tool.service.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
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


}
