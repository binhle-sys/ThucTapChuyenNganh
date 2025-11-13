package com.example.demo.ConTroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @GetMapping("/Dashboard")
    public String admin() {
        return "admin";
    }
    @GetMapping("/admin/product")
    public String productList() {
        return "admin/product/products-list";
    }

    @GetMapping("/admin/category")
    public String categoryList() {
        return "admin/category/category-list";
    }
    @GetMapping("/admin/Users")
    public String users() {
        return "admin/users/users-list";
    }
    @GetMapping("/admin/oders")
    public String orders() {
        return "admin/oders/orders-list";
    }
}
