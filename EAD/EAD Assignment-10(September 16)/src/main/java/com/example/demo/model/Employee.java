package com.example.demo.model;
	import javax.validation.constraints.Max;
	import javax.validation.constraints.Min;
	import javax.validation.constraints.NotBlank;
	import javax.validation.constraints.NotNull;
	import javax.validation.constraints.Pattern;
	import javax.validation.constraints.Size;

	import org.springframework.boot.context.properties.ConfigurationProperties;
	import org.springframework.stereotype.Component;
	import org.springframework.validation.annotation.Validated;
	public class Employee {
	private String fullName;
	private String gender;
	private String emailID;
	private String password;
	private String confirm;
	private String contact;
	private String organisation;
	private String url;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirm() {
		return confirm;
	}
	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
	public String getOrganisation() {
		return organisation;
	}
	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	

}
