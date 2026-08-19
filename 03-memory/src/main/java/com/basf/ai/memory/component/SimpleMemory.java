package com.basf.ai.memory.component;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SimpleMemory {

    private final Map<String, List<String>> memory = new HashMap<>();

    public List<String> getHistory(String conversationId) {

        return memory.getOrDefault(
                conversationId,
                new ArrayList<>()
        );

    }

    public void save(String conversationId, String message){
        memory
                .computeIfAbsent(
                        conversationId,
                        k -> new ArrayList<>()
                )
                .add(message);

    }

    // 新增
    public Map<String,List<String>> getAllMemory(){

        return memory;

    }

}
