package com.example.cgnjava243openaiapi.service;

import com.example.cgnjava243openaiapi.model.OpenAiMessage;
import com.example.cgnjava243openaiapi.model.OpenAiRequest;
import com.example.cgnjava243openaiapi.model.OpenAiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class OpenAIService {

    private final RestClient client;

    public OpenAIService(@Value("${BASE_URL}") String baseurl,
                         @Value("${AUTH_KEY}") String key) {
        client = RestClient.builder()
                .defaultHeader("Authorization", "Bearer " + key)
                .baseUrl(baseurl)
                .build();
    }

    public String getAnswerFromOpenAi(String q) {
        OpenAiRequest request= new OpenAiRequest("gpt-3.5-turbo",
                List.of(new OpenAiMessage("user", q)), 0.7);

        OpenAiResponse response = client.post()
                .contentType(MediaType.APPLICATION_JSON)
                .body(request)
                .retrieve()
                .body(OpenAiResponse.class);

        return response.getAnswer();
    }
}
