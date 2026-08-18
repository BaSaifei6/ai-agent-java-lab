package com.basf.ai.prompt.controller;

import com.basf.ai.prompt.service.impl.PromptServiceImpl;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/ai")
public class PromptController {
    private final ChatClient chatClient;

    @Autowired
    private PromptServiceImpl promptService;

    public PromptController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }



    @GetMapping("/chat")
    public String chat(String role, String message) throws IOException {

        return chatClient.prompt()
                .system(promptService.loadPrompt("prompts/" + role + ".txt"))
                .user(message)
                .call()
                .content();
    }

    @GetMapping("/duqurole")
    public String chatss(String role, String message) throws IOException {
        return promptService.loadPrompt("prompts/" + role + ".txt");
    }

    @GetMapping("/dongtai")
    public String chatdong(String role, String style, String message) throws IOException {

        String prompt = promptService.loadPrompt("prompts/" + role + ".txt");
        prompt = prompt.replace("{{role}}", role);
        prompt = prompt.replace("{{style}}", style);
        return chatClient.prompt()
                .system(prompt)
                .user(message)
                .call()
                .content();
    }
}
