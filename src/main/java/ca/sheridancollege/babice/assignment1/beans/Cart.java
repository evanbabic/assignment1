package ca.sheridancollege.babice.assignment1.beans;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
public class Cart {
    private List<Product> cartItems = new ArrayList<>();
    private double total;

    public Cart(){
        this.cartItems = new ArrayList<>();
    }

}
