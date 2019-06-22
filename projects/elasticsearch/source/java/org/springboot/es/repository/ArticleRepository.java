package org.springboot.es.repository;

import org.springboot.es.entity.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author chiangfai
 **/
@Repository
public interface ArticleRepository extends ElasticsearchRepository<Article, Long> {

}
