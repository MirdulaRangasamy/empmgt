package com.empmgt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
	public class Employee {

		@Id
		private int empId;
		private String empName;
		private String empDept;
		private String empPass;
		public Employee() {
			super();
		}
		public Employee(int empId, String empName, String empDept, String empPass) {
			super();
			this.empId = empId;
			this.empName = empName;
			this.empDept = empDept;
			this.empPass = empPass;
		}
		public int getEmpId() {
			return empId;
		}
		public void setEmpId(int empId) {
			this.empId = empId;
		}
		public String getEmpName() {
			return empName;
		}
		public void setEmpName(String empName) {
			this.empName = empName;
		}
		public String getEmpDept() {
			return empDept;
		}
		public void setEmpDept(String empDept) {
			this.empDept = empDept;
		}
		public String getEmpPass() {
			return empPass;
		}
		public void setEmpPass(String empPass) {
			this.empPass = empPass;
		}
		
	}


