package com.example.demo5.controller;

import com.example.demo5.model.Product;
import com.example.demo5.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping("")
    public String showHome(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "/list";
    }

    @GetMapping("/create")
    public String showAdd() {
        return "/create";
    }

    @PostMapping("/create")
    public String create(Product product) {
        productRepository.save(product);
        return "redirect:/home";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable int id, Model model) {
        model.addAttribute("o", productRepository.findById(id).get());
        return "/edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(Product product) {
        productRepository.save(product);
        return "redirect:/home";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        productRepository.deleteById(id);
        return "redirect:/home";
    }

    @GetMapping("/inf/{id}")
    public String inf(@PathVariable int id, Model model) {
        model.addAttribute("o", productRepository.findById(id).get());
        return "/inf";
    }
}
