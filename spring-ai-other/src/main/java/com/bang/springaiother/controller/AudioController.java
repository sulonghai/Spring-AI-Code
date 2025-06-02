package com.bang.springaiother.controller;

import com.alibaba.cloud.ai.dashscope.audio.DashScopeSpeechSynthesisModel;
import com.alibaba.cloud.ai.dashscope.audio.DashScopeSpeechSynthesisOptions;
import com.alibaba.cloud.ai.dashscope.audio.synthesis.SpeechSynthesisPrompt;
import com.alibaba.cloud.ai.dashscope.audio.synthesis.SpeechSynthesisResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * @author sulonghai
 * @date 2025/6/2
 * @note nobug
 */
@RestController
@RequestMapping("/audioController")
public class AudioController {

    @Autowired
    private DashScopeSpeechSynthesisModel speechSynthesisModel;

    private static final String TEXT = "你好，我是AI助手";
    private static final String FILE_PATH = "D:\\audio\\";

    public void tts() {
        DashScopeSpeechSynthesisOptions options = DashScopeSpeechSynthesisOptions.builder()
                .withSpeed(1.0)
                .withPitch(0.9)
                .withVolume(60)
                .build();

        SpeechSynthesisResponse response = speechSynthesisModel.call(new SpeechSynthesisPrompt(TEXT, options));

        //输出语音
        File file = new File(FILE_PATH + "\\output.mp3");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ByteBuffer byteBuffer = response.getResult().getOutput().getAudio();
            fos.write(byteBuffer.array());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

}
