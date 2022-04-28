package com.finki.seminarska.web;

import com.finki.seminarska.model.Category;
import com.finki.seminarska.model.Posts;
import com.finki.seminarska.service.CategoryService;
import com.finki.seminarska.service.PostsService;
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

    @Autowired
    public PostsController(PostsService postsService, CategoryService categoryService) {
        this.postsService = postsService;
        this.categoryService = categoryService;
    }

    @GetMapping
    private String findAll(Model model){

        List<Posts> posts = this.postsService.findAll();
        model.addAttribute("posts", posts);
        model.addAttribute("bodyContent", "posts");
        return "posts";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Posts> findById(@PathVariable Long id) {
        return this.postsService.findById(id)
                .map(product -> ResponseEntity.ok().body(product))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Posts> save(@RequestBody Posts posts) {
        return this.postsService.save(posts)
                .map(product -> ResponseEntity.ok().body(product))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Posts> edit(@PathVariable Long id, @RequestBody Posts productDto) {
        return this.postsService.edit(id, productDto)
                .map(product -> ResponseEntity.ok().body(product))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        this.postsService.deleteById(id);
        if(this.postsService.findById(id).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/add-post")
    public String addProductPage(Model model) {

        /*List<Category> categories = this.categoryService.listCategories();
        model.addAttribute("categories", categories);
        model.addAttribute("bodyContent", "add-product");*/
        return "add-form";
    }

}
