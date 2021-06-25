package com.katerynashydlovska.beltreview.controllers;

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

import com.katerynashydlovska.beltreview.models.LoginUser;
import com.katerynashydlovska.beltreview.models.Menu;
import com.katerynashydlovska.beltreview.models.User;
import com.katerynashydlovska.beltreview.services.AppService;


@Controller
public class AppController {
	@Autowired
    private AppService userServ;

    
    @GetMapping("/")
    public String index(Model model, @ModelAttribute("newUser") User user) {
//        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "register.jsp";
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
    	
        this.userServ.register(newUser, result);
        if(result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "register.jsp";
        }
        
        //if the form was filled out successfully, then create a cookie to keep track of this users id in session
        session.setAttribute("user_id", newUser.getId());
        return "redirect:/home";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
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
    	
    	List<Menu> allMenuItems = this.userServ.findAllMenuItems();
    	model.addAttribute("allMenuItems", allMenuItems);
    
        return "dashboard.jsp";
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.removeAttribute("user_id");
    	return "redirect:/";
    }
    
    //menu
    
    @GetMapping("/addItem")
    public String addNewitem(@ModelAttribute("menu")Menu menu) {
    	return "newItem.jsp";
    }
    
    @PostMapping("/create/menu")
    public String createNewMenuItem(@Valid @ModelAttribute("menu") Menu menu, BindingResult result, HttpSession session) {
    	if(result.hasErrors()) {
    		return "newItem.jsp";
    	}else {
    		//get the logged in user using session so that we can assign the logged in user as the uploader of the menu item
    		Long idOfLoggedinUser = (Long)session.getAttribute("user_id");
    		User loggedInUserObj = this.userServ.findOne(idOfLoggedinUser);
    		
    		//assign the menu's uploader to be the logged in user object
    		menu.setUploader(loggedInUserObj);
    		this.userServ.createMenuItem(menu);
    		return "redirect:/home";
    	}
    }
    
    @GetMapping("edit/{id}/menu")
    public String editMenuItem(@PathVariable("id")Long id, Model model) {
    	//retrieve a menu object using this id variable
    	Menu menu = this.userServ.findOneMenuItem(id);
    	//pass this menuObj to the edit page so the form can prepopulate with this menu objects information
    	model.addAttribute("menu", menu);
    	return "edit.jsp";
    }
    
    @PostMapping("/update/{id}/menu")
    public String updateMenuItem(@Valid @ModelAttribute("menu") Menu menu, BindingResult result, HttpSession session) {
    	if(result.hasErrors()) {
    		return "edit.jsp";
    	}else {
    		//get the logged in user using session so that we can assign the logged in user as the uploader of the menu item
    		Long idOfLoggedinUser = (Long)session.getAttribute("user_id");
    		User loggedInUserObj = this.userServ.findOne(idOfLoggedinUser);
    		
    		//assign the menu's uploader to be the logged in user object
    		menu.setUploader(loggedInUserObj);
    		this.userServ.createMenuItem(menu);
    		return "redirect:/home";
    	}
    }
    
    @GetMapping("/delete/{id}/menu")
    public String deleteItemFromMenu(@PathVariable("id")Long id) {
    	this.userServ.deleteOneMenuItem(id);
    	return "redirect:/home";
    }
    
    @GetMapping("/menu/{id}/info")
    public String showMenuItemInfo(@PathVariable("id")Long id, Model model) {
    	Menu menu = this.userServ.findOneMenuItem(id);
    	model.addAttribute("menu", menu);
    	return "showInfo.jsp";
    }
    
    

}
