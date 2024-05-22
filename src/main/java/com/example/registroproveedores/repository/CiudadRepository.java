package com.example.registroproveedores.repository;

import com.example.registroproveedores.model.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CiudadRepository extends JpaRepository<Ciudad, Long> {
}
