package com.jt.jt_blogs.service;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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

        public void addBlog(Blog blog) {
                var sql = "INSERT INTO " + BLOG_TABLE + " (heading, description) VALUES (?, ?)";
                jdbcTemplate.update(sql, blog.getHeading(), blog.getDescription());
        }

        public Blog getBlogById(int id) {
                var sql = "SELECT * FROM " + BLOG_TABLE + " WHERE id = " + id;

                RowMapper<Blog> rowMapper = (resultSet, rowNum) -> {
                        return new Blog(
                                        resultSet.getInt("id"),
                                        resultSet.getString(2),
                                        resultSet.getString("description"));
                };
                Blog blog = jdbcTemplate.queryForObject(sql, rowMapper);
                return blog;

                // jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Blog.class));
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
