package com.jt.jt_blogs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.jt.jt_blogs.model.Blog;
import com.jt.jt_blogs.repository.BlogRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BlogService {
        private static final String BLOG_TABLE = "blog";
        private final JdbcTemplate jdbcTemplate;
        private final BlogRepository blogRepository;

        public List<Blog> getBlogs() {
                return blogRepository.findAll();
        }

        public void addBlog(Blog blog) {
                blogRepository.save(blog);
        }

        public Blog getBlogById(int id) {
                return blogRepository.findById(id)
                                .orElseThrow(() -> new RuntimeException("Blog not found with id " + id));
        }

        public void delete(int id) {
                blogRepository.delete(getBlogById(id));
        }

        public void updateBlog(Blog newBlog) {
                blogRepository.save(newBlog);
        }
}
