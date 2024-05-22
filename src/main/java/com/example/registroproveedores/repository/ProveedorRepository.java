package com.example.registroproveedores.repository;

import com.example.registroproveedores.model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
}
