package com.example.erasmus_programs.service;

import com.example.erasmus_programs.entity.News;
import com.example.erasmus_programs.exception.NotFoundException;
import com.example.erasmus_programs.repository.NewsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class NewsService {
    private final NewsRepository newsRepository;

    public List<News> getAllNews() {
        return newsRepository.findAll();
    }

    public News getNewsById(Long id) {
        return newsRepository.findById(id).orElseThrow(() -> new NotFoundException("News with Id not found " + id));
    }

    public News createNews(String title, MultipartFile imageFile, String postedBy) throws IOException {
        News news = new News();
        news.setTitle(title);
        news.setImage(imageFile.getBytes());
        news.setPostedBy(postedBy);
        news.setDatePosted(LocalDate.now());
        return newsRepository.save(news);
    }

    public void deleteNews(Long id) {
        newsRepository.deleteById(id);
    }
}
