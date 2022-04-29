package com.finki.seminarska.web;

import com.finki.seminarska.model.Category;
import com.finki.seminarska.model.Posts;
import com.finki.seminarska.service.CategoryService;
import com.finki.seminarska.service.PostsService;
import com.finki.seminarska.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostsController {

    private final PostsService postsService;
    private final CategoryService categoryService;
    private final ProductService productService;

    @Autowired
    public PostsController(PostsService postsService, CategoryService categoryService, ProductService productService) {
        this.postsService = postsService;
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @GetMapping
    private String getPostsPage(Model model) {

        List<Posts> posts = this.postsService.findAll();
        model.addAttribute("posts", posts);
        model.addAttribute("bodyContent", "posts");
        return "master-template";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Posts> findById(@PathVariable Long id) {
        return this.postsService.findById(id)
                .map(product -> ResponseEntity.ok().body(product))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/add-post")
    public String addProductPage(Model model) {

        List<Category> categories = this.categoryService.listCategories();
        model.addAttribute("categories", categories);
        model.addAttribute("bodyContent", "add-form");
        return "master-template";
    }

    @PostMapping("/add")
    public String save(
            @RequestParam(required = false) Long id,
            @RequestParam String name,
            @RequestParam Double price,
            @RequestParam String description,
            @RequestParam Long category) {
        if (id != null) {
            this.productService.edit(name, price, description,category);
        } else {
            this.productService.save(name, price, description, category);
        }
        return "redirect:/posts";
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Posts> edit(@PathVariable Long id, @RequestBody Posts productDto) {
        return this.postsService.edit(id, productDto)
                .map(product -> ResponseEntity.ok().body(product))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Posts> deleteById(@PathVariable Long id) {
        this.postsService.deleteById(id);
        if (this.postsService.findById(id).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

}
