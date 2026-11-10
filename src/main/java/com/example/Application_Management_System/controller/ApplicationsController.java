package com.example.Application_Management_System.controller;

import com.example.Application_Management_System.entity.Applications;
import com.example.Application_Management_System.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApplicationsController {
    @Autowired
    private ApplicationService applicationService;

    @PostMapping("/applications/{applicationId}")
    public ResponseEntity<Applications> saveApplication(@PathVariable Long applicationId, @RequestBody Applications applications) {
        return ResponseEntity.ok(applicationService.saveApplications(applicationId,applications));
    }
}
