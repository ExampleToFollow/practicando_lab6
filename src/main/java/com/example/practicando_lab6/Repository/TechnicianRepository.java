package com.example.practicando_lab6.Repository;

import com.example.practicando_lab6.Entity.Technician;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnicianRepository extends JpaRepository<Technician, Integer>  {
}
