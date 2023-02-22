package com.company.news.breakingnews.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Entity(name = "news")
@Table(name = "news")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String head;
    private String body;

    @Column(name = "created_date")
    private LocalDate createdDate;

    @Column(name = "read_count")
    private Integer readCount;

}
