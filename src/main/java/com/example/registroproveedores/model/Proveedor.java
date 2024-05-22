package com.example.registroproveedores.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "La razón social es obligatoria")
    private String razonSocial;

    @NotEmpty(message = "El nombre del representante legal es obligatorio")
    private String representanteLegal;

    @NotEmpty(message = "El teléfono de contacto es obligatorio")
    @Size(min = 10, max = 10, message = "El teléfono de contacto debe tener 10 dígitos")
    private String telefonoContacto;

    @NotEmpty(message = "El email de contacto es obligatorio")
    @Email(message = "El email de contacto debe ser una dirección de correo válida")
    private String emailContacto;

    private String direccion;

    @ManyToOne
    @JoinColumn(name = "ciudad_id")
    private Ciudad ciudad;

    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;

    @ManyToOne
    @JoinColumn(name = "pais_id")
    private Pais pais;

    @NotEmpty(message = "La personería jurídica es obligatoria")
    private String personeriaJuridica;

    @NotEmpty(message = "El NIT es obligatorio")
    private String nit;

    private String rutFilePath;

    public void setRutFilePath(String rutFilePath) {
        this.rutFilePath = rutFilePath;
    }
}

    // Getters y Setters

