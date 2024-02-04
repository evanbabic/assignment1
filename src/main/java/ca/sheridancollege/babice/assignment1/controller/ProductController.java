package ca.sheridancollege.babice.assignment1.controller;

import ca.sheridancollege.babice.assignment1.beans.Product;
import ca.sheridancollege.babice.assignment1.databases.ProductRepository;
import ca.sheridancollege.babice.assignment1.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    ProductServices productServices = new ProductServices(productRepository);

    @GetMapping("/products")
    public String products(Model model){
        model.addAttribute("productList", productRepository.findAll());
        model.addAttribute("productId", productServices.generateId());
        return "products";
    }

    @PostMapping("/formPost")
    public String formPost(@RequestParam String productId, @RequestParam String productName,
                           @RequestParam String productPrice, Model model){
        productServices.addProduct(Long.parseLong(productId), productName, Float.parseFloat(productPrice));
        return "redirect:/products";
    }
}
