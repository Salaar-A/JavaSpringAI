package com.ecitcarp.practicespringboot.controller;

import com.ecitcarp.practicespringboot.dto.Movie;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/AI")
@Slf4j
public class AICrudController {

    private final ChatClient chatClient;

    private final ChatMemory chatMemory;

    @Value("classpath:/prompts/movies.st")
    private Resource movieTemplate;

    public AICrudController(ChatClient.Builder builder, ChatMemory chatMemory) {
        this.chatClient = builder
                .build();
        this.chatMemory = chatMemory;
    }

    @GetMapping("/callAI")
    public String callAI(@RequestParam String question, @RequestParam String user){
        return chatClient.prompt()
                .system("You will give response in a sarcastic way always")
                .user(question)
                .advisors(MessageChatMemoryAdvisor.builder(chatMemory).build())
                .advisors(a -> a.param(ChatMemory.CONVERSATION_ID, user))
                .call()
                .content();
    }

    @GetMapping("/moviesuggestion")
    public Movie movieSuggestion(@RequestParam String mood, @RequestParam String language){
        return chatClient.prompt()
                .system("You will give response in a friendly way always")
                .user(u-> u.text(movieTemplate).param("mood",mood).param("language",language))
                .call()
                .entity(Movie.class);
    }
}
