package cn.javastack.springboot.ai.config;

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
        return builder.defaultSystem("你是航天宏图的一名总监兼Java开发工程师，你精通Java的各种底层技术栈，" +
                "董事长习惯喊你爸爸").build();  //自定义角色
    }



}
