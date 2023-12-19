package com.gymsystem.hibernate.facade;


import java.sql.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gymsystem.hibernate.model.Trainee;
import com.gymsystem.hibernate.model.Trainer;
import com.gymsystem.hibernate.model.Training;
import com.gymsystem.hibernate.model.User;
import com.gymsystem.hibernate.service.impl.TraineeServiceImpl;
import com.gymsystem.hibernate.service.impl.TrainerServiceImpl;
import com.gymsystem.hibernate.service.impl.TrainingServiceImpl;
import com.gymsystem.hibernate.service.impl.UserServiceImpl;



@Component
public class FacadeImpl {

    private final UserServiceImpl userService;
    private final TrainerServiceImpl trainerService;
    private final TraineeServiceImpl traineeService;
    private final TrainingServiceImpl trainingService;
    
    @Autowired
    public FacadeImpl(UserServiceImpl userService, TrainerServiceImpl trainerService, 
    		TraineeServiceImpl traineeService, TrainingServiceImpl trainingService) {
        this.userService = userService;
        this.trainerService = trainerService;
        this.traineeService = traineeService;
        this.trainingService = trainingService;
    }

    // User methods
	public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    public void createUser(User user) {
        userService.createUser(user);
    }

    public User getUserById(Long id) {
        return userService.getUserById(id);
    }

    public void updateUser(User user) {
        userService.updateUser(user);
    }

    public void deleteUser(Long id) {
        userService.deleteUser(id);
    }
    // Trainer methods
    public void createTrainer(Long userId, Long trainingTypeId) {
    	trainerService.createTrainer(userId, trainingTypeId);
    }
    
    public void deleteTrainer(Long id) {
        trainerService.deleteTrainer(id);
    }
    
    public Trainer getTrainerByUsername(String username, String password) {
        return trainerService.getTrainerByUsername(username, password);
    }
    
    public void updateTrainerPassword(String username, String password, String newPassword) {
		trainerService.updateTrainerPassword(username, password, newPassword);
	}
    
    public void updateTrainerProfile(String username, String password, Long newTrainingTypeId) {
		trainerService.updateTrainerProfile(username, password, newTrainingTypeId);
	}
    
    public void changeTrainerStatus(String username, String password) {
		trainerService.changeTrainerStatus(username, password);
	}
    
    public Set<Training> getTrainerTrainings(String username, String password) {
		return trainerService.getTrainings(username, password);
	}
    
    // Trainee methods
    public void createTrainee(Date dateOfBirth, String address, Long userId) {
    	traineeService.createTrainee(dateOfBirth, address, userId);
    }
    
    public void deleteTrainee(Long id) {
        traineeService.deleteTrainee(id);
    }

	public Trainee getTraineeByUsername(String username, String password) {
		return traineeService.getTraineeByUsername(username, password);
	}
    
	public void updateTraineePassword(String username, String password, String newPassword){
		traineeService.updateTraineePassword(username, password, newPassword);
	}

	public void updateTraineeProfile(String username, String password, Date date, String address) {
		traineeService.updateTraineeProfile(username, password, date, address);
	}

	public void changeTraineeStatus(String username, String password) {
		traineeService.changeTraineeStatus(username, password);
	}

	public Set<Training> getTraineeTrainings(String username, String password) {
		return traineeService.getTrainings(username, password);
	}
	
	public List<Trainer> getTrainersNotAssignedToATrainee(String username, String password){
		return traineeService.getTrainersNotAssignedToATrainee(username, password);
	}
	
	public void deleteTrainerFromATrainee(String username, String password, Long trainerId) {
		traineeService.deleteTrainer(username, password, trainerId);
	}
	
	// Training methods
	public void createTraining(String trainingName, Date trainingDate, Long trainingDuration, Long... optionalParams) {
		trainingService.createTraining(trainingName, trainingDate, trainingDuration, optionalParams);
	}
}