package com.bang.springboot.ai.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author sulonghai
 * @date 2025/5/31
 * @note nobug
 */

@Configuration
public class AiConfig {

    @Bean
    public ChatClient chatClient(ChatClient.Builder builder){
//        return builder.build(); //默认大模型的角色
        return builder.defaultSystem("你是一名优秀的Java开发工程师，你精通Java的各种底层技术栈，" +
                "在公司担任架构师岗位").build();  //自定义角色
    }



}
