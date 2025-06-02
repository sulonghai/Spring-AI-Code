package com.bang.springairag.controller;

import com.bang.springairag.config.RagConfig;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.QuestionAnswerAdvisor;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sulonghai
 * @date 2025/6/2
 * @note 利用外部知识库，帮助大模型生成更加准确，有依据的答案
 */
@RestController
public class RagController {

    @Autowired
    private ChatClient chatClient;
    @Autowired
    private VectorStore vectorStore;

    @GetMapping("/rag")
    public String rag(String query) {
        String content = chatClient.prompt()
                .user(query)
                .advisors(new QuestionAnswerAdvisor(vectorStore))
                .call()
                .content();
        return content;
    }

}
