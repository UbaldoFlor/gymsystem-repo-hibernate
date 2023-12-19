package com.gymsystem.hibernate.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "trainee")
public class Trainee {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
    private Long id;
	
	@Size(min = 1, max = 255)
    @Column(name = "DateOfBirth")
    private Date dateOfBirth;
	
	@Size(min = 1, max = 255)
    @Column(name = "Address")
    private String address;
	
	@OneToOne
	@JoinColumn(name="UserID")
    private User traineeUser;
	
	@OneToMany(mappedBy = "trainee", fetch = FetchType.EAGER)
	private Set<Training> trainings = new HashSet<>();
	
	//getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public User getUser() {
		return this.traineeUser;
	}

	public void setUser(User user) {
		this.traineeUser = user;
	}
	
	public Set<Training> getTrainings() {
		return trainings;
	}

	public void setTrainings(Set<Training> trainings) {
		this.trainings = trainings;
	}

	@Override
	public String toString() {
		return String.valueOf(this.id) + "," +
				String.valueOf(this.dateOfBirth) + "," +
				this.address + "," +
				this.traineeUser.getId();
	}
}