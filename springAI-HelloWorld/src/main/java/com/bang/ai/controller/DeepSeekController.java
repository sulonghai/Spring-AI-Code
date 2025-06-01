package com.bang.ai.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @ClassName: controller
 * @Description:
 * @Author: HTHT
 * @Date: 2025年06月01日 16:39
 */

@Slf4j
@RestController
@RequestMapping("/deepseek")
public class DeepSeekController {

    @Autowired
    private OpenAiChatModel chatModel;

    /**
     * 聊天接口
     * @param message
     * @return
     */
    @GetMapping("/chat")
    public String generate(@RequestParam(value = "message", defaultValue = "hello") String message) {
        return this.chatModel.call(message);
    }

    /**
     * 流式聊天接口
     * @param message
     * @return
     */
    @GetMapping("/chatStream")
    public Flux<ChatResponse> generateStream(@RequestParam(value = "message", defaultValue = "hello") String message) {
        Prompt prompt = new Prompt(new UserMessage(message));
        return this.chatModel.stream(prompt);
    }

}
