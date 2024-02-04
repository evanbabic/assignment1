package ca.sheridancollege.babice.assignment1.controller;

import ca.sheridancollege.babice.assignment1.beans.Cart;
import ca.sheridancollege.babice.assignment1.databases.ProductRepository;
import ca.sheridancollege.babice.assignment1.services.CartServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShoppingController {
    private final ProductRepository productRepository;
    private final CartServices cartServices;

    Cart shoppingCart = new Cart();
    @Autowired
    public ShoppingController(ProductRepository productRepository, CartServices cartServices){
        this.productRepository = productRepository;
        this.cartServices = cartServices;
    }

    @GetMapping("/shopping")
    public String shopping(Model model){
        model.addAttribute("productList", productRepository.findAll());
        model.addAttribute("itemsInCart", cartServices.getSize());
        return "shopping";
    }

    @PostMapping("/addToCart")
    public String addToCart(Model model, @RequestParam Integer productId){
        cartServices.addItem(productRepository.findById(productId).get());
        model.addAttribute("itemsInCart", cartServices.getSize());
        return "redirect:/shopping";
    }
}
