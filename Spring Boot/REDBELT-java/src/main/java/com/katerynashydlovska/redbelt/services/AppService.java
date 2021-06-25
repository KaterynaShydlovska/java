package com.katerynashydlovska.redbelt.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.katerynashydlovska.redbelt.models.Idea;
import com.katerynashydlovska.redbelt.models.User;
import com.katerynashydlovska.redbelt.models.UserLogin;
import com.katerynashydlovska.redbelt.repositories.IdeaRepository;
import com.katerynashydlovska.redbelt.repositories.UserRepository;

@Service
public class AppService {
	@Autowired
    private UserRepository userRepo;
	
	@Autowired
	private IdeaRepository ideaRepo;
    
    
	
	//for user 
	
    public User register(User newUser, BindingResult result) {
    	
        if(this.userRepo.findByEmail(newUser.getEmail()).isPresent()) {
            result.rejectValue("email", "Unique", "This email is already in use!");
        }
        if(!newUser.getPassword().equals(newUser.getConfirm())) {
            result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
        }
        if(result.hasErrors()) {
            return null;
        } else {
            String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
            newUser.setPassword(hashed);
            return userRepo.save(newUser);
        }
    }
    
    public User login(UserLogin newLogin, BindingResult result) {
        if(result.hasErrors()) {
            return null;
        }
        Optional<User> potentialUser = userRepo.findByEmail(newLogin.getEmail());
        if(!potentialUser.isPresent()) {
            result.rejectValue("email", "Unique", "Unknown email!");
            return null;
        }
        User user = potentialUser.get();
        if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
            result.rejectValue("password", "Matches", "Invalid Password!");
        }
        if(result.hasErrors()) {
            return null;
        } else {
            return user;
        }
    }
    
    public User findOne(Long id) {
    	return this.userRepo.findById(id).orElse(null);
    }
    
    
    
    
    //for Ideas
    
    public List<Idea> findAllIdeas(){
    	return (List<Idea>)this.ideaRepo.findAll();
    }
    
    public Idea createIdea(Idea i) {
    	return this.ideaRepo.save(i);
    	
    }
    
    public Idea findOneIdea(Long id) {
    	return this.ideaRepo.findById(id).orElse(null);
    }
    
    public void deleteOneIdea(Long id) {
    	this.ideaRepo.deleteById(id);
    }

}
