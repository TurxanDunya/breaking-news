package com.company.news.breakingnews.service;

import com.company.news.breakingnews.dto.NewsDto;
import com.company.news.breakingnews.entity.News;
import com.company.news.breakingnews.mapper.NewsMapper;
import com.company.news.breakingnews.repository.NewsRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class  NewsService {
    private final NewsRepository newsRepository;
    private final NewsMapper newsMapper;

    public NewsService(NewsRepository newsRepository, NewsMapper newsMapper) {
        this.newsRepository = newsRepository;
        this.newsMapper = newsMapper;
    }

    public News findById(Integer id) {
        Optional<News> newsById = newsRepository.findById(id);
        if (newsById.isPresent()) {
            return newsById.get();
        }

        throw new RuntimeException("News not found!");
    }

    public void add(News news) {
        newsRepository.save(news);
    }

    public List<NewsDto> findNews() {
        List<News> newsList = newsRepository.findAll();
        return newsMapper.mapper(newsList);
    }

    public void update(Integer id, NewsDto newsDto){
        News news = findById(id);

        String head = newsDto.getHead();
        if(Objects.nonNull(head)){
            news.setHead(head);
        }

        String body = newsDto.getBody();
        if(Objects.nonNull(body)){
            news.setBody(body);
        }

        LocalDate createdDate = newsDto.getCreatedDate();
        if(Objects.nonNull(createdDate)) {
            news.setCreatedDate(createdDate);
        }

        Integer readCount = newsDto.getReadCount();
        if(Objects.nonNull(readCount)) {
            news.setReadCount(readCount);
        }

        newsRepository.save(news);
    }

    public void delete (Integer id ){
        newsRepository.delete(findById(id));
    }



}
