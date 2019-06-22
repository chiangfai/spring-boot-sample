package org.springboot.es.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springboot.es.entity.Article;
import org.springboot.es.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author chiangfai
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleServiceImplTest {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private ArticleService articleService;

    @Test
    public void save() {
        Article article = new Article();
        article.setId(1L);
        article.setAuthor("吴承恩");
        article.setTitle("西游记");
        article.setContent("不看僧面看佛面~来自猴子请来的逗比");
        articleService.save(article);

        article = new Article();
        article.setId(2L);
        article.setAuthor("曹雪芹");
        article.setTitle("红楼梦");
        article.setContent("看破的遁入空门，痴迷的妄送性命~来自红楼");
        articleService.save(article);

        article = new Article();
        article.setId(3L);
        article.setAuthor("施耐庵");
        article.setTitle("水浒传");
        article.setContent("欲求生快活，须下死工夫~来自108好汉");
        articleService.save(article);

        article = new Article();
        article.setId(4L);
        article.setAuthor("罗贯中");
        article.setTitle("三国演义");
        article.setContent("天下英雄，惟使君与操耳~来自三国");
        articleService.save(article);
    }

    @Test
    public void delete() {
        Article article = new Article();
        article.setId(1L);
        articleService.delete(article);
    }

    @Test
    public void getByAuthor() {
        List<Article> articles = articleService.getByAuthor("罗贯中");
        articles.forEach(article -> log.info(article.toString()));
    }

    @Test
    public void getPageByParam() {
        //分词器不好使，有必要使用IK分词器。
        Page<Article> page = articleService.getPageByParam(0, 2, "来");
        page.forEach(article -> log.info(article.toString()));
    }
}