package cn.javastack.springboot.ai.deepseek;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sulonghai
 * @date 2025/5/31
 * @note nobug
 */

@RestController
public class ChatModelController {

        @Autowired
        private ChatModel chatModel;

        @GetMapping("/chatModel01")
        public String generationChatModel01(String userInput) {
                String call = chatModel.call(userInput);
                return call;
        }

        @GetMapping("/chatModel02")
        public String generationChatModel02(String userInput) {
                ChatResponse chatResponse = chatModel.call(
                        new Prompt(
                                userInput,
                                ChatOptions.builder()
                                        .model("deepseek-chat")
                                        .temperature(0.8)
                                        .build()
                        )
                );
                String text = chatResponse.getResult().getOutput().getText();
                return text;
        }


}
