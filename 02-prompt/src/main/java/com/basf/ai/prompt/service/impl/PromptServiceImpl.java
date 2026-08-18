package com.basf.ai.prompt.service.impl;

import com.basf.ai.prompt.service.PromptService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Service
public class PromptServiceImpl implements PromptService {
    @Override
    public String loadPrompt(String fileName) throws IOException {
        InputStream inputStream =
                getClass().getClassLoader().getResourceAsStream(fileName);

        if (inputStream == null) {
            throw new RuntimeException("Prompt文件不存在：" + fileName);
        }

        return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
    }
}
