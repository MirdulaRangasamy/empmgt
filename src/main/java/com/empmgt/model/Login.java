package com.empmgt.model;

import org.springframework.stereotype.Component;

@Component
public class Login {
	private int empid;
	private String empPass;
	
	public Login(int empid, String empPass) {
		super();
		this.empid = empid;
		this.empPass = empPass;
	}
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpPass() {
		return empPass;
	}
	public void setEmpPass(String empPass) {
		this.empPass = empPass;
	}
	
	
}
