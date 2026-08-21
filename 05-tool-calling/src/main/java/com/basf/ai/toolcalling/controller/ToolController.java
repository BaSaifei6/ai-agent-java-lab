package com.basf.ai.toolcalling.controller;

import com.basf.ai.toolcalling.service.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tool")
public class ToolController {

    @Autowired
    private ToolService ToolService;

    @GetMapping("/chat")
    public String Tool(String message){
        return ToolService.toolCall(message);

    }
}
