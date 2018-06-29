package com.masteringspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * SpringBoot启动类必须放到项目根目录下，也就是这里必须放到com.masteringspring包下
 * 与其他包（bean、controller）并列。
 */

//Spring boot2 直接使用@EnableAuthorzationServer虽然能够成功配置，但是其他的API都没有被Oauth机制保护起来，
//也就是说，不使用Oauth2.0 获取token也能调用接口获得数据，
//@EnableAuthorizationServer

//@EnableCaching would enable caching in a Spring Boot application.
@EnableCaching
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
}
