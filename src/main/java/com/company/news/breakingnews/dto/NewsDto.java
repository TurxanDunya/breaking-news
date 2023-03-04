package com.company.news.breakingnews.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class NewsDto {
    private String head;
    private String body;
    private LocalDate createdDate;
    private Integer readCount;
}
