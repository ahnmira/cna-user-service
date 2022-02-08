package com.example.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class UserRestApp {

	public static void main(String[] args) {
		SpringApplication.run(UserRestApp.class, args);
	}
	
    @Bean
    @LoadBalanced  //RestTemplate 로 직접 URL을 호출하지 않고 Eureka 에 있는 인스턴스를 discovery 하여 포트 번호와 uri 를 자동으로 매핑해준다
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
