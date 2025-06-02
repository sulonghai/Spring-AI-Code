package com.bang.springboot.ai.deepseek;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sulonghai
 * @date 2025/6/1
 * @note 函数调用-大模型在生成回答是出发预定义的外部函数
 */
@RestController
public class FunctionController {

//    @Autowired
//    private final ChatClient chatClient;
    @Autowired
    private ChatModel chatModel;

    @GetMapping(value="/function",produces = MediaType.APPLICATION_JSON_VALUE)
    public String ragJsonText(@RequestParam(value ="userMessage") String userMessage) {
        return ChatClient.builder(chatModel)
                .build()
                .prompt()
                .system("您是算术计算器的代理。\n" +
                        "您能够支持加法运算、乘法运算等操作，其余功能将在后续版本中添加，如果用户问的问题不支持请告知详情在提供加法运算、乘法运算等操作之前，您必须从用户处获取如下信息:两个数字，运算类型。请调用自定义函数执行加法运算、乘法运算。\n" +
                        "请讲中文。")
                .user(userMessage)
//                .functions("addOperation",  "mulOperation")
                .call()
                .content();
    }

}
