package com.jt.jt_blogs.service;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.jt.jt_blogs.model.Blog;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BlogService {
        private static final String BLOG_TABLE = "blogs";
        private final JdbcTemplate jdbcTemplate;

        public List<Blog> getBlogs() {
                var sql = "SELECT * FROM " + BLOG_TABLE;
                return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Blog.class));
        }
}
