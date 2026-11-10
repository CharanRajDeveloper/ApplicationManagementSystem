package com.example.Application_Management_System.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Applicant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String name;
    @Email(message = "Invalid email format")
    @NotBlank(message = "Email cannot be null or empty")
    @Column(unique = true, nullable = false)
    private  String email;
    private String phone;
    private  String status;
    @OneToOne(mappedBy = "applicant",cascade = CascadeType.ALL)
    private Resume resume;
    @OneToMany(mappedBy = "applicant",cascade = CascadeType.ALL)
    private List<Applications> applicantList = new ArrayList<>();
    @ManyToMany
    @JoinTable(
            name = "applicants_job",
            joinColumns = @JoinColumn(name = "applicationId"),
            inverseJoinColumns = @JoinColumn(name = "jobId")
    )
    private List<Job> jobs = new ArrayList<>();

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public List<Applications> getApplicantList() {
        return applicantList;
    }

    public void setApplicantList(List<Applications> applicantList) {
        this.applicantList = applicantList;
    }

    public Resume getResume() {
        return resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
