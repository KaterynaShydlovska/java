package com.katerynashydlovska.mvc.services;
import java.util.List;
import org.springframework.stereotype.Service;

import com.katerynashydlovska.mvc.models.Language;
import com.katerynashydlovska.mvc.repositories.LanguageRepository;


@Service
public class LanguageService {
private final LanguageRepository languageRepository;
    
    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }
    
    
    // returns all the languages
    public List<Language> allLanguages() {
        return this.languageRepository.findAll();
    }
    // creates a language
    public Language createLanguage(Language l) {
        return languageRepository.save(l);
    }
    
  //get one language
  	public Language getOneLanguage(Long id) {
  		return this.languageRepository.findById(id).orElse(null);
  	}
  	
  	
  	//update a language information
  	public Language updateLanguage(Language l) {
  		return this.languageRepository.save(l);
  	}
  	
//  	delete a language
	public void deleteLanguage(Long id) {
		this.languageRepository.deleteById(id);
  		
  	}
  	

}
