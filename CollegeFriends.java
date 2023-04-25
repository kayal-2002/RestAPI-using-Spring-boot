package com.making.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Friends")
public class CollegeFriends {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long id;
	@Column(name="first_name")
	private String firstname;
	@Column(name="last_name")
	private String lastname; 
	@Column(name="email")
	private String email;
	public CollegeFriends() {
		super();
	}
	public CollegeFriends(String firstname, String lastname, String email) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "CollegeFriends [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ "]";
	}
	public void setId(Long id2) {
		// TODO Auto-generated method stub
		
	}
	

}
