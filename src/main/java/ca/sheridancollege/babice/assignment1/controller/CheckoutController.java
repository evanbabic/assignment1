package ca.sheridancollege.babice.assignment1.controller;

import ca.sheridancollege.babice.assignment1.services.CartServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CheckoutController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
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
            logger.error("Error: ", e);
            model.addAttribute("errorMessage", e);
            return "error";
        }
    }
}
