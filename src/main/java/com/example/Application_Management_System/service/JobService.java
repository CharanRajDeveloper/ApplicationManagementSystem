package com.example.Application_Management_System.service;

import com.example.Application_Management_System.Repository.ApplicantJPARepository;
import com.example.Application_Management_System.Repository.JobJPARepository;
import com.example.Application_Management_System.entity.Applicant;
import com.example.Application_Management_System.entity.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JobService {
    @Autowired
    private JobJPARepository jobJpaRepository;
    @Autowired
    private ApplicantJPARepository applicantJPARepository;

    public Job createJob(Job job) {
        return jobJpaRepository.save(job);
    }

    public Applicant addJobToApplicant(Long applicationId, Long jobId) {
        Optional<Applicant> applicant = applicantJPARepository.findById(applicationId);
        Optional<Job> job = jobJpaRepository.findById(jobId);
        if (applicant.isPresent() && job.isPresent()) {
            applicant.get().getJobs().add(job.get());
            applicantJPARepository.save(applicant.get());
            return applicant.get();
        } else {
            throw new IllegalArgumentException("Applicant or Job not found");
        }

    }
}
