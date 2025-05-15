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
                return blogRepository.findAll(); // findAll() - extract all rows from the table
        }

        public void addBlog(Blog blog) {
                blogRepository.save(blog); // save - insert row into table
        }

        public Blog getBlogById(int id) {
                return blogRepository.findById(id)
                                .orElseThrow(() -> new RuntimeException("Blog not found with id " + id));

                // findById() -> it extract a row by matching the primary key
        }

        public void delete(int id) {
                var sql = "DELETE FROM %s WHERE id = ?".formatted(BLOG_TABLE);
                jdbcTemplate.update(sql, id);
        }

        public void updateBlog(Blog blog) {
                var id = blog.getId();
                var heading = blog.getHeading();
                var description = blog.getDescription();

                var sql = "UPDATE %s SET heading = ?, description = ? WHERE id = ?".formatted(BLOG_TABLE);
                jdbcTemplate.update(sql, heading, description, id);
        }
}
