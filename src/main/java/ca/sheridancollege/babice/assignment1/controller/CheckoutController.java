package ca.sheridancollege.babice.assignment1.controller;

import ca.sheridancollege.babice.assignment1.services.CartServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CheckoutController {
    private final CartServices cartServices;
    @Autowired
    public CheckoutController(CartServices cartServices){
        this.cartServices = cartServices;
    }

    @GetMapping("/checkout")
    public String checkout(Model model){
        try{
            model.addAttribute("itemsInCart", cartServices.getCart());
            model.addAttribute("subTotal", cartServices.getSubTotal());
            model.addAttribute("tax", cartServices.getSubTotal() * 0.13);
            model.addAttribute("total", cartServices.getSubTotal() + (cartServices.getSubTotal() * 0.13));
            return "checkout";
        }

        catch(Exception e){
            return "error";
        }
    }
}
