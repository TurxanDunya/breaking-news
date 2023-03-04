package com.company.news.breakingnews.controller;

import com.company.news.breakingnews.dto.NewsDto;
import com.company.news.breakingnews.entity.News;
import com.company.news.breakingnews.service.NewsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/news")
@RestController
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/{id}")
    public News findById(@PathVariable Integer id) {
        return newsService.findById(id);
    }

    @PostMapping
    public void add(@RequestBody News news) {
        newsService.add(news);
    }

    @GetMapping
    public List<NewsDto> findNews() {
        return newsService.findNews();
    }

    @PutMapping(value = "/{id}")
    public void update(@PathVariable Integer id, @RequestBody NewsDto newsDto) {
        newsService.update(id, newsDto);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable Integer id){
        newsService.delete(id);
    }


}
