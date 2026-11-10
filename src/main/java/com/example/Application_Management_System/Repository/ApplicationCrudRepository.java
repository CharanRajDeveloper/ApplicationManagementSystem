package com.example.Application_Management_System.Repository;

import com.example.Application_Management_System.entity.Applicant;
import org.springframework.data.repository.CrudRepository;

public interface ApplicationCrudRepository extends CrudRepository<Applicant,Long> {
}
