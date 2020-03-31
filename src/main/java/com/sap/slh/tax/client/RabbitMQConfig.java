package com.sap.slh.tax.client;

import org.springframework.amqp.rabbit.AsyncRabbitTemplate;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

	@Bean
	public ConnectionFactory connectionFactory() {
	return new CachingConnectionFactory();
	}
	
	@Bean
	public AsyncRabbitTemplate asyncRabbitTemplate(RabbitTemplate rabbitTemplate)
	{
		rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
		return new AsyncRabbitTemplate(rabbitTemplate);
	}

}