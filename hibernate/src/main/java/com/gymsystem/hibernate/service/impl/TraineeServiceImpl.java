package com.gymsystem.hibernate.service.impl;


import java.sql.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gymsystem.hibernate.dao.TraineeDao;
import com.gymsystem.hibernate.model.Trainee;
import com.gymsystem.hibernate.model.Trainer;
import com.gymsystem.hibernate.model.Training;
import com.gymsystem.hibernate.service.TraineeService;


@Service
public class TraineeServiceImpl implements TraineeService{

	@Autowired
	TraineeDao traineeDao;
	
	@Override
	public void createTrainee(Date dateOfBirth, String address, Long userId) {
		traineeDao.createTrainee(dateOfBirth, address, userId);
	}

	@Override
	public void updateTraineePassword(String username, String password, String newPassword) {
		traineeDao.updateTraineePassword(username, password, newPassword);
	}

	@Override
	public void deleteTrainee(Long id) {
		traineeDao.deleteTrainee(id);;
	}

	@Override
	public Trainee getTraineeById(Long id) {
		return traineeDao.getTraineeById(id);
	}

	@Override
	public List<Trainee> getAllTrainees() {
		return traineeDao.getAllTrainees();
	}

	@Override
	public Trainee getTraineeByUsername(String username, String password) {
		return traineeDao.getTraineeByUsername(username, password);
	}

	@Override
	public void updateTraineeProfile(String username, String password, Date date, String address) {
		traineeDao.updateTraineeProfile(username, password, date, address);
	}

	@Override
	public void changeTraineeStatus(String username, String password) {
		traineeDao.changeTraineeStatus(username, password);
	}

	@Override
	public Set<Training> getTrainings(String username, String password) {
		return traineeDao.getTrainings(username, password);
	}

	@Override
	public List<Trainer> getTrainersNotAssignedToATrainee(String username, String password) {
		return traineeDao.getTrainersNotAssignedToATrainee(username, password);
	}

	@Override
	public void deleteTrainer(String username, String password, Long trainerId) {
		traineeDao.deleteTrainer(username, password, trainerId);
	}
}