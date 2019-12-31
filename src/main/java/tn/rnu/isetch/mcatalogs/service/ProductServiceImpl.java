package tn.rnu.isetch.mcatalogs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.rnu.isetch.mcatalogs.entity.Product;
import tn.rnu.isetch.mcatalogs.repository.ProductRepository;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public boolean addProduct(Product product) {
        return false;
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }
}
