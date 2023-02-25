package com.company.news.breakingnews.mapper;

import com.company.news.breakingnews.dto.NewsDto;
import com.company.news.breakingnews.entity.News;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NewsMapper {
    public List<NewsDto> mapper(List<News> news) {
        List<NewsDto> newsDtoList = new ArrayList<>();
        for(News currentNews : news){
            NewsDto newsDto = new NewsDto();
            newsDto.setHead(currentNews.getHead());
            newsDto.setBody(currentNews.getBody());
            newsDto.setCreatedDate(currentNews.getCreatedDate());
            newsDto.setReadCount(currentNews.getReadCount());
            newsDtoList.add(newsDto);
        }
        return newsDtoList;
    }
}
