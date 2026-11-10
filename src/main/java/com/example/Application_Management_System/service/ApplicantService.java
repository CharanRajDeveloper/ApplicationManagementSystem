package com.example.Application_Management_System.service;

import com.example.Application_Management_System.Repository.ApplicantJPARepository;
import com.example.Application_Management_System.Repository.ApplicationCrudRepository;
import com.example.Application_Management_System.Repository.ApplicationPagingandSortingRepository;
import com.example.Application_Management_System.entity.Applicant;
import com.example.Application_Management_System.entity.Applications;
import com.example.Application_Management_System.entity.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicantService {
    @Autowired
    private ApplicationCrudRepository applicationCrudRepository;
    @Autowired
    private ApplicationPagingandSortingRepository applicationPagingandSortingRepository;

    @Autowired
    private ApplicantJPARepository applicantJPARepository;

    public List<Applicant> getAllApplicants() {
        return applicantJPARepository.findAll();
    }

    public Applicant saveApplicantCrud(Applicant applicant) {
        if (applicant != null) {
            Resume resume = applicant.getResume();
            List<Applications> applicantList = applicant.getApplicantList();
            if (resume != null) {
                resume.setApplicant(applicant);
            }
            if (applicantList != null) {
                for (Applications applications : applicantList) {
                    applications.setApplicant(applicant);
                }
            }

        }
        return applicantJPARepository.save(applicant);
    }

    public Iterable<Applicant> getApplicantswithPagination(int page, int size) {
        return applicantJPARepository.findAll(PageRequest.of(page, size));
    }

    public List<Applicant> getApplicantsByStatus(String status) {
        return applicantJPARepository.findByStatus(status);
    }

    public List<Applicant> getApplicantsByPartialName(String name) {
        return applicantJPARepository.findApplicantsByPartialName(name);
    }
}
