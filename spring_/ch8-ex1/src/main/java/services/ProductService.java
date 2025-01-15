package services;

import models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();

    public List<Product> findAll() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }
}
