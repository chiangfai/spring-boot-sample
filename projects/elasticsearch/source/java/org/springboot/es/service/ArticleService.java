package org.springboot.es.service;

import org.springboot.es.entity.Article;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author chiangfai
 **/
public interface ArticleService {

    Article save(Article article);

    void delete(Article article);

    List<Article> getByAuthor(String author);

    Page<Article> getPageByParam(Integer pageNo, Integer pageSize, String param);
}
