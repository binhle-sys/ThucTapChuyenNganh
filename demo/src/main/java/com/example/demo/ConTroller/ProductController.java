package com.example.demo.ConTroller;
import org.springframework.ui.Model;

import com.example.demo.dao.ProductDAO;
import com.example.demo.entity.product;
import com.example.demo.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/product")
public class ProductController {
    private ProductService productService;

    public  ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/products-list")
    public String list(Model model) {
        List<product> products= productService.findAll();
        model.addAttribute("products",products);
        return "admin/product/products-list";
    }
}
