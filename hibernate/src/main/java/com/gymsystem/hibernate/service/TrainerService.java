package com.gymsystem.hibernate.service;

import java.util.List;
import java.util.Set;

import com.gymsystem.hibernate.model.Trainer;
import com.gymsystem.hibernate.model.Training;

public interface TrainerService {
	
	public void createTrainer(Long userId, Long trainingTypeId);
	
	public void updateTrainer(Trainer trainer);
	
	public void deleteTrainer(Long id);
	
	public Trainer getTrainerById(Long id);
	
	public List<Trainer> getAllTrainers();

	Trainer getTrainerByUsername(String username, String password);

	void updateTrainerPassword(String username, String password, String newPassword);

	void updateTrainerProfile(String username, String password, Long newTrainingTypeId);
	
	void changeTrainerStatus(String username, String password);
	
	Set<Training> getTrainings(String username, String password);
}