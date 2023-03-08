package com.example.springboot;

import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

	@RequestMapping("/")
	public String index() {
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at:' HH:mm:ss z");
		Date date = new Date(System.currentTimeMillis());
 		// return formatter.format(date) + "Greetings from Spring Boot + Tanzu!";
		return "Greetings from Spring Boot + Tanzu on Zoom!";
	}

}
