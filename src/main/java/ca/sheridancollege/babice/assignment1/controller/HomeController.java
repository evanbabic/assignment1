package ca.sheridancollege.babice.assignment1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/error")
    public String error(){
        return "error";
    }
}
