package com.example.QuotesGen.Controller;


import com.example.QuotesGen.model.Mod;
import com.example.QuotesGen.service.Serv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class Page {
    @Autowired
    private Serv serv;

    public Page(Serv serv) {
        this.serv = serv;
    }
    @GetMapping("/")
public String home(Model m){
        m.addAttribute("quote", serv.getRandom());
    return "main";
}
}
