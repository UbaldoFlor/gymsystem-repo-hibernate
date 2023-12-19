package com.gymsystem.hibernate;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.gymsystem.hibernate.facade.FacadeImpl;
import com.gymsystem.hibernate.model.Trainer;
import com.gymsystem.hibernate.model.Training;
import com.gymsystem.hibernate.model.Trainee;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        FacadeImpl facade = context.getBean(FacadeImpl.class);
        
        // Invoke facade methods

        // Create a Trainer profile
        facade.createTrainer(3L, 2L);
        
        // Create Trainee profile
        Date date = Date.valueOf("2023-12-18");
        facade.createTrainee(date, "New York City", 3L);
        
        // Select Trainer profile by username
        Trainer trainer = facade.getTrainerByUsername("emily.brown", "password4");
        System.out.println("Trainer ID: " + trainer.getId());
        System.out.println("Trainer Specialization: " + trainer.getTrainingType().getTrainingTypeName());
        System.out.println("User ID: " + trainer.getUser().getId());
       
        // Select Trainee profile by username
        Trainee trainee = facade.getTraineeByUsername("michael.johnson", "password3");
        System.out.println("Trainee ID: " + trainee.getId());
        System.out.println("Trainee DOB: " + trainee.getDateOfBirth());
        System.out.println("Trainee Address: " + trainee.getAddress());
        System.out.println("Trainee User ID: " + trainee.getUser().getId());

        // Trainee password change
        facade.updateTraineePassword("emily.brown", "password4", "n3wp4ssw0rd");
        
        // Trainer password change
        facade.updateTrainerPassword("john.doe", "password1", "r4np4ssw0rd");
        
        // Update trainer profile
        facade.updateTrainerProfile("emily.brown", "n3wp4ssw0rd", 3L);
        
        // Update trainee profile
        Date date2 = Date.valueOf("1999-09-11");
        facade.updateTraineeProfile("michael.johnson", "password3", date2, "New address in Mexico");
        
        // Activate/de-activate trainee
        facade.changeTraineeStatus("emily.brown", "n3wp4ssw0rd");
        
        // Activate/de-activate trainer        
        facade.changeTrainerStatus("michael.johnson", "password3");
        
        // Get trainee trainings list
        Set<Training> traineeTrainings = facade.getTraineeTrainings("emily.brown", "n3wp4ssw0rd");
        for(Training training : traineeTrainings) {
        	System.out.println(training);
        }
        
        // Get trainer trainings list
        Set<Training> trainerTrainings = facade.getTrainerTrainings("daniel.harris", "password11");
        for(Training training : trainerTrainings) {
        	System.out.println(training);
        }
        
        //Add Training
        Date date3 = Date.valueOf("2023-10-15");
        facade.createTraining("New amazing training", date3, 180L);
        facade.createTraining("New test training", date3, 60L, 1L, 3L, 4L);
        
        
        // Get not assigned on specific trainee active trainers list.
        
        List<Trainer> trainers = facade.getTrainersNotAssignedToATrainee("emily.brown", "n3wp4ssw0rd");
        for(Trainer trainer2 : trainers) {
        	System.out.println(trainer2);
        }
        
        // Update Tranee's trainers list
        facade.deleteTrainerFromATrainee("emily.brown", "n3wp4ssw0rd", 3L);
        
        // Close the application context
        ((AnnotationConfigApplicationContext) context).close();
    }
}