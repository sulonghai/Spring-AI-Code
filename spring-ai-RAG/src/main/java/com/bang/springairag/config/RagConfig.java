package com.bang.springairag.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.vectorstore.SimpleVectorStore;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

/**
 * @author sulonghai
 * @date 2025/6/2
 * @note nobug
 */
@Configuration
public class RagConfig {

    @Bean
    ChatClient chatCliet(ChatClient.Builder builder){
        return builder.defaultSystem("你是Java专家,可搭建系统架构")
                .build();
    }

    @Bean //向量存储
    VectorStore vectorStore(EmbeddingModel embeddingModel){
        SimpleVectorStore simpleVectorStore = SimpleVectorStore.builder(embeddingModel).build();
        //生成说明文档
        List<Document> documents = List.of(
                new Document("产品说明:名称:Java开发语音\n" +
                        "产品描述: Java是一种面向对象开发的语音。\n" +
                        "特性: \n" +
                        "1. 封装\n" +
                        "2. 继承\n" +
                        "3. 多态\n"));
        //向量化存储
        simpleVectorStore.add(documents);
        return simpleVectorStore;
    }

}
