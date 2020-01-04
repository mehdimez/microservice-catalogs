package tn.rnu.isetch.mcatalogs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tn.rnu.isetch.mcatalogs.entity.Product;
import tn.rnu.isetch.mcatalogs.exceptions.ProductNotFoundException;
import tn.rnu.isetch.mcatalogs.repository.ProductRepository;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    public static String uploadDirectory = System.getProperty("user.dir")+"/src/main/resources/static/uploads";

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        if(products.isEmpty())
            throw new ProductNotFoundException("No product is available for sale");
        return products;
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
    public Product addProduct(Product product, MultipartFile[] files) {
        StringBuilder fileName = new StringBuilder();
        MultipartFile file = files[0];
        Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
        fileName.append(file.getOriginalFilename());
        try {
            Files.write(fileNameAndPath, file.getBytes());
        }catch (IOException e){
            e.printStackTrace();
        }
        product.setPicture(fileName.toString());
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if(!product.isPresent())
            throw new ProductNotFoundException("The product corresponding to the id "+id+" does not exist");
        return product;
    }
}