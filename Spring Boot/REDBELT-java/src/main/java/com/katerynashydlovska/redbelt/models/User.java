package com.katerynashydlovska.redbelt.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotEmpty(message="Name is required!")
    @Size(min=1, max=30, message="Name must be between 1 and 30 characters")
    private String name;
	
	@NotEmpty(message="Email is required!")
    @Email(message="Please enter a valid email!")
    private String email;
	
	
	@NotEmpty(message="Password is required!")
    @Size(min=8, max=100, message="Password must be between 8 and 128 characters")
    private String password;
	
	@Transient
    @NotEmpty(message="Confirm Password is required!")
    @Size(min=8, max=100, message="Confirm Password must be between 8 and 128 characters")
    private String confirm;
	
	//one to many with menu
	@OneToMany(mappedBy="creator", fetch = FetchType.LAZY)
	private List<Idea> idiasCreated;
		
	
	//empty constructor
	public User() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	public List<Idea> getIdiasCreated() {
		return idiasCreated;
	}

	public void setIdiasCreated(List<Idea> idiasCreated) {
		this.idiasCreated = idiasCreated;
	}

	//loaded constructor
	public User(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

}
