package com.onix.rev.cortesservice.DocumentosDB;

import com.onix.rev.cortesservice.DTO.Clinica;
import com.onix.rev.cortesservice.DTO.Empleado;
import com.onix.rev.cortesservice.DTO.Producto;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Cortes")
@Data
@AllArgsConstructor
public class Corte {
    @Id
    private String id;
    private Empleado empleado;
    private Clinica clinica;
    private String fecha;
    private Double ventaTotal;
    private List<Producto> productos;
}
