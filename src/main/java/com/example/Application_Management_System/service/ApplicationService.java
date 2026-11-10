package com.example.Application_Management_System.service;

import com.example.Application_Management_System.Repository.ApplicantJPARepository;
import com.example.Application_Management_System.Repository.ApplicationJPARepository;
import com.example.Application_Management_System.entity.Applicant;
import com.example.Application_Management_System.entity.Applications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationJPARepository applicationJPARepository;
    @Autowired
    private ApplicantJPARepository applicantJPARepository;

    public Applications saveApplications(Long application_id, Applications application) {
        Optional<Applicant> byId = applicantJPARepository.findById(application_id);
        if (byId.isPresent()) {
            Applicant applicant = byId.get();
            application.setApplicant(applicant);
            return applicationJPARepository.save(application);
        }else {
            throw new RuntimeException("Applicant not found with Id while saving application:" + application_id);
        }

    }
}
