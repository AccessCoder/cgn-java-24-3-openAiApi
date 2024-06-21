package com.example.cgnjava243openaiapi.contoller;

import com.example.cgnjava243openaiapi.service.OpenAIService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ai")
@RequiredArgsConstructor
public class OpenAiController {

    private final OpenAIService service;

    @GetMapping()
    public String getAnswerFromOpenAi(@RequestParam String q){
        return service.getAnswerFromOpenAi(q);
    }

}
