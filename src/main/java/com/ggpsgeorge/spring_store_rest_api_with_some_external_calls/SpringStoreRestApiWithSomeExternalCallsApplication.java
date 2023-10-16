package com.ggpsgeorge.spring_store_rest_api_with_some_external_calls;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringStoreRestApiWithSomeExternalCallsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringStoreRestApiWithSomeExternalCallsApplication.class, args);
	}

    @Bean
    public RestTemplate getRestTemplate(){ return new RestTemplate(); }

}
