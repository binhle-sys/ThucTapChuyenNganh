package com.example.demo.ConTroller;

import com.example.demo.service.CategoryService;
import org.springframework.ui.Model;
import com.example.demo.dao.CategoryDAO;
import com.example.demo.dao.CategoryDAOimp;
import com.example.demo.entity.Category;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/category")
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/category-list")
    public String list(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories1", categories);
        return "admin/category/category-list";
    }
}
