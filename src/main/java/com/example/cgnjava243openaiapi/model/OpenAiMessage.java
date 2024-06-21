package com.example.cgnjava243openaiapi.model;

/**
 * {
 *  *         "role": "system",
 *  *         "content": "You are a helpful assistant."
 *  *       }
 */
public record OpenAiMessage(
        String role,
        String content
) {
}
