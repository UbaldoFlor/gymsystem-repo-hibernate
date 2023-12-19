package com.gymsystem.hibernate.service;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import com.gymsystem.hibernate.model.Trainee;
import com.gymsystem.hibernate.model.Trainer;
import com.gymsystem.hibernate.model.Training;

public interface TraineeService {
	
	public void createTrainee(Date dateOfBirth, String address, Long userId);
	
	public void updateTraineePassword(String username, String password, String newPassword);
	
	public void deleteTrainee(Long id);
	
	public Trainee getTraineeById(Long id);
	
	public List<Trainee> getAllTrainees();

	public Trainee getTraineeByUsername(String username, String password);

	public void updateTraineeProfile(String username, String password, Date date, String address);
	
	public void changeTraineeStatus(String username, String password);
	
	public Set<Training> getTrainings(String username, String password);
	
	List<Trainer> getTrainersNotAssignedToATrainee(String username, String password);
	
	void deleteTrainer(String username, String password, Long trainerId);
}