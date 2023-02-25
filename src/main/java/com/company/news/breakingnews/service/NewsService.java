package com.company.news.breakingnews.service;

import com.company.news.breakingnews.dto.NewsDto;
import com.company.news.breakingnews.entity.News;
import com.company.news.breakingnews.mapper.NewsMapper;
import com.company.news.breakingnews.repository.NewsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {

    private final NewsRepository newsRepository;
    private final NewsMapper newsMapper;

    public NewsService(NewsRepository newsRepository, NewsMapper newsMapper) {
        this.newsRepository = newsRepository;
        this.newsMapper = newsMapper;
    }

    public void add(News news) {
        newsRepository.save(news);
    }

    public List<NewsDto> findNews() {
        List<News> newsList = newsRepository.findAll();
        return newsMapper.mapper(newsList);
    }
}
