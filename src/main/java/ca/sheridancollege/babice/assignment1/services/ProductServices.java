package ca.sheridancollege.babice.assignment1.services;

import ca.sheridancollege.babice.assignment1.beans.Product;
import ca.sheridancollege.babice.assignment1.databases.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ProductServices {
    private final Random random = new Random();
    private final ProductRepository productRepository;

    @Autowired
    public ProductServices(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Long generateId(){
        return (long) (100000000 + random.nextInt(900000000));
    }

    public void addProduct(Long productId, String productName, Float productPrice){
        Product product = new Product();
        product.setProductId(productId);
        product.setProductName(productName);
        product.setProductPrice(productPrice);
        productRepository.save(product);
    }


}