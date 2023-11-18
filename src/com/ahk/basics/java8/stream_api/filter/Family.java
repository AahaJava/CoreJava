package com.ahk.basics.java8.stream_api.filter;

public class Family {
    private int members;
    private int salary;

    public Family(int members, int salary) {
        this.members = members;
        this.salary = salary;
    }

    public int getMembers() {
        return members;
    }

    public void setMembers(int members) {
        this.members = members;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Family{" +
                "members=" + members +
                ", salary=" + salary +
                '}';
    }
}
