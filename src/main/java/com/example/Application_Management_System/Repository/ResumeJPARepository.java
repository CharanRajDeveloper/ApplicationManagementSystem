package com.example.Application_Management_System.Repository;

import com.example.Application_Management_System.entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeJPARepository extends JpaRepository<Resume,Long> {
}
