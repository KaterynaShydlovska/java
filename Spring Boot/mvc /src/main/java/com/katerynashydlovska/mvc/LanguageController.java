package com.katerynashydlovska.mvc;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.katerynashydlovska.mvc.models.Language;
import com.katerynashydlovska.mvc.services.LanguageService;

@Controller
public class LanguageController {
	private final LanguageService languageService;
	
	
	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@RequestMapping("/languages")
	public String home(Model model, @ModelAttribute("language") Language language) {
		List<Language> allLanguages = this.languageService.allLanguages();
		model.addAttribute("allLanguages", allLanguages);
		
		return "Language.jsp";
	}
	@GetMapping("/getOne/{id}")
	public String getOne(@PathVariable("id") Long id, Model model) {
		Language l = this.languageService.getOneLanguage(id);
		model.addAttribute("language", l);
		return "Show.jsp";
	}
	
	@PostMapping("/language/create")
	public String create(Model model, @Valid @ModelAttribute("language") Language language, BindingResult result) {
		if (result.hasErrors()) {
			List<Language> allLanguages = this.languageService.allLanguages();
			System.out.println(allLanguages);
			System.out.println("*******");
			model.addAttribute("allLanguages", allLanguages);
            return "Language.jsp";
        } else {
            this.languageService.createLanguage(language);
            return "redirect:/languages";
        }
		
	}
	
	@GetMapping("/language/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Language l = this.languageService.getOneLanguage(id);
		model.addAttribute("language", l);
		return "Update.jsp";
	}
	
	@PostMapping("/language/{id}/update")
	public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if (result.hasErrors()) {
            return "Update.jsp";
        } else {
        	this.languageService.updateLanguage(language);

            return "redirect:/languages";
        }	
}
	@GetMapping("/language/{id}/delete")
	public String delete(@PathVariable("id") Long id) {
		this.languageService.deleteLanguage(id);
		return "redirect:/languages";
		}
}
