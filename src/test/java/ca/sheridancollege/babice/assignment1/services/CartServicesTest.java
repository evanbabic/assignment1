package ca.sheridancollege.babice.assignment1.services;

import ca.sheridancollege.babice.assignment1.beans.Cart;
import ca.sheridancollege.babice.assignment1.beans.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartServicesTest {

    //testing the getsubtotal method.
    @Test
    void getSubTotal() {
        Product a = new Product();
        Product b = new Product();
        Product c = new Product();

        a.setProductId(12345L);
        a.setProductId(12346L);
        a.setProductId(1237L);

        a.setProductPrice(1000);
        b.setProductPrice(1000);
        c.setProductPrice(1000);

        Cart cart = new Cart();
        cart.getCartItems().add(a);
        cart.getCartItems().add(b);
        cart.getCartItems().add(c);

        double total = 0;

        for(Product product : cart.getCartItems()){
            total += product.getProductPrice();
        }

        System.out.println(total);
    }
}