package ru.java.HotelBooking.domain;

import java.util.Objects;

public class Staff {

    private Long staff_id;
    private Long hotel_id;
    private String first_name;
    private String last_name;
    private String job_name;
    private Integer salary;

    public Staff(Long staff_id, Long hotel_id, String first_name, String last_name, String job_name, Integer salary) {
        this.staff_id = staff_id;
        this.hotel_id = hotel_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.job_name = job_name;
        this.salary = salary;
    }

    public Staff(Long hotel_id, String first_name, String last_name, String job_name, Integer salary) {
        this.hotel_id = hotel_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.job_name = job_name;
        this.salary = salary;
    }

    public Staff(){}

    public Staff(long emplId) {
        this.staff_id = emplId;
    }

    public Long getHotel_id() {
        return hotel_id;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public Integer getSalary() {
        return salary;
    }

    public Long getStaff_id() {
        return staff_id;
    }

    public String getJob_name() {
        return job_name;
    }

    public void setHotel_id(Long hotel_id) {
        this.hotel_id = hotel_id;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setJob_name(String job_name) {
        this.job_name = job_name;
    }

    public void setStaff_id(Long staff_id) {
        this.staff_id = staff_id;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public String toString(){
        return "Employee{id="+this.staff_id+ ", name='" + this.first_name + " "+this.last_name+" "+'\'' + ", job=" + this.job_name + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Staff staff = (Staff) o;
        return staff_id.equals(staff.staff_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(staff_id);
    }
}
