package model;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne private Customer customer;
    @ManyToOne private Product product;
    private Integer quantity;
    private LocalDate orderDate;

    public Order() {}
    public Order(Customer customer, Product product, Integer quantity, LocalDate orderDate) {
        this.customer = customer; this.product = product; this.quantity = quantity; this.orderDate = orderDate;
    }

    // getters and setters...
    @Override public String toString() {
        return String.format("%d | %s | %s | %d | %s",
          id, customer.getName(), product.getName(), quantity, orderDate);
    }
}
