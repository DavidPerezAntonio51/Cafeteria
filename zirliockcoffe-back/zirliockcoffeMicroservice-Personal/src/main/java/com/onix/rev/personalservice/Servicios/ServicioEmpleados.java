package com.onix.rev.personalservice.Servicios;

import com.onix.rev.personalservice.DocumentosDB.Empleado;
import com.onix.rev.personalservice.Repositorios.RepositorioEmpleados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioEmpleados implements IServicioEmpleados{

    @Autowired
    RepositorioEmpleados empleadosRepo;

    @Autowired
    PasswordEncoder contraseñasEncoder;

    @Override
    public Empleado guardarEmpleado(Empleado nuevoEmpleado) {
        nuevoEmpleado.setContraseña(contraseñasEncoder.encode(nuevoEmpleado.getContraseña()));
        Empleado registrado = empleadosRepo.save(nuevoEmpleado);
        return registrado;
    }

    @Override
    public Empleado eliminarEmpleado(String empleadoId) {
        return null;
    }

    @Override
    public Empleado editarDatosEmpleado(String empleadoId, Empleado empleadoEditado) {
        return null;
    }

    @Override
    public List<Empleado> listarEmpleados() {
        List<Empleado> empleados = empleadosRepo.findAll();
        if(empleados.isEmpty()) return null;
        return empleados;
    }

    @Override
    public List<Empleado> ListarEmpleadosPorClinica(String clinicaId) {
        List<Empleado> empleados = empleadosRepo.findByClinicaId(clinicaId);
        if(empleados.isEmpty()) return null;
        return empleados;
    }

    @Override
    public Boolean correoYaExistente(String correo) {
        return empleadosRepo.findByCorreo(correo)!=null;
    }
}
