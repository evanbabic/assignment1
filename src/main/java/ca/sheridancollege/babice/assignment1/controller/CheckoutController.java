package ca.sheridancollege.babice.assignment1.controller;

import ca.sheridancollege.babice.assignment1.services.CartServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CheckoutController {
    @Autowired
    CartServices cartServices;

    @GetMapping("/checkout")
    public String checkout(Model model){
        model.addAttribute("itemsInCart", cartServices.getCart());
        return "checkout";
    }
}
