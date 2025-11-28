package com.example.demo.ConTroller;

import com.example.demo.entity.Oder;
import com.example.demo.entity.product;
import com.example.demo.service.OderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/oders")
public class OderController {
    private OderService oderService;
    public OderController(OderService oderService) {this.oderService = oderService;}
    @GetMapping("/orders-list")
    public String list(Model model) {
        List<Oder> oders= oderService.findAll();
        model.addAttribute("oders",oders);
        return "admin/oders/orders-list";
    }
}
