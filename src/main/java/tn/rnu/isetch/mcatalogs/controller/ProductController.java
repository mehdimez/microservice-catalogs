package tn.rnu.isetch.mcatalogs.controller;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.rnu.isetch.mcatalogs.dto.ProductDto;
import tn.rnu.isetch.mcatalogs.entity.Product;
import tn.rnu.isetch.mcatalogs.service.ProductServiceImpl;

import java.lang.reflect.Type;
import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin
public class ProductController {
    @Autowired
    private ProductServiceImpl productService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/list")
    public List<ProductDto> getAllProducts(){
        Type listType = new TypeToken<List<ProductDto>>(){}.getType();
        return modelMapper.map(productService.getAllProducts(), listType);
    }

    @GetMapping("/product/{id}")
    public ProductDto getProductById(@PathVariable("id") Long id){
        Type type = new TypeToken<ProductDto>(){}.getType();
        return modelMapper.map(productService.getProductById(id), type);
    }

    @PostMapping("/add")
    public Product addProduct(ProductDto productDto, @RequestParam("files")MultipartFile[] files){
        Product product = modelMapper.map(productDto, Product.class);
        return productService.addProduct(product, files);
    }
    @PutMapping("/update")
    public Product updateProduct(ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);
        return productService.updateProduct(product);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable("id") Long id ){
        productService.deleteProduct(id);
    }
}
