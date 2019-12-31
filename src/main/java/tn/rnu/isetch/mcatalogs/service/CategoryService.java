package tn.rnu.isetch.mcatalogs.service;


import tn.rnu.isetch.mcatalogs.entity.Category;

import java.util.List;

public interface CategoryService {


    public List<Category> getAllCategories();
    public void updateCategory(Category category);
    public void deleteCategory(Long id);
    public Category addCategory(Category category);
    public Category getCategoryById(Long id);


}
