package com.gymsystem.hibernate.dao.impl;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Predicate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gymsystem.hibernate.dao.TraineeDao;
import com.gymsystem.hibernate.model.Trainee;
import com.gymsystem.hibernate.model.Trainer;
import com.gymsystem.hibernate.model.Training;
import com.gymsystem.hibernate.model.User;



@Repository
@Transactional
public class TraineeDaoImpl implements TraineeDao {

	private SessionFactory sessionFactory;

	@Autowired
    public TraineeDaoImpl(LocalSessionFactoryBean sessionFactoryBean) {
        this.sessionFactory = sessionFactoryBean.getObject();
    }
	
	@Override
	public void deleteTrainee(long id) {
		Session session = sessionFactory.getCurrentSession();
		Trainee trainee = session.find(Trainee.class, id);
		session.remove(trainee);
	}

	@Override
	public void updateTraineePassword(String username, String password, String newPassword) {
		if(matchingPasswordAndUsername(username, password)) {
			Session session = sessionFactory.getCurrentSession();
			Trainee trainee = getTraineeByUsername(username, password);
			User user = session.find(User.class, trainee.getUser().getId());
			user.setPassword(newPassword);
			session.flush();
		}else {
			System.out.println("The username/password provided doesn't match, " +
					   "please enter correct credentials.");
		}
	}

	@Override
	public void createTrainee(Date dateOfBirth, String address, Long userId) {
		Session session = sessionFactory.getCurrentSession();
        // Get the existing User
        User user = session.get(User.class, userId);
        // Create a new Trainee entity and set the User
        Trainee trainee = new Trainee();
        trainee.setDateOfBirth(dateOfBirth);
        trainee.setAddress(address);
        trainee.setUser(user);
        // Persist the Trainer entity
        session.persist(trainee);
	}

	@Override
	public Trainee getTraineeById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Trainee> getAllTrainees() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void updateTraineeProfile(String username, String password, Date date, String address) {
		if(matchingPasswordAndUsername(username, password)) {
			Session session = sessionFactory.getCurrentSession();
	        Trainee trainee = getTraineeByUsername(username, password);
	        // Create a new Trainer entity and set the User and TrainingType
	        trainee = session.find(Trainee.class, trainee.getId());
	        trainee.setDateOfBirth(date);
	        trainee.setAddress(address);
			session.flush();
		}else {
			System.out.println("The username/password provided doesn't match, " +
					   "please enter correct credentials.");
		}
	}
	
	@Override
	public void changeTraineeStatus(String username, String password) {
		if(matchingPasswordAndUsername(username, password)) {
			Session session = sessionFactory.getCurrentSession();
	        Trainee trainee = getTraineeByUsername(username, password);
	        // Create a new Trainer entity and set the User and TrainingType
	        User user = session.find(User.class, trainee.getUser().getId());
	        if(user.getIsActive())
	        	user.setIsActive(false);
	        else
	        	user.setIsActive(true);
			session.flush();
		}else {
			System.out.println("The username/password provided doesn't match, " +
					   "please enter correct credentials.");
		}
	}
	
	@Override
	public Trainee getTraineeByUsername(String username, String password) {
		if(matchingPasswordAndUsername(username, password)) {
			// Getting user for the requested username
			Session session = sessionFactory.getCurrentSession();
		    CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		    CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
		    Root<User> root = criteriaQuery.from(User.class);
		    Predicate usernamePredicate = criteriaBuilder.equal(root.get("username"), username);
		    criteriaQuery.select(root).where(usernamePredicate);
		    TypedQuery<User> query = session.createQuery(criteriaQuery);
		    List<User> users = query.getResultList();
		    User user = users.get(0);
			return user.getTrainee();
		}
		else {
			System.out.println("The username/password provided doesn't match, " +
							   "please enter correct credentials.");
			return null;
		}
	}
	
	@Override
	public Set<Training> getTrainings(String username, String password) {
		if(matchingPasswordAndUsername(username, password)) {
			Trainee trainee = getTraineeByUsername(username, password);
			return trainee.getTrainings();
		}
		else {
			System.out.println("The username/password provided doesn't match, " +
					   "please enter correct credentials.");
			return null;	
		}
	}
	
	@Override
	public List<Trainer> getTrainersNotAssignedToATrainee(String username, String password) {
		if(matchingPasswordAndUsername(username, password)) {
	        Set<Training> trainings = getTrainings(username, password);
	        List<Trainer> trainers = new ArrayList<>();
	        for(Training training : trainings) {
	        	trainers.add(training.getTrainer());
	        }
			return trainers;
		}
		else {
			System.out.println("The username/password provided doesn't match, " +
					   "please enter correct credentials.");
			return null;
		}
	}
	
	@Override
	public void deleteTrainer(String username, String password, Long trainerId) {
		if(matchingPasswordAndUsername(username, password)) {
	        Trainee trainee = getTraineeByUsername(username, password);
	        Set<Training> trainings = trainee.getTrainings();
	        for(Training training : trainings) {
	        	if(trainerId.equals(training.getTrainer().getId())) {
	        		training.setTrainer(null);
	        		break;
	        	}
	        }
		}
		else {
			System.out.println("The username/password provided doesn't match, " +
					   "please enter correct credentials.");
		}
	}
	
	private boolean matchingPasswordAndUsername(String username, String password) {
		Session session = sessionFactory.getCurrentSession();
	    CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
	    CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
	    Root<User> root = criteriaQuery.from(User.class);
	    // Adding predicates to the query to match the username and password
	    Predicate usernamePredicate = criteriaBuilder.equal(root.get("username"), username);
	    Predicate passwordPredicate = criteriaBuilder.equal(root.get("password"), password);
	    criteriaQuery.select(root).where(usernamePredicate, passwordPredicate);
	    TypedQuery<User> query = session.createQuery(criteriaQuery);
	    // Executing the query and check if any matching records are found
	    List<User> resultList = query.getResultList();
	    return !resultList.isEmpty();
	}
}