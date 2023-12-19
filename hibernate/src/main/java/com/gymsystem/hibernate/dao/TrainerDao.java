package com.gymsystem.hibernate.dao;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.gymsystem.hibernate.model.Trainer;
import com.gymsystem.hibernate.model.Training;

@Repository
public interface TrainerDao {

	List<Trainer> getAllTrainers();

	Trainer getTrainerById(long id);

	void createTrainer(Long userId, Long trainingTypeId);

	void updateTrainer(Trainer trainer);

	void deleteTrainer(long id);

	Trainer getTrainerByUsername(String username, String password);

	void updateTrainerPassword(String username, String password, String newPassword);

	void updateTrainerProfile(String username, String password, Long newTrainingTypeId);
	
	void changeTrainerStatus(String username, String password);
	
	Set<Training> getTrainings(String username, String password);
}