package spring.webflux.oauth2.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import spring.webflux.oauth2.domain.ReachFiveSearchResponse;

@Component
public class WebClientChonJob {

    Logger logger = LoggerFactory.getLogger(WebClientChonJob.class);

    @Autowired
    private WebClient webClient;

    @Scheduled(fixedRate = 5000)
    public void logResourceServiceResponse() {

        webClient.get()
                .uri("/api/v2/users?filter=email==\"test-aa-1-pprod@yopmail.com\"")
                .attributes(ServerOAuth2AuthorizedClientExchangeFilterFunction.clientRegistrationId("provider-example"))
                .retrieve()
                .bodyToMono(ReachFiveSearchResponse.class)
                .flatMapIterable(resp -> resp.items)
                .subscribe(System.out::println);
    }

}
