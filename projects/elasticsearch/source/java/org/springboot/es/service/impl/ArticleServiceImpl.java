package org.springboot.es.service.impl;

import com.google.common.collect.Lists;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springboot.es.entity.Article;
import org.springboot.es.repository.ArticleRepository;
import org.springboot.es.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chiangfai
 **/
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public Article save(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public void delete(Article article) {
        articleRepository.deleteById(article.getId());
    }

    @Override
    public List<Article> getByAuthor(String author) {
        MatchQueryBuilder matchQueryBuilder = new MatchQueryBuilder("author", author);
        return Lists.newArrayList(articleRepository.search(matchQueryBuilder));
    }

    @Override
    public Page<Article> getPageByParam(Integer pageNo, Integer pageSize, String param) {
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.matchPhraseQuery("content", param))
                .withPageable(PageRequest.of(pageNo, pageSize))
                .build();
        return articleRepository.search(searchQuery);
    }
}
