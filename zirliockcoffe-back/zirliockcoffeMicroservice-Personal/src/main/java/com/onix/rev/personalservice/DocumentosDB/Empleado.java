package com.onix.rev.personalservice.DocumentosDB;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Empleados")
@Data
@AllArgsConstructor
public class Empleado {

    @Id
    private String id;
    private String nombre;
    private String apellidos;
    private String turnoAsignado;
    private String correo;
    private String contraseña;
    private String clinicaId;
}