package com.gymsystem.hibernate.service;

import java.sql.Date;
import java.util.List;

import com.gymsystem.hibernate.model.Training;

public interface TrainingService {
	
	public void updateTraining(Training Training);
	
	public void deleteTraining(Long id);
	
	public Training getTrainingById(Long id);
	
	public List<Training> getAllTTrainings();
	
	void createTraining(String trainingName, Date trainingDate, Long trainingDuration, Long... optionalParams);
}