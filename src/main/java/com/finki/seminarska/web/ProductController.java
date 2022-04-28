package com.finki.seminarska.web;

import com.finki.seminarska.model.Category;
import com.finki.seminarska.model.Product;
import com.finki.seminarska.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/category/post/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String showProduct(@RequestParam Long id, Model model) {
        Optional<Product> product = this.productService.findById(id);
        model.addAttribute("product", product);
        model.addAttribute("bodyContent", "product");
        return "product";
    }
}
