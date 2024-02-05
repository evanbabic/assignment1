package ca.sheridancollege.babice.assignment1.beans;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
public class Cart {

    //list of Products in the cart
    private List<Product> cartItems;

    //constructor to instantiate the list of Products in cart
    public Cart(){
        this.cartItems = new ArrayList<>();
    }

}
