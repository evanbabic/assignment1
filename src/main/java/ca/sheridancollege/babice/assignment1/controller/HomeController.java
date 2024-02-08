package ca.sheridancollege.babice.assignment1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    //responsible only for loading initial index page
    @GetMapping("/")
    public String index(){
        return "index";
    }
}
