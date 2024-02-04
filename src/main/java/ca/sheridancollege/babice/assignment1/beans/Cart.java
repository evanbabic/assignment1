package ca.sheridancollege.babice.assignment1.beans;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
public class Cart {
    private List<Product> cart = new ArrayList<>();

    public void addItem(Product product){
        cart.add(product);
    }

    public int getSize(){
        return cart.size();
    }

    public List<Product> getCart(){
        return cart;
    }
}
