package com.sap.slh.tax.client;

import java.util.concurrent.ExecutionException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpRemoteException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.AsyncRabbitTemplate;
import org.springframework.amqp.rabbit.AsyncRabbitTemplate.RabbitMessageFuture;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sap.slh.tax.model.TaxDetails;
import com.sap.slh.tax.model.TaxLine;

@Configuration
@Controller
@RequestMapping("/api/v1/tax/determine")
public class TaxDeterminationController {
	private static final Logger log = LoggerFactory.getLogger(TaxDeterminationController.class);

	@Autowired
	private AsyncRabbitTemplate template;

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody TaxLine onRootAccess(
			@Valid @RequestBody(required = true) final TaxDetails taxAttributesDeterminationRequest) {

		TopicExchange exchange = new TopicExchange("tax.webflux.reactor.TAXSERVICE2");

		MessageProperties messageProperties = new MessageProperties();
		messageProperties.setContentType("application/json");
		log.error("Tax determination request {}", JsonUtil.toJsonString(taxAttributesDeterminationRequest));
		Jackson2JsonMessageConverter converter = new Jackson2JsonMessageConverter();

		Message sentMsg = converter.toMessage(taxAttributesDeterminationRequest, messageProperties);

		log.info("Sent Message{}", sentMsg);
		Message receivedMessage = null;
		try {
			RabbitMessageFuture messageFuture = template.sendAndReceive(exchange.getName(), "tax.webflux.reactor.determine2", sentMsg);
			log.error("Received future{}",JsonUtil.toJsonString(messageFuture));
			receivedMessage = messageFuture.get();
			log.info("Received message: {}", receivedMessage);
		} catch (AmqpRemoteException | InterruptedException | ExecutionException e) {
			log.error("Exception occured in processing", e);
		}

		Object obj = converter.fromMessage(receivedMessage);
		log.info("Received object: {}", obj);
		return (TaxLine) obj;

	}

}