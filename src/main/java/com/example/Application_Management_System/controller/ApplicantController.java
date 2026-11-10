package com.example.Application_Management_System.controller;

import com.example.Application_Management_System.entity.Applicant;
import com.example.Application_Management_System.service.ApplicantService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applicants")
public class ApplicantController {

    @Autowired
    private ApplicantService applicantService;

    @GetMapping
    public List<Applicant> getAllApplicants(){
        return applicantService.getAllApplicants();
    }

    @PostMapping
    public  Applicant saveApplicant(@Valid @RequestBody Applicant applicant){
        return applicantService.saveApplicantCrud(applicant);
    }

    @GetMapping("/page")
    public Iterable<Applicant> getApplicantswithPagination(@RequestParam int page,@RequestParam int size){
     return applicantService.getApplicantswithPagination(page, size);
    }

    @GetMapping("/getByStatus")
    public List<Applicant> getApplicantByStatus(@RequestParam String status){
        return applicantService.getApplicantsByStatus(status);
    }

    @GetMapping("/getByPartialName")
    public List<Applicant> getApplicantsByPartialName(@RequestParam String name){
        return applicantService.getApplicantsByPartialName(name);
    }


}
