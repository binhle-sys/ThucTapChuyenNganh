package com.example.demo.ConTroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeConTroller {
    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/booking")
    public String booking(){
        return "home/booking";
    }
    @GetMapping("/contact")
    public String contact(){
        return "home/contact";
    }
    @GetMapping("/gallery")
    public String gallery(){
        return "home/gallery";
    }
    @GetMapping("/pricing")
    public String pricing(){
        return "home/pricing";
    }
    @GetMapping("/services")
    public String services(){
        return "home/services";
    }
    @GetMapping("/shop")
    public String shop(){
        return "home/shop";
    }
    @GetMapping("/cart")
    public String cart(){
        return "home/cart";
    }
    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }

}
