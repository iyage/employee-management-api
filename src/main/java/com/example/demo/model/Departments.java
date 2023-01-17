package com.example.demo.model;

public enum Departments {
    ACCT("Accounting Department"),SALES("Sales Department"),;
    private String dept;
    Departments(String s) {
        this.dept = s;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}
