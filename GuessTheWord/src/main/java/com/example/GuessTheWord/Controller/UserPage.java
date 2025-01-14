package com.example.GuessTheWord.Controller;

import com.example.GuessTheWord.Entity.Word;
import com.example.GuessTheWord.Service.WordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserPage {
    private WordService wordService;
    private Word word;
    public UserPage(WordService wordService) {
        this.wordService = wordService;
    }
    public UserPage(Word word) {
        this.word = word;
    }

    public UserPage() {
    }

    @GetMapping("/")
        public String home(){
            return "home";
    }
    @GetMapping("/game")
    public String gamePage(@RequestParam String name, Model m){
        m.addAttribute("name", name);
        m.addAttribute("word", wordService.getRandomWord().getWord());
        m.addAttribute("text", word.getDesc());
        return "gamepage";
    }
}
