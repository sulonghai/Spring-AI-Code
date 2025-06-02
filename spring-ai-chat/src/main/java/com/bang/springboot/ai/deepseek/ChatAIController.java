package com.bang.springboot.ai.deepseek;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @author sulonghai
 * @date 2025/5/31
 * @note 实现stream流式响应
 */

@RestController
@RequestMapping("/chatAI")
public class ChatAIController {

    @Autowired
    private ChatClient chatClient; //在AiConfig中注入

    @GetMapping("/callBack")
    String generation(String userInput) {
        return this.chatClient.prompt()//提示词
                .user(userInput)//用户输入信息
                .call()//请求大模型,生成结果一次输出
                .content();//返回文本
    }

    @GetMapping(value = "/streamBack",produces = "text/html;charset=UTF-8")
    Flux<String> generationOfStream(String userInput) {
        return this.chatClient.prompt()//提示词
                .user(userInput)//用户输入信息
                .stream()//请求大模型,流式响应
                .content();//返回文本
    }

}
