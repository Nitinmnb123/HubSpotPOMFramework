package com.Put.goRest;

public class Users_Pojo {

    private String first_name;
	
	private String last_name;
	
	private String gender;
  
	private String dob;

	private String email;

	public String getFirstname() {
		return first_name;
	}

	public void setFirstname(String firstname) {
		this.first_name = firstname;
	}

	public String getLastname() {
		return last_name;
	}

	public void setLastname(String lastname) {
		this.last_name = lastname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Users_Pojo(String firstname, String lastname, String gender, String dob, String email) {
		
		this.first_name = firstname;
		this.last_name = lastname;
		this.gender = gender;
		this.dob = dob;
		this.email = email;
	}

	
}
