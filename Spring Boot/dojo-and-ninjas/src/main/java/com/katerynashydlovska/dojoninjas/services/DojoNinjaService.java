package com.katerynashydlovska.dojoninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.katerynashydlovska.dojoninjas.models.Dojo;
import com.katerynashydlovska.dojoninjas.models.Ninja;
import com.katerynashydlovska.dojoninjas.repositories.DojoRepository;
import com.katerynashydlovska.dojoninjas.repositories.NinjaRepository;


@Service
public class DojoNinjaService  {

	private final DojoRepository dojoRepo;
	private final NinjaRepository ninjaRepo;
	
	public DojoNinjaService(DojoRepository dojoRepo, NinjaRepository ninjaRepo) {
		this.dojoRepo = dojoRepo;
		this.ninjaRepo = ninjaRepo;
	}
	
	//get all 
	public List<Dojo> findAllDojos(){
		return (List<Dojo>)this.dojoRepo.findAll();
	}
	
	//create dojo
	public Dojo create(Dojo d) {
		return this.dojoRepo.save(d);
		
	}
	
	//create ninja
	public Ninja createNinja(Ninja n) {
		return this.ninjaRepo.save(n);
	}
	//get dojo by id
	public Dojo getDojo(Long id) {
		return this.dojoRepo.findById(id).orElse(null);
	}
}
