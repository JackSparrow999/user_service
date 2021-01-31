package com.ykn.user_service.client;

import com.ykn.user_service.dtos.article.SearchRequest;
import com.ykn.user_service.dtos.article.SearchResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;

@Component
public class ArticlesServiceClient {

    WebClient webclient;

    @Value("${search.baseUrl}")
    String baseUrl;

    @PostConstruct
    public void init(){
        webclient = WebClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public SearchResponse search(SearchRequest searchRequest){
        return webclient.post()
                .uri(uri -> uri.path("/api/v1/search").build())
                .body(Mono.just(searchRequest), SearchRequest.class)
                .retrieve()
                .bodyToMono(SearchResponse.class)
                .block();
    }

}
