package tn.rnu.isetch.mcatalogs.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.rnu.isetch.mcatalogs.entity.Category;
import tn.rnu.isetch.mcatalogs.entity.Product;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class CategoryControllerTest {
    Category category;

    @Mock
    CategoryController categoryController;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        category = new Category();

        category.setName("name");
        category.setProducts(new ArrayList<Product>());
    }

    @Test
    void getAllCategories() {
        List<Category> liste = categoryController.getAllCategories();
        assertNotNull(liste);

    }

    @Test
    void getCategoryById() {
        when(categoryController.getCategoryById(anyLong())).thenReturn(category);
        Category ct =categoryController.getCategoryById(category.getId());


        assertNotNull(ct);


        assertEquals(ct.getName(), category.getName());
        assertEquals(ct.getProducts(), category.getProducts());
    }

    @Test
    void addCategory() {
        when(categoryController.getCategoryById(anyLong())).thenReturn(category);



        categoryController.addCategory(category);
        assertNotNull(category.getName());

        assertNotNull(category.getProducts());



        Category ct =categoryController.getCategoryById(category.getId());


        assertNotNull(ct);


        assertEquals(ct.getName(), category.getName());
        assertEquals(ct.getProducts(), category.getProducts());
    }

    @Test
    void updateCategory() {
        String newName= "Update Test";
        String oldName  = category.getName();
        category.setName(newName);

        when(categoryController.getCategoryById(anyLong())).thenReturn(category);
        Category ct =categoryController.getCategoryById(category.getId());


        assertNotNull(ct);


        assertNotEquals(oldName, category.getName());
        assertEquals(ct.getProducts(), category.getProducts());
    }

    @Test
    void deleteCategory() {
        long categoryId=40;

        categoryController.deleteCategory(categoryId);

        verify(categoryController, times(1)).deleteCategory(eq(categoryId));
    }
}