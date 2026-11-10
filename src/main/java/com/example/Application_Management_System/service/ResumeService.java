package com.example.Application_Management_System.service;

import com.example.Application_Management_System.Repository.ApplicantJPARepository;
import com.example.Application_Management_System.Repository.ResumeJPARepository;
import com.example.Application_Management_System.entity.Applicant;
import com.example.Application_Management_System.entity.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResumeService {

    @Autowired
    ApplicantJPARepository applicantJPARepository;
    @Autowired
    ResumeJPARepository resumeRepository;

    public Resume addResume(Long applicantId, Resume resume) {
        Optional<Applicant> byId = applicantJPARepository.findById(applicantId);
        if (byId.isPresent()) {
            Applicant applicant = byId.get();
            resume.setApplicant(applicant);
            return resumeRepository.save(resume);
        } else {
            throw new RuntimeException("Applicant not found with Id:" + applicantId);
        }
    }
}
