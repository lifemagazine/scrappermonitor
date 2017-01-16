package com.lifemagazine.scrappermonitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ScheduledExecutorFactoryBean;


@SpringBootApplication
@EnableScheduling
public class TradlinxScrapperMonitorApplication {
	
	@Bean
	public ScheduledExecutorFactoryBean scheduledExecutorService() {
		ScheduledExecutorFactoryBean bean = new ScheduledExecutorFactoryBean();
		bean.setPoolSize(3);
		return bean;
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(TradlinxScrapperMonitorApplication.class, args);
	}
}
