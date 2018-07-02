package com.learn.mastering.spring.zipkintracingserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class ZipkinTracingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinTracingServerApplication.class, args);
	}
}
