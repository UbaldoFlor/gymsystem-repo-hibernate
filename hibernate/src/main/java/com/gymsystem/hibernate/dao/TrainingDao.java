package com.gymsystem.hibernate.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.gymsystem.hibernate.model.Training;

@Repository
public interface TrainingDao {

	List<Training> getAllTrainings();

	Training getTrainingById(long id);

	void createTraining(String trainingName, Date trainingDate, Long trainingDuration, Long... optionalParams);

	void updateTraining(Training training);

	void deleteTraining(long id);
}