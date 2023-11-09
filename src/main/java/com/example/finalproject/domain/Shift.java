package com.example.finalproject.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Shift {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private long id;
	private String name;
	private String startDate;
	private String endDate;
	private String assigned;
	private String status = "Pending";;

	@ManyToOne
	@JoinColumn(name = "departmentid")
	private Department department;

	public Shift() {
	}

	public Shift(String name, String startDate, String endDate, String assigned, String status, Department department) {
		super();
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.assigned = assigned;
		this.status = status;
		this.department = department;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStartDate() {

		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getAssigned() {
		return assigned;
	}

	public void setAssigned(String assigned) {
		this.assigned = assigned;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		if (this.department != null) {
			return "Shift [id=" + id + ", name=" + name + ", startDate=" + startDate + ", endDate=" + endDate
					+ ", assigned=" + assigned + ", status=" + status + ", department=" + this.getDepartment() + "]";
		} else {
			return "Shift [id=" + id + ", name=" + name + ", startDate=" + startDate + ", endDate=" + endDate
					+ ", assigned=" + assigned + ", status=" + status + "]";
		}
	}
}