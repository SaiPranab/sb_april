package com.jt.jt_blogs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jt.jt_blogs.service.BlogService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BlogController {
    private final BlogService blogService;

    @GetMapping
    public String home(Model model) {
        model.addAttribute("blogs", blogService.getBlogs());
        return "home";
    }

    @GetMapping("/form")
    public String form() {
        return "add-blog";
    }
}
