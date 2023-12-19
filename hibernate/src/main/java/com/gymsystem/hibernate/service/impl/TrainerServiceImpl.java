package com.gymsystem.hibernate.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gymsystem.hibernate.dao.TrainerDao;
import com.gymsystem.hibernate.model.Trainer;
import com.gymsystem.hibernate.model.Training;
import com.gymsystem.hibernate.service.TrainerService;

@Service
public class TrainerServiceImpl implements TrainerService{
	
	@Autowired
	TrainerDao trainerDao;
	
	@Override
	public void createTrainer(Long userId, Long trainingTypeId) {
		trainerDao.createTrainer(userId, trainingTypeId);
	}

	@Override
	public void updateTrainer(Trainer trainer) {
		trainerDao.updateTrainer(trainer);
	}

	@Override
	public void deleteTrainer(Long id) {
		trainerDao.deleteTrainer(id);;
	}

	@Override
	public Trainer getTrainerById(Long id) {
		return trainerDao.getTrainerById(id);
	}

	@Override
	public List<Trainer> getAllTrainers() {
		return trainerDao.getAllTrainers();
	}
	
	@Override
	public Trainer getTrainerByUsername(String username, String password) {
        return trainerDao.getTrainerByUsername(username, password);
    }

	@Override
	public void updateTrainerPassword(String username, String password, String newPassword) {
		trainerDao.updateTrainerPassword(username, password, newPassword);
	}

	@Override
	public void updateTrainerProfile(String username, String password, Long newTrainingTypeId) {
		trainerDao.updateTrainerProfile(username, password, newTrainingTypeId);
	}

	@Override
	public void changeTrainerStatus(String username, String password) {
		trainerDao.changeTrainerStatus(username, password);
	}

	@Override
	public Set<Training> getTrainings(String username, String password) {
		return trainerDao.getTrainings(username, password);
	}
	
}