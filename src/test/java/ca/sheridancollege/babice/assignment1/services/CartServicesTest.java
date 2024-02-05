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

        //creating sample objects to test logic on
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


        //testing that summing product.getProductPrice gives the desired results
        for(Product product : prodList){
            total += product.getProductPrice();
        }

        assertEquals(30.0, total);
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

        //tests to see if objects are properly added to cart
        assertEquals(1, cartServices.getSize());
        assertEquals(1L, cartServices.getCart().get(0).getProductId());
        assertEquals("Prod 1", cartServices.getCart().get(0).getProductName());
        assertEquals(10.0, cartServices.getCart().get(0).getProductPrice());
        //purposely failed text
        //assertEquals("Prod", cartServices.getCart().get(0).getProductName());
    }
}