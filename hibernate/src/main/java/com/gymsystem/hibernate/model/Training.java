package com.gymsystem.hibernate.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "training")
public class Training {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
    private Long id;
	
	@ManyToOne
    @JoinColumn(name="TraineeID")
    private Trainee trainee;
	
	@ManyToOne
    @JoinColumn(name="TrainerID")
    private Trainer trainer;
	
	@NotNull
    @Column(name="TrainingName")
    private String trainingName;
	
	@ManyToOne
    @JoinColumn(name="TrainingTypeID")
    private TrainingType trainingType;
	
	@NotNull
	@Column(name="TrainingDate")
	private Date trainingDate;
	
	@NotNull
	@Column(name="TrainingDuration")
	private Long trainingDuration;
	
	//getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Trainee getTrainee() {
		return trainee;
	}

	public void setTrainee(Trainee trainee) {
		this.trainee = trainee;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	public String getTrainingName() {
		return trainingName;
	}

	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}

	public TrainingType getTrainingType() {
		return trainingType;
	}

	public void setTrainingType(TrainingType trainingType) {
		this.trainingType = trainingType;
	}

	public Date getTrainingDate() {
		return trainingDate;
	}

	public void setTrainingDate(Date trainingDate) {
		this.trainingDate = trainingDate;
	}
	
	public Long getTrainingDuration() {
		return trainingDuration;
	}

	public void setTrainingDuration(Long trainingDuration) {
		this.trainingDuration = trainingDuration;
	}
	
	@Override
	public String toString() {
		return String.valueOf(this.id) + "," +
				String.valueOf(this.trainee.getId()) + "," +
				String.valueOf(this.trainer.getId()) + "," +
				this.trainingName + "," +
				String.valueOf(this.trainingType.getId()) + "," +
				String.valueOf(this.trainingDate) + "," +
				String.valueOf(this.trainingDuration);
	}
}