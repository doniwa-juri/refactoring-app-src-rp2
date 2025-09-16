package jp.co.sss.crud.dto;

import jp.co.sss.crud.util.ConstantMsg;

public class Employee {
	private int empId;
	private String empName;
	private int gender;
	private String birthday;
	private Department department;

	public Employee() {
	}

	public Employee(int empId, String empName, int gender, String birthday, Department department) {
		this.empId = empId;
		this.empName = empName;
		this.gender = gender;
		this.birthday = birthday;
		this.department = department;
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

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {

		String genderJa;
		switch (this.gender) {
		case 0 -> genderJa = ConstantMsg.GENDER_UNKOWN;
		case 1 -> genderJa = ConstantMsg.GENDER_MALE;
		case 2 -> genderJa = ConstantMsg.GENDER_FEMALE;
		case 9 -> genderJa = ConstantMsg.GENDER_OTHER;
		default -> genderJa = ConstantMsg.GENDER_UNKOWN;
		}
		;

		//		String deptName;
		//		switch (this.deptId) {
		//		case 1 -> deptName = ConstantMsg.DEPT_SALES;
		//		case 2 -> deptName = ConstantMsg.DEPT_ACCOUNTING;
		//		case 3 -> deptName = ConstantMsg.DEPT_GENERAL_AFFAIRS;
		//		default -> deptName = ConstantMsg.DEPT_UNKOWN;
		//		}
		//		;

		return empId + "\t" + empName + "\t" + genderJa + "\t" + birthday + "\t" + department.getDeptName();
	}

}
