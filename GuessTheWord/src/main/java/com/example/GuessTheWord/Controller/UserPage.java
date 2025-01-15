package com.example.GuessTheWord.Controller;

import com.example.GuessTheWord.Entity.Word;
import com.example.GuessTheWord.Service.WordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Objects;

@Controller
public class UserPage {
    private final WordService wordService;
    private Word word;
    public UserPage(WordService wordService) {
        this.wordService = wordService;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }
    @GetMapping("/game")
    public String gamePage(@RequestParam String name, Model m){
        Word rndm = wordService.getRandomWord();
        m.addAttribute("name", name);
        m.addAttribute("word", rndm);
        return "gamepage";
    }
    @GetMapping("/test")
        public String holder(@RequestParam String answer, Model m){
        m.addAttribute("answer", "You entered: " + answer);
            return "test";
    }
}
