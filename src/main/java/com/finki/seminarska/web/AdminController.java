package com.finki.seminarska.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public String adminPage(Model model){

        model.addAttribute("bodyContent", "admin");
        return "master-template";
    }

    @GetMapping("/admin/categories")
    public String getCategories(Model model){

        model.addAttribute("bodyContent", "categories");
        return "master-template";
    }

    @GetMapping("/admin/categories/add")
    public String getAppCatPage(Model model){

        model.addAttribute("bodyContent", "add-category");
        return "master-template";
    }

    @PostMapping
    public String postCaterogry(){

        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/users")
    public String getUsers(Model model){
        return "users";
    }
}
