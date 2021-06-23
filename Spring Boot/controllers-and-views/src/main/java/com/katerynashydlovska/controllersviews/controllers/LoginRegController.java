package com.katerynashydlovska.controllersviews.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.katerynashydlovska.controllersviews.models.User;
import com.katerynashydlovska.controllersviews.models.UserLogin;
import com.katerynashydlovska.controllersviews.services.UserService;

@Controller
public class LoginRegController {
	@Autowired
    private UserService userServ;

    
    @GetMapping("/")
    public String index(Model model, @ModelAttribute("newUser") User user) {
//        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new UserLogin());
        return "register.jsp";
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
    	
        this.userServ.register(newUser, result);
        if(result.hasErrors()) {
            model.addAttribute("newLogin", new UserLogin());
            return "register.jsp";
        }
        
        //if the form was filled out successfully, then create a cookie to keep track of this users id in session
        session.setAttribute("user_id", newUser.getId());
        return "redirect:/home";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") UserLogin newLogin, 
            BindingResult result, Model model, HttpSession session) {
        User user = userServ.login(newLogin, result);
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "register.jsp";
        }
        session.setAttribute("user_id", user.getId());
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
    
        return "dashboard.jsp";
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.removeAttribute("user_id");
    	return "redirect:/";
    }
    
   

}
