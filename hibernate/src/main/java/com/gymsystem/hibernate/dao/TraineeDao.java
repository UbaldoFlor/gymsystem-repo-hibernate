package com.gymsystem.hibernate.dao;


import java.sql.Date;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.gymsystem.hibernate.model.Trainee;
import com.gymsystem.hibernate.model.Trainer;
import com.gymsystem.hibernate.model.Training;

@Repository
public interface TraineeDao {

	void deleteTrainee(long id);

	void updateTraineePassword(String username, String password, String newPassword);

	void createTrainee(Date dateOfBirth, String address, Long userId);

	Trainee getTraineeById(long id);

	List<Trainee> getAllTrainees();

	Trainee getTraineeByUsername(String username, String password);

	void updateTraineeProfile(String username, String password, Date date, String address);
	
	void changeTraineeStatus(String username, String password);
	
	Set<Training> getTrainings(String username, String password);
	
	List<Trainer> getTrainersNotAssignedToATrainee(String username, String password);
	
	void deleteTrainer(String username, String password, Long trainerId);
	
}