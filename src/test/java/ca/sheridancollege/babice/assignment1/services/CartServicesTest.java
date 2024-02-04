package ca.sheridancollege.babice.assignment1.services;

import ca.sheridancollege.babice.assignment1.beans.Cart;
import ca.sheridancollege.babice.assignment1.beans.Product;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CartServicesTest {

    //testing to ensure subtotals are being summed correctly
    @Test
    public void testGetSubtotal(){
        Product a = new Product();
        a.setProductId(1L);
        a.setProductName("Prod 1");
        a.setProductPrice(10.0);

        Product b = new Product();
        b.setProductId(2L);
        b.setProductName("Prod 2");
        b.setProductPrice(20.0);

        List<Product> prodList = new ArrayList<>();
        prodList.add(a);
        prodList.add(b);

        double total = 0;

        for(Product product : prodList){
            total += product.getProductPrice();
        }

        System.out.println(total);
    }

    //testing that items are being added properly to the cart
    @Test
    void testAddItem(){
        Product a = new Product();
        a.setProductId(1L);
        a.setProductName("Prod 1");
        a.setProductPrice(10.0);

        Cart testCart = new Cart();
        CartServices cartServices = new CartServices(testCart);

        cartServices.addItem(a);

        System.out.println(cartServices.getSize());
        for(Product product : cartServices.getCart()){
            System.out.println(product.getProductId());
            System.out.println(product.getProductName());
            System.out.println(product.getProductPrice());
        }
    }
}