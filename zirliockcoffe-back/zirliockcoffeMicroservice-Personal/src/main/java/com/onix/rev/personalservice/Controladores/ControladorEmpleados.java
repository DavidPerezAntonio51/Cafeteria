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
            Empleado guardado = servicioEmpleados.guardarEmpleado(empleado);
            guardado.setContraseña(null);
            return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body("El correo ya pertenece a otro empleado");
    }

    @GetMapping(path = "/{empleadoId}")
    public ResponseEntity<Empleado> empleadoEspecifico(@PathVariable("empleadoId") String id){
        Empleado empl = servicioEmpleados.empleadoEspecifico(id);
        if(empl==null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(empl);
    }

    @PutMapping(path = "/{empleadoId}")
    public ResponseEntity<Empleado> editarDatos(@PathVariable("empleadoId") String id, @RequestBody Empleado emplactual){
        Empleado empl = servicioEmpleados.editarDatosEmpleado(id, emplactual);
        if(empl==null)
            return ResponseEntity.badRequest().build();
        empl.setContraseña(null);
        return ResponseEntity.ok(empl);
    }
    @DeleteMapping(path = "/{empleadoId}")
    public ResponseEntity darDeBaja(@PathVariable("empleadoId") String id){
        servicioEmpleados.eliminarEmpleado(id);
        return ResponseEntity.ok().build();
    }
}
