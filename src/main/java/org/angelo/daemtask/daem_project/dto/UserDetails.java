package org.angelo.daemtask.daem_project.dto;

import javax.persistence.*;

@Entity 
@Table (name="USER_CREDENTIALS")
public class UserDetails {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="USER_ID")
	private int userId;
	@Column(name="USER_USERNAME")
	private String username;
	@Column(name="USER_PASSWORD")
	private String password;
		
/*---> Getters - Setters bellow ------------------->*/
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}