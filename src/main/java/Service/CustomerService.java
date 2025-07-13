package Service;

import dao.CustomerDAO;
import model.Customer;
import java.util.List;

public class CustomerService {
    private final CustomerDAO dao = new CustomerDAO();

    public void addCustomer(Customer c) {
        dao.create(c);
    }

    public List<Customer> listAll() {
        return dao.findAll();
    }

    public Customer findById(Long id) {
        return dao.find(id);
    }

    public void updateCustomer(Customer c) {
        dao.update(c);
    }

    public void removeCustomer(Long id) {
        dao.delete(id);
    }
}
