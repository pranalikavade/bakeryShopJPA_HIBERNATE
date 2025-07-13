package dao;

import model.Order;

public class OrderDAO extends GenericDAO<Order> {
    public OrderDAO() {
        super(Order.class);
    }
}
