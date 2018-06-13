package com.erik.counter;

import javax.servlet.http.HttpSession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class CounterApplication {
	
	public static void main(String[] args) {
		System.out.println("main function");
		SpringApplication.run(CounterApplication.class, args);
	}
	@RequestMapping("/")
	public String increment(HttpSession session) {
		System.out.println("homepage");
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		else {
			int this_count = Integer.valueOf(session.getAttribute("count").toString());
			session.setAttribute("count", ++this_count);
		}
		return "home.jsp";
	}
	
	@RequestMapping("/count")
	public String show(HttpSession session) {
		System.out.println("countpage");
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		else {
			//int this_count = Integer.valueOf(session.getAttribute("count").toString());
		}
		return "counter.jsp";
	}
}	
