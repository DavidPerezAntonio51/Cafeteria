package com.onix.rev.personalservice.Servicios;

import com.onix.rev.personalservice.DocumentosDB.Empleado;
import com.onix.rev.personalservice.Repositorios.RepositorioEmpleados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioEmpleados implements IServicioEmpleados {

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
    public void eliminarEmpleado(String empleadoId) {
        empleadosRepo.deleteById(empleadoId);
    }

    @Override
    public Empleado editarDatosEmpleado(String empleadoId, Empleado empleadoEditado) {
        Optional<Empleado> existente = empleadosRepo.findById(empleadoId);
        if (!existente.isPresent()) {
            return null;
        }else{
            Empleado empleado = existente.get();
            if(empleadoEditado.getContraseña().equals("")){
                empleadoEditado.setContraseña(empleado.getContraseña());
                if(empleado.equals(empleadoEditado)){
                    return empleado;
                }
                empleadoEditado = empleadosRepo.save(empleadoEditado);
            }else{
                empleadoEditado.setContraseña(contraseñasEncoder.encode(empleadoEditado.getContraseña()));
                empleadoEditado = empleadosRepo.save(empleadoEditado);
            }
            return empleadoEditado;
        }
    }

    @Override
    public List<Empleado> listarEmpleados() {
        List<Empleado> empleados = empleadosRepo.findAll();
        if (empleados.isEmpty())
            return null;
        return empleados;
    }

    @Override
    public List<Empleado> ListarEmpleadosPorClinica(String clinicaId) {
        List<Empleado> empleados = empleadosRepo.findByClinicaId(clinicaId);
        if (empleados.isEmpty()) return null;
        return empleados;
    }

    @Override
    public Boolean correoYaExistente(String correo) {
        return empleadosRepo.findByCorreo(correo) != null;
    }

    @Override
    public Empleado empleadoEspecifico(String id) {
        Optional<Empleado> encontrado = empleadosRepo.findById(id);
        if(encontrado.isPresent()){
            Empleado empl = encontrado.get();
            empl.setContraseña(null);
            return empl;
        }
        return null;
    }
}
