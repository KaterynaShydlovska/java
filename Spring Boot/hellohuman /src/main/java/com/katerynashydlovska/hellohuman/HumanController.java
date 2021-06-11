package com.katerynashydlovska.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HumanController {
	@RequestMapping("/")
	    public String hello(@RequestParam(value="q", required=false) String searchQuery) {
		System.out.println(searchQuery);
		if(searchQuery == null) {
			return "Hello human!";
		}else {
			 return "Hello " + searchQuery;
			 }
	       }
}
