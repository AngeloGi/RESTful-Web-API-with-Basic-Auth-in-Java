package org.angelo.daemtask.daem_project.dto;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HibernateInteract {
	private String submittedUsername;
	private String submittedPassword;
	
	public HibernateInteract(String username, String password) {
		this.submittedUsername = username;
		this.submittedPassword = password;
	}
	
	public Boolean tryAuthenticateCreds() {
		UserDetails user = new UserDetails();
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			String discoveredUser = "";
			String discoveredPass = "";
			
			Query query = session.createQuery("from UserDetails where USER_USERNAME=:usernameSearch");
			query.setParameter("usernameSearch", getSubmittedUsername());
			List result = query.list();
			if (result.get(0) != null) {
				UserDetails resultUserDetails = (UserDetails) result.get(0);
				discoveredUser = resultUserDetails.getUsername();
				discoveredPass = resultUserDetails.getPassword();
				if (discoveredPass.equals(getSubmittedPassword())) {
					System.out.println("The result is " + discoveredUser + " and " + discoveredPass + "-----------!!!! ----");			
					session.close();
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} catch (Exception authenticationFailed) { 
			session.close();
			return false;
		}
	}

	public String getSubmittedUsername() {
		return submittedUsername;
	}

	public String getSubmittedPassword() {
		return submittedPassword;
	}
}