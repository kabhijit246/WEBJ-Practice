package com.beehyv.assignment.springAssignment;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	String s = "Hello %s";
	AtomicLong c = new AtomicLong();
	
	@RequestMapping("/welcome")
	public Hello hello(@RequestParam(value="value", defaultValue="World") String value) {
		return new Hello(c.incrementAndGet(), String.format(s, value));
	}
}
