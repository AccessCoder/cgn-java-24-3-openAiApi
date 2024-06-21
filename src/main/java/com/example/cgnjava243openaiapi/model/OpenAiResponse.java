package com.example.cgnjava243openaiapi.model;

import java.util.List;

/**
 * {
 *     "choices": [
 *         {
 *             "message": {
 *                 "role": "assistant",
 *                 "content": "This is a test!"
 *             }
 *     ]
 * }
 */

public record OpenAiResponse(List<OpenAIChoices> choices) {

    public String getAnswer(){
        return choices.get(0).message().content();
    }

}
