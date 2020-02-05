package config;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    @Bean
    public HttpClient httpClient() {
        return HttpClientBuilder.create().build();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
