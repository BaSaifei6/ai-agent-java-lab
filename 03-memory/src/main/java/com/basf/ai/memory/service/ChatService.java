package com.basf.ai.memory.service;

import com.basf.ai.memory.component.SimpleMemory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {

    @Autowired
    private SimpleMemory memory;

    @Autowired
    private ChatClient chatClient;

    public String chat(String conversationId, String message) {
        // 1、取历史
        List<String> history = memory.getHistory(conversationId);

        // 2、拼接历史
        StringBuffer prompt = new StringBuffer();
        for (String s : history) {
            prompt.append(s)
                    .append("\n");
        }

        prompt.append(
                        "用户:"
                )
                .append(message);

        // 3.发送给模型
        String answer =
                chatClient.prompt()
                        .user(prompt.toString())
                        .call()
                        .content();

        // 4、保存聊天
        memory.save(
                conversationId,
                "用户:"+message
        );
        memory.save(
                conversationId,
                "AI:"+answer
        );

        System.out.println(memory.getAllMemory());

        return answer;
    }
}
