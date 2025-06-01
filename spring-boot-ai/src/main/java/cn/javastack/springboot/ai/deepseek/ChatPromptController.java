package cn.javastack.springboot.ai.deepseek;

import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.Generation;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.SystemPromptTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author sulonghai
 * @date 2025/6/1
 * @note 聊天模型-ChatModel 提示词
 */
@RestController
public class ChatPromptController {

    @Autowired
    private ChatModel chatModel;

    //提示词
    @GetMapping("/prompt")
    public String prompt(@RequestParam(value = "name") String name,@RequestParam(value = "voice") String voice){

        //设置用户输入信息
        String userText = "给我推荐北京的网红景点";
        UserMessage userMessage = new UserMessage(userText);

        //设置系统提示词
        String systemText = "你是一枚旅游博主，可以给人们推荐旅游攻略。" +
                "你的名字是{name}," +
                "你应该用你的名字和{voice}的打卡推荐回复用户的请求。";

        //使用Prompt Temple 设置信息
        SystemPromptTemplate systemPromptTemplate = new SystemPromptTemplate(systemText);

        //替换占位符
        Message systemMessage = systemPromptTemplate.createMessage(Map.of("name", name, "voice", voice));

        //使用Prompt
        Prompt prompt = new Prompt(List.of(userMessage, systemMessage));

        //调用chatModel
        List<Generation> results = chatModel.call(prompt).getResults();
        return results.stream().map(x -> x.getOutput().getText()).collect(Collectors.joining(""));
    }

}



