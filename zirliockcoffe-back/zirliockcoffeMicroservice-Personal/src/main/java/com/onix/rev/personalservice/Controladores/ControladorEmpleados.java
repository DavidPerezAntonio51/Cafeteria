package com.onix.rev.personalservice.Controladores;

import com.onix.rev.personalservice.DocumentosDB.Empleado;
import com.onix.rev.personalservice.Servicios.IServicioEmpleados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/personal")
public class ControladorEmpleados {

    @Autowired
    IServicioEmpleados servicioEmpleados;

    @GetMapping
    public ResponseEntity<List<Empleado>> listarPersonal(
            @RequestParam(name = "clinicaId", defaultValue = "") String clinicaId
    ) {
        List<Empleado> empleados;
        if(clinicaId.equals("")){
            empleados = servicioEmpleados.listarEmpleados();
            if(empleados==null){
                return ResponseEntity.noContent().build();
            }
        }else{
            empleados = servicioEmpleados.ListarEmpleadosPorClinica(clinicaId);
            if(empleados==null) {
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.ok(empleados);
    }

    @PostMapping(path = "/registrar")
    public ResponseEntity registrarEmpleado(@RequestBody Empleado empleado){
        if(!servicioEmpleados.correoYaExistente(empleado.getCorreo())){
            servicioEmpleados.guardarEmpleado(empleado);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body("El correo ya pertenece a otro empleado");
    }
}
