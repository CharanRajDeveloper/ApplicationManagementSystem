package com.example.Application_Management_System.Repository;

import com.example.Application_Management_System.entity.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ApplicantJPARepository extends JpaRepository<Applicant,Long> {
   List<Applicant> findByStatus(String status);
   @Query("SELECT a FROM Applicant a WHERE a.name LIKE %:name%")
   List<Applicant> findApplicantsByPartialName(@Param("name") String name);
}
