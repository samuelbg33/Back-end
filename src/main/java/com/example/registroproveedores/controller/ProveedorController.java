package com.example.registroproveedores.controller;

import com.example.registroproveedores.model.Proveedor;
import com.example.registroproveedores.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {

    private final ProveedorService proveedorService;

    @Autowired
    public ProveedorController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    @PostMapping
    public Proveedor createProveedor(@RequestPart("proveedor") Proveedor proveedor, @RequestPart("rutFile") MultipartFile rutFile) {
        return proveedorService.saveProveedor(proveedor, rutFile);
    }

    @GetMapping
    public List<Proveedor> getAllProveedores() {
        return proveedorService.getAllProveedores();
    }
}