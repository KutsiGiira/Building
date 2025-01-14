package com.example.GuessTheWord.Service;

import com.example.GuessTheWord.Entity.Word;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

@Service
public class WordService {
    private final List<Word> words;
    public WordService() throws IOException {
        String jsonPath = "src/main/resources/items.json";
        String jsonData = new String(Files.readAllBytes(Paths.get(jsonPath)));

        ObjectMapper mapper = new ObjectMapper();
        words = mapper.readValue(jsonData, new TypeReference<List<Word>>() {});
    }

    public Word getRandomWord() {
        Random random = new Random();
        return words.get(random.nextInt(words.size()));
    }
}
