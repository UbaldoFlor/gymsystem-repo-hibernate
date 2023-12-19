package com.gymsystem.hibernate.service.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gymsystem.hibernate.dao.TrainingDao;
import com.gymsystem.hibernate.model.Training;
import com.gymsystem.hibernate.service.TrainingService;

@Service
public class TrainingServiceImpl implements TrainingService{
	
	@Autowired
	TrainingDao trainingDao;

	@Override
	public void updateTraining(Training training) {
		trainingDao.updateTraining(training);
	}

	@Override
	public void deleteTraining(Long id) {
		trainingDao.deleteTraining(id);;
	}

	@Override
	public Training getTrainingById(Long id) {
		return trainingDao.getTrainingById(id);
	}

	@Override
	public List<Training> getAllTTrainings() {
		return trainingDao.getAllTrainings();
	}

	@Override
	public void createTraining(String trainingName, Date trainingDate, Long trainingDuration, Long... optionalParams) {
		trainingDao.createTraining(trainingName, trainingDate, trainingDuration, optionalParams);
	}
}