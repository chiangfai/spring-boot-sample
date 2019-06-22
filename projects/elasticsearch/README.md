**reference** : [https://docs.spring.io/spring-boot/docs/2.1.6.RELEASE/reference/html/boot-features-nosql.html#boot-features-elasticsearch](https://docs.spring.io/spring-boot/docs/2.1.6.RELEASE/reference/html/boot-features-nosql.html#boot-features-elasticsearch) 

# Elasticsearch
[Elasticsearch](https://www.elastic.co/cn/products/elasticsearch) is an open source, distributed, RESTful search and analytics engine. Spring Boot offers basic auto-configuration for Elasticsearch.

Spring Boot supports several HTTP clients:
- The official Java "Low Level" and "High Level" REST clients
- [Jest](https://github.com/searchbox-io/Jest)
The transport client is still being used by [Spring Data Elasticsearch](https://github.com/spring-projects/spring-data-elasticsearch), which you can start using with the spring-boot-starter-data-elasticsearch “Starter”.

## Connecting to Elasticsearch by REST clients
Elasticsearch ships two different REST clients that you can use to query a cluster: the "Low Level" client and the "High Level" client.

If you have the `org.elasticsearch.client:elasticsearch-rest-client` dependency on the classpath, Spring Boot will auto-configure and register a `RestClient` bean that by default targets `localhost:9200`. You can further tune how `RestClient` is configured, as shown in the following example:
```properties
spring.elasticsearch.rest.uris=https://search.example.com:9200
spring.elasticsearch.rest.username=user
spring.elasticsearch.rest.password=secret
```
You can also register an arbitrary number of beans that implement `RestClientBuilderCustomizer` for more advanced customizations. To take full control over the registration, define a `RestClient` bean.

If you have the `org.elasticsearch.client:elasticsearch-rest-high-level-client` dependency on the classpath, Spring Boot will auto-configure a `RestHighLevelClient`, which wraps any existing `RestClient` bean, reusing its HTTP configuration.

## Connecting to Elasticsearch by Using Jest
If you have `Jest` on the classpath, you can inject an auto-configured `JestClient` that by default targets `localhost:9200`. You can further tune how the client is configured, as shown in the following example:
```properties
spring.elasticsearch.jest.uris=https://search.example.com:9200
spring.elasticsearch.jest.read-timeout=10000
spring.elasticsearch.jest.username=user
spring.elasticsearch.jest.password=secret
```
You can also register an arbitrary number of beans that implement `HttpClientConfigBuilderCustomizer` for more advanced customizations. The following example tunes additional HTTP settings:
```java
static class HttpSettingsCustomizer implements HttpClientConfigBuilderCustomizer {

	@Override
	public void customize(HttpClientConfig.Builder builder) {
		builder.maxTotalConnection(100).defaultMaxTotalConnectionPerRoute(5);
	}

}
```

## Connecting to Elasticsearch by Using Spring Data
To connect to Elasticsearch, you must provide the address of one or more cluster nodes. The address can be specified by setting the `spring.data.elasticsearch.cluster-nodes` property to a comma-separated `host:port` list. With this configuration in place, an `ElasticsearchTemplate` or `TransportClient` can be injected like any other Spring bean, as shown in the following example:
```properties
spring.data.elasticsearch.cluster-nodes=localhost:9300
```
```java
@Component
public class MyBean {

	private final ElasticsearchTemplate template;

	public MyBean(ElasticsearchTemplate template) {
		this.template = template;
	}

	// ...

}
```
## Spring Data Elasticsearch Repositories
Spring Data includes repository support for Elasticsearch. As with the JPA repositories discussed earlier, the basic principle is that queries are constructed for you automatically based on method names.

In fact, both Spring Data JPA and Spring Data Elasticsearch share the same common infrastructure. You could take the JPA example from earlier and, assuming that `City` is now an Elasticsearch `@Document` class rather than a JPA `@Entity`, it works in the same way.

> For complete details of Spring Data Elasticsearch, refer to the [reference documentation](https://docs.spring.io/spring-data/elasticsearch/docs/).