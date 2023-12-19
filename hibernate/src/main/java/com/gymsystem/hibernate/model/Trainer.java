package com.gymsystem.hibernate.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "trainer")
public class Trainer {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
    private Long id;

	@ManyToOne
    @JoinColumn(name="Specialization")
    private TrainingType trainingType;
    
    @OneToOne
    @JoinColumn(name="UserID")
    private User user;
    
    @OneToMany(mappedBy = "trainer", fetch = FetchType.EAGER)
    private Set<Training> trainings = new HashSet<>();

    public Trainer(){
    	
    }
    
    public Trainer(Long specializationId, Long userId) {
    	this.trainingType.setId(specializationId);
    	this.user.setId(userId);
    }
    
    //getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TrainingType getTrainingType() {
	    return trainingType;
	}

	public void setTrainingType(TrainingType trainingType) {
	    this.trainingType = trainingType;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Set<Training> getTrainings() {
		return trainings;
	}

	public void setTrainings(Set<Training> trainings) {
		this.trainings = trainings;
	}

	@Override
	public String toString() {
		return String.valueOf(this.id) + "," +
				this.trainingType.getId() + "," +
				this.user.getId();
	}
}