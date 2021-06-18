package com.katerynashydlovska.dojoninjas;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.katerynashydlovska.dojoninjas.models.Dojo;
import com.katerynashydlovska.dojoninjas.models.Ninja;
import com.katerynashydlovska.dojoninjas.services.DojoNinjaService;

@Controller
public class DojoNinjaController {
	private final DojoNinjaService appService;
	
	public DojoNinjaController(DojoNinjaService appService) {
		this.appService = appService;
	}
	

	@GetMapping("/")
	public String home(@ModelAttribute("dojo") Dojo dojo, Model model) {
	return "home.jsp";
}
	@PostMapping("/dojo/create")
	public String create(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "home.jsp";
		}else {
			this.appService.create(dojo);
			return "redirect:/";
		}
		
	}
	
	@GetMapping("/ninja/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> allDojos = this.appService.findAllDojos();
		model.addAttribute("allDojos", allDojos);
		return "NewNinja.jsp";
	}
	
	@PostMapping("/ninja/create")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Dojo> allDojos = this.appService.findAllDojos();
			model.addAttribute("allDojos", allDojos);
			return "NewNinja.jsp";
		}else {
			this.appService.createNinja(ninja);
			List<Dojo> allDojos = this.appService.findAllDojos();
			model.addAttribute("allDojos", allDojos);
			return "NewNinja.jsp";
		}
	}
	
	@GetMapping("/dojos/{id}")
	public String getDojo(@PathVariable("id") Long id, Model model) {
		Dojo d = this.appService.getDojo(id);
		model.addAttribute("dojo", d);
		return "dojoPage.jsp";
	}
	
	


	
}
