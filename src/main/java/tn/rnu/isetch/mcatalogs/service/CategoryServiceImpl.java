package tn.rnu.isetch.mcatalogs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.rnu.isetch.mcatalogs.entity.Category;
import tn.rnu.isetch.mcatalogs.repository.CategoryRepository;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {


    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void updateCategory(Category categoryDetails) {
       categoryRepository.save(categoryDetails);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category addCategory(Category category) {
        return categoryRepository.saveAndFlush(category);
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).get();
    }
}
