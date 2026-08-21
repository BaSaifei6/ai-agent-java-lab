package com.basf.ai.toolcalling.service;

import com.basf.ai.toolcalling.tool.CommonTools;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToolService {

    @Autowired
    private CommonTools commonTools;

    @Autowired
    private ChatClient chatClient;

    public String toolCall(String message) {
        return chatClient.prompt()
                .user(message)
                .tools(commonTools)
                .call().content();
    }
}
