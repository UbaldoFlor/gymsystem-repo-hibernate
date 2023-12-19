package com.gymsystem.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

	@NotNull
    @Size(min = 1, max = 255)
    @Column(name = "FirstName")
    private String firstName;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "LastName")
    private String lastName;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Username", unique = true) // username must be unique
    private String username;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Password")
    private String password;

    @Column(name = "IsActive")
    private Boolean isActive;
    
    @OneToOne(mappedBy = "user")
    private Trainer trainer;
    
    @OneToOne(mappedBy = "traineeUser")
    private Trainee trainee;
    
    public User() {
    	
    }
    
    public User(String firstName, String lastName, boolean isActive){
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.isActive = isActive;
    }

    // getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	public Trainee getTrainee() {
		return trainee;
	}

	public void setTrainee(Trainee trainee) {
		this.trainee = trainee;
	}
	
	@Override
	public String toString() {
		return String.valueOf(this.id) + "," +
				this.firstName + "," +
				this.lastName + "," +
				this.username + "," +
				this.password + "," +
				String.valueOf(this.isActive);
	}
}