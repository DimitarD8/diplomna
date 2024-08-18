package com.example.erasmus_programs.repository;

import com.example.erasmus_programs.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {
}
