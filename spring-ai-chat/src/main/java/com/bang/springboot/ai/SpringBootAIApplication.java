package com.bang.springboot.ai;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 微信公众号：Java技术栈
 */
@Slf4j
@SpringBootApplication
public class SpringBootAIApplication {

    @Value("${spring.ai.openai.api-key}")
    private String apiKey;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAIApplication.class, args);
    }

    @PostConstruct
    public void printApiKey() {
        log.info("API Key: {}", apiKey);
    }

}
