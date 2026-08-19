package com.basf.ai.memory.controller;

import com.basf.ai.memory.service.ChatService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @Autowired
    private ChatClient chatClient;

    @GetMapping("/chat")
    public String chat(String id, String message) {
        return chatService.chat(id, message);
    }

    @GetMapping("/chat/memory")
    public String chatMemory(String conversationId, String message) {
        String content = chatClient.prompt()
                .user(message)
                .advisors(advisor -> advisor.param(
                        ChatMemory.CONVERSATION_ID,
                        conversationId
                ))
                .call()
                .content();

        return content;
    }

}
