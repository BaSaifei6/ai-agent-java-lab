package com.basf.ai.prompt.service;


import java.io.IOException;

public interface PromptService {
    String loadPrompt(String fileName) throws IOException;
}
