package com.example.registroproveedores.service;

import com.example.registroproveedores.model.Proveedor;
import com.example.registroproveedores.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
public class ProveedorService {

    private final ProveedorRepository proveedorRepository;
    private final Path fileStorageLocation;

    @Autowired
    public ProveedorService(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
        this.fileStorageLocation = Paths.get("uploads").toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new RuntimeException("No se pudo crear el directorio donde se almacenarán los archivos subidos.", ex);
        }
    }

    public Proveedor saveProveedor(Proveedor proveedor, MultipartFile file) {
        String fileName = file.getOriginalFilename();
        try {
            if (fileName != null && !fileName.isEmpty()) {
                Path targetLocation = this.fileStorageLocation.resolve(fileName);
                Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
                proveedor.setRutFilePath(targetLocation.toString());
            }
        } catch (Exception ex) {
            throw new RuntimeException("No se pudo almacenar el archivo " + fileName + ". Inténtelo de nuevo.", ex);
        }
        return proveedorRepository.save(proveedor);
    }

    public List<Proveedor> getAllProveedores() {
        return proveedorRepository.findAll();
    }
}