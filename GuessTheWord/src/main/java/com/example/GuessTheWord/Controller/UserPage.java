package com.example.GuessTheWord.Controller;

import com.example.GuessTheWord.Entity.Word;
import com.example.GuessTheWord.Service.WordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserPage {
    private final WordService wordService;

    public UserPage(WordService wordService) {
        this.wordService = wordService;
    }

    @GetMapping("/")
        public String home(){
            return "home";
    }
    @GetMapping("/game")
    public String gamePage(@RequestParam String name, Model m){
        m.addAttribute("name", name);
        m.addAttribute("word", wordService.getRandomWord().getWord());
        return "gamepage";
    }
}
