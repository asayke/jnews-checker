package com.asayke.jnews.service;

import com.asayke.jnews.model.News;

import java.util.List;

public interface NewsService {
    void save(News news);

    boolean isExist(String newTitle);

    List<News> getAllNews();
}