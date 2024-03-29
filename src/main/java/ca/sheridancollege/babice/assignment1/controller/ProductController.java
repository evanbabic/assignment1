package ca.sheridancollege.babice.assignment1.controller;

import ca.sheridancollege.babice.assignment1.databases.ProductRepository;
import ca.sheridancollege.babice.assignment1.services.ProductServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
    private final ProductRepository productRepository;
    private final ProductServices productServices;
    @Autowired
    public ProductController(ProductRepository productRepository, ProductServices productServices){
        this.productRepository = productRepository;
        this.productServices = productServices;
    }

    @GetMapping("/products")
    public String products(Model model){
        //ensuring there is a connection to repository and services
        try{
            model.addAttribute("productList", productRepository.findAll());
            model.addAttribute("productId", productServices.generateId());
            return "products";
        }

        //on error
        catch(Exception e){
            logger.error("Error: ", e);
            model.addAttribute("errorMessage", e);
            return "error";
        }
    }

    @PostMapping("/formPost")
    public String formPost(@RequestParam String productId, @RequestParam String productName,
                           @RequestParam String productPrice, Model model){

        //checks if product name was not entered
        if(productName == null || productName.isBlank()){
            model.addAttribute("errorMessage", "Product name can't be blank.");
            return  "error";
        }

        //validates price entered by user
        if(Float.parseFloat(productPrice) < 0 || Float.parseFloat(productPrice) > 999999){
            model.addAttribute("errorMessage", "Product price must be between 0 and 999999.");
            return "error";
        }

        //ensures product is added to cart successfully
        try{
            productServices.addProduct(Long.parseLong(productId), productName, Float.parseFloat(productPrice));
            return "redirect:/products";
        }

        //on invalid input
        catch(NumberFormatException e){
            logger.error("User input error: ", e);
            model.addAttribute("errorMessage", e);
            model.addAttribute("errorDetails", "Incorrect data entered for new product record. Please return to product page and try again.");
            return "error";
        }
    }
}
