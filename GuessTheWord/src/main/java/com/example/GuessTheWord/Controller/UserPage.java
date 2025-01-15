package com.example.GuessTheWord.Controller;

import com.example.GuessTheWord.Entity.Word;
import com.example.GuessTheWord.Service.WordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
//@GetMapping("/game")
//public String gamePage(@RequestParam(value = "word", required = false) String inputWord,
//                       @SessionAttribute(value = "currentWord", required = false) String currentWord,
//                       Model model) {
//
//    if (currentWord == null) {
//        // Get a random word if no word is stored in the session
//        Word randomWord = wordService.getRandomWord();
//        currentWord = randomWord.getWord();  // Store the word to compare later
//    }
//
//    String text = "";  // Initialize the text to an empty string
//    if (inputWord != null) {  // Only compare if inputWord is not null (i.e., the form has been submitted)
//        if (inputWord.equalsIgnoreCase(currentWord)) {
//            text = "Correct!";
//        } else {
//            text = "Try again!";
//        }
//    }
//
//    // Add the current word and feedback message to the model
//    model.addAttribute("word", currentWord);
//    model.addAttribute("text", text);
//
//    // Save the current word in the session for future requests
//    model.addAttribute("currentWord", currentWord);
//
//    return "gamepage";  // Return the name of the view
//}

}
