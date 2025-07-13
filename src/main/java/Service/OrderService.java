package Service;

import dao.OrderDAO;
import model.Order;

import java.time.LocalDate;
import java.util.List;

public class OrderService {
    private final OrderDAO dao = new OrderDAO();

    public void placeOrder(Order o) {
        dao.create(o);
    }

    public List<Order> listAll() {
        return dao.findAll();
    }

    public Order findById(Long id) {
        return dao.find(id);
    }

    public void updateOrder(Order o) {
        dao.update(o);
    }

    public void removeOrder(Long id) {
        dao.delete(id);
    }

	public void placeOrder(Long cid, Long pid, Integer qty, LocalDate now) {
		// TODO Auto-generated method stub
		
	}
}
