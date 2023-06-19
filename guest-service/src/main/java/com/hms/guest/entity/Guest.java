package com.hms.guest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Guest {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String gender;
	private String email;
	private String city;
	private String state;
	private String country;
	@Column(name = "contact_Number")
	private Long contactNumber;
	
	public Guest() {
		
	}

	public Guest(Long id, String name, String gender, String email, String city, String state, String country,
			Long contactNumber) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.city = city;
		this.state = state;
		this.country = country;
		this.contactNumber = contactNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Override
	public String toString() {
		return "Guest [id=" + id + ", name=" + name + ", gender=" + gender + ", email=" + email + ", city=" + city
				+ ", state=" + state + ", country=" + country + ", contactNumber=" + contactNumber + "]";
	}
	
	

}
