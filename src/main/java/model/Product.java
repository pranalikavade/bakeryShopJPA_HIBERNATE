package model;
import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;

    public Product() {}
    public Product(String name, Double price) { this.name = name; this.price = price; }

    // getters and setters...
    @Override public String toString() { return String.format("%d | %s | %.2f", id, name, price); }
}
