package model;
import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    public Customer() {}
    public Customer(String name, String email) { this.name = name; this.email = email; }

    // getters and setters...
    @Override public String toString() { return String.format("%d | %s | %s", id, name, email); }
}
