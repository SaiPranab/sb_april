package com.jt.jt_blogs.controller;

import java.io.PrintWriter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jt.jt_blogs.model.Blog;
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

    @PostMapping("/add-blog")
    public String addBlog(@ModelAttribute Blog blog) {
        blogService.addBlog(blog);
        return "redirect:/";
    }

    @GetMapping("/blog/{id}")
    public String getBlog(@PathVariable int id, Model model) {
        var blog = blogService.getBlogById(id);
        model.addAttribute("blog", blog);
        return "blog-detail";
    }

    @GetMapping("/blog/delete/{id}")
    public String deleteBlog(@PathVariable int id, Model model) {
        blogService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/blog/edit/{id}")
    public String editBlog(@PathVariable int id, Model model) {
        var blog = blogService.getBlogById(id);
        model.addAttribute("blog", blog);
        return "edit-blog";
    }
}
