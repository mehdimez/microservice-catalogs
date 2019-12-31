package tn.rnu.isetch.mcatalogs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.rnu.isetch.mcatalogs.entity.Category;
import tn.rnu.isetch.mcatalogs.service.CategoryService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public List<Category> getAllCategories() {return categoryService.getAllCategories();}

    @GetMapping("/categoryById/{id}")
    public Category getCategoryById(@PathVariable("id") long id) {
        return categoryService.getCategoryById(id);
    }

    @PostMapping("/add")
    public Category addCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }

    @PutMapping("/update")
    public void updateCategory(@Valid @RequestBody Category category) {
        categoryService.updateCategory(category);
    }

    @DeleteMapping("delete/{id}")
    public void deleteCategory(@PathVariable("id") long id) {
        categoryService.deleteCategory(id);
    }
}
