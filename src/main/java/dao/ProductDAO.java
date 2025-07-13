package dao;

import model.Product;

public class ProductDAO extends GenericDAO<Product> {
    public ProductDAO() {
        super(Product.class);
    }
}
