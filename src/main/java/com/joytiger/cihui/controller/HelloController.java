package com.joytiger.cihui.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Controller
public class HelloController {

	private Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	@RequestMapping("/")
	public String  index(){
		logger.info("访问主页面！");
		return "index";
	}
	
	@RequestMapping("/hello")
	public String hello(){



		return "hello";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(){
		return "login";
	}
	

	
}
