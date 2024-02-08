package ca.sheridancollege.babice.assignment1.databases;

import ca.sheridancollege.babice.assignment1.beans.Product;
import org.springframework.data.repository.CrudRepository;

//allows use of crudrepository methods with our product repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
