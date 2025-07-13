package dao;

import model.Customer;

public class CustomerDAO extends GenericDAO<Customer> {
    public CustomerDAO() {
        super(Customer.class);
    }
}
