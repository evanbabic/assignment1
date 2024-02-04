package ca.sheridancollege.babice.assignment1.beans;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
public class Product implements Serializable{
    @Id
    @Column(name="PRODID")
    private Long productId;

    @Column(name="PRODNAME")
    private String productName;

    @Column(name="PRODPRICE")
    private double productPrice;

}
