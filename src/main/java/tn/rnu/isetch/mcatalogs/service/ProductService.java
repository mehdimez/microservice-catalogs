package tn.rnu.isetch.mcatalogs.service;

import tn.rnu.isetch.mcatalogs.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product updateProduct(Product product);

    Product getProductById(Long id);

    Product addProduct(Product product);

    void deleteProduct(Long id);
}
