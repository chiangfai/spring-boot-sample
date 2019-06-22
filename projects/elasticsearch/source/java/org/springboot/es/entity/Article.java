package org.springboot.es.entity;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * @author chiangfai
 **/
@Data
@Document(indexName = "article")
public class Article implements Serializable {

    private static final long serialVersionUID = -1362989529628030146L;

    private Long id;
    private String title;
    private String author;
    private String content;

}
