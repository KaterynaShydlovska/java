package com.katerynashydlovska.survey;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class SurveyController {
	@RequestMapping("/")
	public String dashboard() {
		return "dashboard.jsp";
		}
	
	@RequestMapping(value ="/info", method=RequestMethod.POST)
	public String userInfo(@RequestParam(value="fname") String name, @RequestParam(value="location") String location, @RequestParam(value="language") String language, @RequestParam(value="comment") String comment, Model model ) {
		model.addAttribute("name", name);
		model.addAttribute("location", location);
		model.addAttribute("language", language);
		model.addAttribute("comment", comment);
		return "info.jsp";
		}

}
