package com.basf.ai.prompt.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai")
public class PromptController {
    private final ChatClient chatClient;

    public PromptController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @GetMapping("/chat")
    public String chat(String message) {

        return chatClient.prompt()
                .system("你是一名资深Java后端工程师，只回答Java相关问题")
                .user(message)
                .call()
                .content();
    }
}
