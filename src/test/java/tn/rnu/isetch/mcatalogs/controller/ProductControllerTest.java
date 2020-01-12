package tn.rnu.isetch.mcatalogs.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.multipart.MultipartFile;
import tn.rnu.isetch.mcatalogs.dto.ProductDto;
import tn.rnu.isetch.mcatalogs.entity.Category;
import tn.rnu.isetch.mcatalogs.entity.Product;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class ProductControllerTest {
    Product product;
    ProductDto pdto;
    MultipartFile[] files;
    @Mock
    ProductController productController;
    CategoryController categoryController;
    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        Category cat = new Category();

        cat.setName("name");
        cat.setProducts(new ArrayList<Product>());
        product = new Product();

        product.setAge(15);
        product.setName("name");
        product.setPicture("kjhb");
        product.setColor("red");
        product.setGender("genre");
        product.setPriceExclTax(5.0);
        product.setSize("48");
        product.setVat(30.5);



    }
    @Test
    void getAllProducts() {
        List <ProductDto> liste = productController.getAllProducts();
        assertNotNull(liste);
    }

    @Test
    void getProductById() {

        when(productController.getProductById(anyLong())).thenReturn(pdto);
        ProductDto pt =productController.getProductById(product.getId());


        assertNotNull(pt);


        assertEquals(pt.getName(), product.getName());
        assertEquals(pt.getAge(), product.getAge());
        assertEquals(pt.getColor(), product.getColor());
        assertEquals(pt.getGender(), product.getGender());
        assertEquals(pt.getPicture(), product.getPicture());
        assertEquals(pt.getPriceExclTax(), product.getPriceExclTax());
        assertEquals(pt.getSize(), product.getSize());
        assertEquals(pt.getVat(), product.getVat());



    }

    @Test
    void addProduct() {

        when(productController.getProductById(anyLong())).thenReturn(pdto);



        productController.addProduct(pdto, files);
        assertNotNull(product.getName());
        assertNotNull(product.getVat());
        assertNotNull(product.getSize());
        assertNotNull(product.getPriceExclTax());
        assertNotNull(product.getPicture());
        assertNotNull(product.getGender());
        assertNotNull(product.getAge());
        assertNotNull(product.getColor());

        ProductDto pt =productController.getProductById(product.getId());


        assertNotNull(pt);

        assertEquals(pt.getVat(), product.getVat());
        assertEquals(pt.getName(), product.getName());
        assertEquals(pt.getSize(), product.getSize());
        assertEquals(pt.getPriceExclTax(), product.getPriceExclTax());
        assertEquals(pt.getPicture(), product.getPicture());
        assertEquals(pt.getGender(), product.getGender());
        assertEquals(pt.getColor(), product.getColor());
        assertEquals(pt.getAge(), product.getAge());
    }

    @Test
    void updateProduct() {
        String newName= "Update Test";
        String oldName  = product.getName();
        product.setName(newName);

        when(productController.getProductById(anyLong())).thenReturn(pdto);
        ProductDto pdt =productController.getProductById(product.getId());


        assertNotNull(pdt);

        assertNotEquals(pdt.getVat(), product.getVat());
        assertNotEquals(oldName, product.getName());
        assertNotEquals(pdt.getSize(), product.getSize());
        assertNotEquals(pdt.getPriceExclTax(), product.getPriceExclTax());
        assertNotEquals(pdt.getPicture(), product.getPicture());
        assertNotEquals(pdt.getGender(), product.getGender());
        assertNotEquals(pdt.getColor(), product.getColor());
        assertNotEquals(pdt.getAge(), product.getAge());
    }

    @Test
    void deleteProduct() {
        long productId=40;

        productController.deleteProduct(productId);

        verify(productController, times(1)).deleteProduct(eq(productId));
    }

}