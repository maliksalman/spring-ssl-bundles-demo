package com.example.sslbundlesdemo.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.client.RestClientSsl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class HeroServiceConfig {

    @Bean
    @Profile(value = "tls")
    public RestClient httpsRestClient(
            @Value("${base-url}") String baseUrl,
            RestClient.Builder builder,
            RestClientSsl ssl) {

        return builder
                .baseUrl(baseUrl)
                .apply(ssl.fromBundle("client"))
                .build();
    }

    @Bean
    @Profile(value = "!tls")
    public RestClient httpRestClient(
            @Value("${base-url}") String baseUrl,
            RestClient.Builder builder) {

        return builder
                .baseUrl(baseUrl)
                .build();
    }

    @Bean
    public HeroService heroService(RestClient client) {
        HttpServiceProxyFactory proxyFactory = HttpServiceProxyFactory
                .builderFor(RestClientAdapter.create(client))
                .build();
        return proxyFactory.createClient(HeroService.class);
    }
}
