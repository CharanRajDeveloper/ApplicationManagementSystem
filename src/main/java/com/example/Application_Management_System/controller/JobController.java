package com.example.Application_Management_System.controller;

import com.example.Application_Management_System.entity.Applicant;
import com.example.Application_Management_System.entity.Job;
import com.example.Application_Management_System.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jobs")
public class JobController {
    @Autowired
    private JobService jobService;

    @PostMapping
    public ResponseEntity<Job> createJob(@RequestBody Job job) {
        Job createdJob = jobService.createJob(job);
        return ResponseEntity.ok(createdJob);
    }

    @PostMapping("/add-job-to-applicant")
    public ResponseEntity<Applicant> addJobToApplicant(@RequestParam Long applicantId, @RequestParam Long jobId) {
        Applicant applicant = jobService.addJobToApplicant(applicantId, jobId);
        return ResponseEntity.ok(applicant);
    }
}
