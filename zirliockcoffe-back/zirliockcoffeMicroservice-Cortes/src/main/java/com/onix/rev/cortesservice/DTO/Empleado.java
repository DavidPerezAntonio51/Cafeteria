package com.onix.rev.cortesservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Empleado {
        private String id;
        private String nombre;
        private String apellidos;
        private String turnoAsignado;
}
