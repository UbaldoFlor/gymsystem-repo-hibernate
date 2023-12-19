package com.gymsystem.hibernate.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "trainingtype")
public class TrainingType {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
    private Long id;
	
	@NotNull
    @Size(min = 1, max = 255)
    @Column(name = "TrainingTypeName")
    private String trainingTypeName;
	
	@OneToMany(mappedBy = "trainingType")
    private List<Trainer> trainers = new ArrayList<>();
	
	@OneToMany(mappedBy = "trainingType")
	private List<Training> trainings = new ArrayList<>();
	
	//getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTrainingTypeName() {
		return trainingTypeName;
	}

	public void setTrainingTypeName(String trainingTypeName) {
		this.trainingTypeName = trainingTypeName;
	}
	
	public List<Trainer> getTrainers() {
		return trainers;
	}

	public void setTrainers(List<Trainer> trainers) {
		this.trainers = trainers;
	}
	
	public List<Training> getTrainings() {
		return trainings;
	}

	public void setTrainings(List<Training> trainings) {
		this.trainings = trainings;
	}

	@Override
	public String toString() {
		return String.valueOf(this.id) + "," +
				this.trainingTypeName;
	}
}