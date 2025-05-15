package com.jt.jt_blogs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jt.jt_blogs.model.Blog;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

}
