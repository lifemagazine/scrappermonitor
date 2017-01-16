package com.lifemagazine.scrappermonitor.amqp;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;

import com.lifemagazine.scrappermonitor.service.CheckSchedInfoService;

@Configuration
@EnableAutoConfiguration
public class MsgQueueConfig {
	
	private static String host;
	private static int port;
	private static String username;
	private static String password;
	private static String virtualHost;
	public static String topicName; 
	public static String queueName;
	
	@Value("${spring.rabbitmq.host}")
	public void setHost(String ip) {
		host = ip;
	}
	@Value("${spring.rabbitmq.port}")
	public void setPort(int port0) {
		port = port0;
	}
	@Value("${spring.rabbitmq.username}")
	public void setUsername(String name) {
		username = name;
	}
	@Value("${spring.rabbitmq.password}")
	public void setPassword(String pass) {
		password = pass;
	}
	@Value("${spring.rabbitmq.virtual-host}")
	public void setVirtualHost(String vhost) {
		virtualHost = vhost;
	}
	@Value("${spring.rabbitmq.topicname}")
	public void setTopicName(String name) {
		topicName = name;
	}
	@Value("${spring.rabbitmq.queuename}")
	public void setQueueName(String name) {
		queueName = name;
	}
	
	@Bean
	Queue queue() {
		return new Queue(queueName, true);
	}
	
	@Bean
	TopicExchange exchange() {
		return new TopicExchange(topicName);
	}
	
	@Bean
	Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(queueName);
	}
	
	@Bean
	SimpleMessageListenerContainer container() {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory());
		container.setQueueNames(queueName);
		container.setMessageListener(new MessageReceiver(checkSchedInfoService()));
		container.setMessageConverter(jsonMessageConverter());
		container.setAcknowledgeMode(AcknowledgeMode.AUTO);
		return container;
	}
	
	@Bean
	ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory(host, port);
		connectionFactory.setUsername(username);
		connectionFactory.setPassword(password);
		connectionFactory.setVirtualHost(virtualHost);
		return connectionFactory;
	}
	
	@Bean
	MessageReceiver receiver() {
		return new MessageReceiver(checkSchedInfoService());
	}
	
	@Bean
	public MessageConverter jsonMessageConverter() {
		return new JsonMessageConverter();
	}
	
	@Bean
	public RabbitTemplate rabbitTemplate() {
		RabbitTemplate template = new RabbitTemplate(connectionFactory());
		template.setRoutingKey(topicName);
		template.setMessageConverter(jsonMessageConverter());
		return template;
	}
	
	@Bean
	public CheckSchedInfoService checkSchedInfoService() {
		CheckSchedInfoService bean = new CheckSchedInfoService();
		return bean;
	}
}
