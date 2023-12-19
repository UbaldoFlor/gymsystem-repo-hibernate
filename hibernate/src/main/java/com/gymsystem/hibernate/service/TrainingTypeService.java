package com.gymsystem.hibernate.service;

import java.util.List;

import com.gymsystem.hibernate.model.TrainingType;

public interface TrainingTypeService {
	
	public void createTrainingType(TrainingType trainingType);
	
	public void updateTrainingType(TrainingType trainingType);
	
	public void deleteTrainingType(Long id);
	
	public TrainingType getTrainingTypeById(Long id);
	
	public List<TrainingType> getAllTTrainingTypes();
}