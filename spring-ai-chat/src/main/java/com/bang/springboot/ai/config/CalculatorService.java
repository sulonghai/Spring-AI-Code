package com.bang.springboot.ai.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

import java.util.function.Function;

/**
 * @author sulonghai
 * @date 2025/6/1
 * @note nobug
 */

@Configuration
public class CalculatorService {

    public record AddOperatin(int a, int b) {
    }

    public record MulOperatin(int a, int b) {
    }

    @Bean
    @Description("加法运算")
     public Function<AddOperatin,Integer> addOperatin() {
        return request -> {
            return request.a + request.b;
        };
    }

    @Bean
    @Description("乘法运算")
    public Function<MulOperatin,Integer> mulOperatin() {
        return request -> {
            return request.a * request.b;
        };
    }

}
