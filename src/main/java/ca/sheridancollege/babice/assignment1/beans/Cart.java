package ca.sheridancollege.babice.assignment1.beans;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
public class Cart {
    private List<Product> cartItems;

    public Cart(){
        this.cartItems = new ArrayList<>();
    }

}
