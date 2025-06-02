package com.bang.springaiollama.controller;

import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sulonghai
 * @date 2025/6/2
 * @note nobug
 */
@RequestMapping ("/ollamaController")
@RestController
public class OllamaController {

    @Autowired
    private OllamaChatModel chatModel;

    @GetMapping("/ollama")
     public String chat(String message) {
        return chatModel.call(message);
    }

}
