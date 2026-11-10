package com.example.Application_Management_System.Repository;

import com.example.Application_Management_System.entity.Applications;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationJPARepository extends JpaRepository<Applications,Long> {
}
