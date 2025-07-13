package Service;
import dao.ProductDAO;
import model.Product;
import java.util.List;

public class ProductService {
    private ProductDAO dao = new ProductDAO();
    public void addProduct(Product p) { dao.create(p); }
    public List<Product> listAll() { return dao.findAll(); }
    public Product findById(Long id) { return dao.find(id); }
    public void updateProduct(Product p) { dao.update(p); }
    public void removeProduct(Long id) { dao.delete(id); }
}
