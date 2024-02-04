package ca.sheridancollege.babice.assignment1.services;

import ca.sheridancollege.babice.assignment1.beans.Cart;
import ca.sheridancollege.babice.assignment1.beans.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServices {
    private final Cart cart;

    @Autowired
    public CartServices(Cart cart){
        this.cart = cart;
    }

    public void addItem(Product product)
    {
        cart.getCartItems().add(product);
    }

    public int getSize(){
        return cart.getCartItems().size();
    }

    public List<Product> getCart(){
        return cart.getCartItems();
    }

    public double getSubTotal(){
        double subTotal = 0;

        for(Product product : cart.getCartItems()){
            subTotal += product.getProductPrice();
        }

        return subTotal;
    }
}
