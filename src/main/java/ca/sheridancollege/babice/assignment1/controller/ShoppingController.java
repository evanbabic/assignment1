package ca.sheridancollege.babice.assignment1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShoppingController {
    @GetMapping("/shopping")
    public String shopping(){
        return "shopping";
    }
}