package com.gymsystem.hibernate.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gymsystem.hibernate.dao.TrainingTypeDao;
import com.gymsystem.hibernate.model.TrainingType;

@Repository
@Transactional
public class TrainingTypeDaoImpl implements TrainingTypeDao {

	@Override
	public List<TrainingType> getAllTrainingTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TrainingType getTrainingTypeById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createTrainingType(TrainingType trainingType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTrainingType(TrainingType trainingType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTrainingType(long id) {
		// TODO Auto-generated method stub
		
	}
}