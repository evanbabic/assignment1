package ca.sheridancollege.babice.assignment1.controller;

import ca.sheridancollege.babice.assignment1.beans.Product;
import ca.sheridancollege.babice.assignment1.databases.ProductRepository;
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

    @GetMapping("/products")
    public String products(Model model){
        model.addAttribute("productList", productRepository.findAll());
        return "products";
    }

    @PostMapping("/formPost")
    public String formPost(@RequestParam String productId, @RequestParam String productName,
                           @RequestParam String productPrice, Model model){
        Product product = new Product();
        product.setProductId(Long.parseLong(productId));
        product.setProductName(productName);
        product.setProductPrice(Float.parseFloat(productPrice));
        productRepository.save(product);
        return "redirect:/products";
    }
}
