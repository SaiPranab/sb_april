package com.jt.jt_blogs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jt.jt_blogs.model.Blog;

@Service
public class BlogService {
    public List<Blog> getBlogs() {
        var blog1 = new Blog(1, "Exploring Java Streams",
                "A deep dive into Java Stream API and its powerful features.");

        var blog2 = new Blog(2, "Introduction to Spring Boot",
                "Getting started with Spring Boot for building RESTful APIs.");

        var blog3 = new Blog(3, "Understanding Docker",
                "Basics of Docker containers and how to use them in development.");

        var blog4 = new Blog(4, "Effective Git Practices", "Tips and tricks for efficient version control with Git.");

        return List.of(blog1, blog2, blog3, blog4);
    }
}
