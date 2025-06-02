package com.bang.springaiother.controller;

import com.alibaba.cloud.ai.dashscope.api.DashScopeImageApi;
import com.alibaba.cloud.ai.dashscope.image.DashScopeImageModel;
import com.alibaba.cloud.ai.dashscope.image.DashScopeImageOptions;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

/**
 * @author sulonghai
 * @date 2025/6/2
 * @note nobug
 */

@RestController
@RequestMapping("/imageController")
public class ImageController {

    @Autowired
    private DashScopeImageModel imageModel;

    @GetMapping("/generationImage")
     public void generationImage(@RequestParam(value = "msg",
            defaultValue = "生成一架F75七代战机，用于中美大战，具备极强的隐身性能") String msg,
                                   HttpServletResponse response) {
        ImageResponse imageResponse = imageModel.call(
                new ImagePrompt(
                        msg, DashScopeImageOptions.builder()
                        .withModel(DashScopeImageApi.DEFAULT_IMAGE_MODEL)
                        .withN(1)
                        .withHeight(1024)
                        .withWidth(1024)
                        .build()
                )
        );

        //生成图片的 url
        String imageUrl = imageResponse.getResult().getOutput().getUrl();
        //在浏览器输出
        try {
            URL url = URI.create(imageUrl).toURL();
            InputStream inputStream = url.openStream();
            response.setHeader("Content-Type", MediaType.IMAGE_PNG_VALUE);
            response.getOutputStream().write(inputStream.readAllBytes());
            response.getOutputStream().flush();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
