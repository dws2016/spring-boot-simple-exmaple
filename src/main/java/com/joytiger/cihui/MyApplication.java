package com.joytiger.cihui;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
@SpringBootApplication
@EnableScheduling
@ComponentScan
@ServletComponentScan
public class MyApplication{
	private Log log = LogFactory.getLog(MyApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(MyApplication.class, args);
	}
}
