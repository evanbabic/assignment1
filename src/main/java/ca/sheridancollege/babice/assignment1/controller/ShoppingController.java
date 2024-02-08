package ca.sheridancollege.babice.assignment1.controller;

import ca.sheridancollege.babice.assignment1.databases.ProductRepository;
import ca.sheridancollege.babice.assignment1.services.CartServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShoppingController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
    private final ProductRepository productRepository;
    private final CartServices cartServices;

    @Autowired
    public ShoppingController(ProductRepository productRepository, CartServices cartServices){
        this.productRepository = productRepository;
        this.cartServices = cartServices;
    }

    @GetMapping("/shopping")
    public String shopping(Model model){
        //ensures products and cart are loaded successfully
        try{
            model.addAttribute("productList", productRepository.findAll());
            model.addAttribute("itemsInCart", cartServices.getSize());
            return "shopping";
        }

        //handles error gracefully
        catch(Exception e){
            logger.error("Error: ", e);
            model.addAttribute("errorMessage", e);
            return "error";
        }
    }

    @PostMapping("/addToCart")
    public String addToCart(Model model, @RequestParam Integer productId){
        //ensures product is added to cart successfully
        try {
            cartServices.addItem(productRepository.findById(productId).get());
            model.addAttribute("itemsInCart", cartServices.getSize());
            return "redirect:/shopping";
        }

        //catches error and handles gracefully
        catch(Exception e){
            logger.error("Error: ", e);
            model.addAttribute("errorMessage", e);
            return "error";
        }
    }
}
