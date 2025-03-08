package com.example.demo.Entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@Getter
@Setter
@Table(name = "employees")
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

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

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public Boolean isActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String Department;
    @Column(nullable = false)
    private LocalDate dateOfJoining;

    private Boolean isActive;

}
