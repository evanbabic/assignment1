package ca.sheridancollege.babice.assignment1.databases;

import ca.sheridancollege.babice.assignment1.beans.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
