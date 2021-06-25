package com.katerynashydlovska.redbelt.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.katerynashydlovska.redbelt.models.Idea;
import com.katerynashydlovska.redbelt.models.User;
import com.katerynashydlovska.redbelt.models.UserLogin;
import com.katerynashydlovska.redbelt.services.AppService;

@Controller
public class AppController {
	
	@Autowired
    private AppService userServ;
	
	  @GetMapping("/")
	    public String index(Model model, @ModelAttribute("newUser") User user) {
	        model.addAttribute("newLogin", new UserLogin());
	        return "logAndReg.jsp";
	    }
	  
	  @PostMapping("/register")
	    public String register(@Valid @ModelAttribute("newUser") User newUser, 
	            BindingResult result, Model model, HttpSession session) {
	    	
	        this.userServ.register(newUser, result);
	        if(result.hasErrors()) {
	            model.addAttribute("newLogin", new UserLogin());
	            return "logAndReg.jsp";
	        }
	        
	        session.setAttribute("user_id", newUser.getId());
	        return "redirect:/home";
	    }
	  
	  @GetMapping("/home")
	    public String dashboard(HttpSession session, Model model) {
	    	if(session.getAttribute("user_id") == null) {
	    		return "redirect:/";
	    	}
	    	Long loggetuserId = (Long)session.getAttribute("user_id");
	    	User getOneUserInfo = this.userServ.findOne(loggetuserId);
	    	model.addAttribute("loggetdUser", getOneUserInfo);
	    	
	    	List<Idea> allIdeas = this.userServ.findAllIdeas();
	    	model.addAttribute("allIdeas", allIdeas);
	    
	        return "ideas.jsp";
	    }
	  
	    @PostMapping("/login")
	    public String login(@Valid @ModelAttribute("newLogin") UserLogin newLogin, 
	            BindingResult result, Model model, HttpSession session) {
	        User user = userServ.login(newLogin, result);
	        if(result.hasErrors()) {
	            model.addAttribute("newUser", new User());
	            return "logAndReg.jsp";
	        }
	        session.setAttribute("user_id", user.getId());
	        return "redirect:/home";
	    }
	    
	    @GetMapping("//addNewIdea")
	    public String addNewIdea(@ModelAttribute("idea")Idea idea) {
	    	return "newIdea.jsp";
	    }
	    
	    @PostMapping("/create/idea")
	    public String createNewIdea(@Valid @ModelAttribute("idea") Idea idea, BindingResult result, HttpSession session) {
	    	if(result.hasErrors()) {
	    		return "newIdea.jsp";
	    	}else {
	    		
	    		Long idOfLoggedinUser = (Long)session.getAttribute("user_id");
	    		User loggedInUserObj = this.userServ.findOne(idOfLoggedinUser);
	    		
	    		
	    		idea.setCreator(loggedInUserObj);
	    		this.userServ.createIdea(idea);
	    		return "redirect:/home";
	    	}
	    }
	    
	    @GetMapping("/idea/{id}")
	    public String showOneIdea(@PathVariable("id")Long id, Model model) {
	    	Idea idea = this.userServ.findOneIdea(id);
	    	model.addAttribute("idea", idea);
	    	return "showOneIdea.jsp";
	    }
	    
	    @GetMapping("edit/{id}")
	    public String editIdea(@PathVariable("id")Long id, Model model) {
	    	Idea idea = this.userServ.findOneIdea(id);
	    	model.addAttribute("idea", idea);
	    	return "editIdea.jsp";
	    }
	    
	    @PostMapping("/update/{id}")
	    public String updateIdea(@Valid @ModelAttribute("idea") Idea idea, BindingResult result, HttpSession session) {
	    	if(result.hasErrors()) {
	    		return "editIdea.jsp";
	    	}else {
	    		Long idOfLoggedinUser = (Long)session.getAttribute("user_id");
	    		User loggedInUserObj = this.userServ.findOne(idOfLoggedinUser);
	    		
	    		
	    		idea.setCreator(loggedInUserObj);
	    		this.userServ.createIdea(idea);
	    		return "redirect:/home";
	    	}
	    }
	    
	    @GetMapping("/delete/{id}")
	    public String deleteOneIdea(@PathVariable("id")Long id) {
	    	this.userServ.deleteOneIdea(id);
	    	return "redirect:/home";
	    }
	    
	    @GetMapping("/logout")
	    public String logout(HttpSession session) {
	    	session.removeAttribute("user_id");
	    	return "redirect:/";
	    }
	  

}
