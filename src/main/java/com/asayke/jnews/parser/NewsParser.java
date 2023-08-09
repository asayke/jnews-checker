package com.asayke.jnews.parser;

import com.asayke.jnews.model.News;
import com.asayke.jnews.properties.NewsProperties;
import com.asayke.jnews.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class NewsParser implements Parser {
    private final NewsService newsService;
    private final NewsProperties newsProperties;

    @Override
    @Scheduled(fixedDelay = 10000)
    public void parse() {
        String url = newsProperties.getUrl();

        try {
            Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla")
                    .timeout(5000)
                    .referrer("https://google.com")
                    .get();

            Elements news = doc.select(".titleline");

            for (Element el : news) {
                String title = el.text();

                if (!newsService.isExist(title)) {
                    News obj = new News();
                    obj.setTitle(title);
                    newsService.save(obj);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}