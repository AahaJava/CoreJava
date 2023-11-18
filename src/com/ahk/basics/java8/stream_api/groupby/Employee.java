package com.ahk.basics.java8.stream_api.groupby;

public class Employee {

    private int empId;
    private int deptId;
    private String empName;
    private int salary;

    public Employee(int empId, int deptId, String empName, int salary) {
        this.empId = empId;
        this.deptId = deptId;
        this.empName = empName;
        this.salary = salary;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", deptId=" + deptId +
                ", empName='" + empName + '\'' +
                ", salary=" + salary +
                '}';
    }
}
