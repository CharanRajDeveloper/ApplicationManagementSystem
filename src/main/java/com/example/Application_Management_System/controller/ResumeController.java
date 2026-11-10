package com.example.Application_Management_System.controller;

import com.example.Application_Management_System.entity.Resume;
import com.example.Application_Management_System.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @PostMapping("/applicants/{applicantId}/resumes")
    public ResponseEntity<Resume> addResume(@PathVariable Long applicantId, @RequestBody Resume resume) {
        return ResponseEntity.ok(resumeService.addResume(applicantId, resume));
    }
}
