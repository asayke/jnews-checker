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

//        try {
//            Document doc = Jsoup.connect(url)
//                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36 OPR/100.0.0.0")
//                    .timeout(500)
//                    .referrer("https://google.com")
//                    .get();

//            Elements news = doc.getElementsByClass("sitebit comhead");

//            for (Element element : news) {
//                String title = element.ownText();
//
//                if (!newsService.isExist(title)) {
//                    News n = new News();
//                    n.setTitle(title);
//
//                    newsService.save(n);
//                }
//            }
            News n = new News();
            n.setTitle("something");
            newsService.save(n);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}