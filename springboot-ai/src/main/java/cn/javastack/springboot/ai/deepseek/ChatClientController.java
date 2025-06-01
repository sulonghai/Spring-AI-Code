package cn.javastack.springboot.ai.deepseek;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sulonghai
 * @date 2025/5/31
 * @note 实现简单的对话
 */

@RestController
public class ChatClientController {

    private final ChatClient chatClient;

    public ChatClientController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @GetMapping("/ai")
    String generation(String userInput) {
        return this.chatClient.prompt()//提示词
                .user(userInput)//用户输入信息
                .call()//请求大模型
                .content();//返回文本
    }
}
