package com.pd;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan("com.pd.mapper")
public class RunPdAPP{
	
	public static void main(String[] args) {
		SpringApplication.run(RunPdAPP.class, args);
	}

	/*
	import org.springframework.amqp.core.Queue;

	创建一个 spring 封装的 Queue 实例，
	封装队列信息： "orderQueue",true,false,false

	RabbitAutoConfiguration 自动配置类中，会自动发现Queue实例，
	根据其中封装的队列参数，连接rabbitmq来定义这个队列
	 */
	@Bean
	public Queue orderQueue() {
		return new Queue("orderQueue", true);
	}
}
