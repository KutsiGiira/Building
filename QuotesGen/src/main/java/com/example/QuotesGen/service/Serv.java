package com.example.QuotesGen.service;

import com.example.QuotesGen.model.Mod;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

@Service
public class Serv {
    private final List<Mod> js;
    public Serv() throws IOException {
        String jsonPath = "src/main/resources/static/base.json";
        String jsonData = new String(Files.readAllBytes(Paths.get(jsonPath)));

        ObjectMapper mapper = new ObjectMapper();
        js = mapper.readValue(jsonData, new TypeReference<List<Mod>>() {});
    }
    public Mod getRandom(){
        Random rndm = new Random();
        return js.get(rndm.nextInt(js.size()));
    }
}
