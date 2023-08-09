package com.asayke.jnews.service;

import com.asayke.jnews.model.News;
import com.asayke.jnews.repository.NewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {
    private final NewsRepository newsRepository;

    @Override
    public void save(News news) {
        newsRepository.save(news);
    }

    @Override
    public boolean isExist(String newTitle) {
        return newsRepository.existsByTitle(newTitle);
    }

    @Override
    public List<News> getAllNews() {
        return newsRepository.findAll();
    }
}