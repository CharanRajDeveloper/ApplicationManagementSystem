package com.example.Application_Management_System.Repository;

import com.example.Application_Management_System.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobJPARepository extends JpaRepository<Job,Long> {
}
