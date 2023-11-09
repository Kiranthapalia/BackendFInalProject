package com.example.finalproject.domain;

import java.util.List;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentid;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
    private List<Shift> shifts;

    public Department() {}

    public Department(String name) {
        super();
        this.name = name;
    }

    public Long getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Long departmentid) {
        this.departmentid = departmentid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Shift> getShifts() {
        return shifts;
    }

    public void setShifts(List<Shift> shifts) {
        this.shifts = shifts;
    }

    @Override
    public String toString() {
        return "Department [departmentid=" + departmentid + ", name=" + name + "]";
    }
}
