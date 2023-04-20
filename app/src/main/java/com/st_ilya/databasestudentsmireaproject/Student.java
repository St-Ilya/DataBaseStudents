package com.st_ilya.databasestudentsmireaproject;

public class Student {

    private String name;
    private String surname;
    private String middleName;
    private String birthdayDay;
    private String group;

    public Student(String name, String surname, String middleName, String birthdayDay, String group) {
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.birthdayDay = birthdayDay;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getBirthdayDay() {
        return birthdayDay;
    }

    public void setBirthdayDay(String birthdayDay) {
        this.birthdayDay = birthdayDay;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void addStudent() {

    }

    public void refactorStudent() {

    }

    public void deleteGroup() {

    }
}
