package com.onix.rev.personalservice.Servicios;

import com.onix.rev.personalservice.DocumentosDB.Empleado;

import java.util.List;

public interface IServicioEmpleados {

    public Empleado guardarEmpleado(Empleado nuevoEmpleado);

    public Empleado eliminarEmpleado(String empleadoId);

    public Empleado editarDatosEmpleado(String empleadoId, Empleado empleadoEditado);

    public List<Empleado> listarEmpleados();

    public List<Empleado> ListarEmpleadosPorClinica(String clinicaId);

    public Boolean correoYaExistente(String correo);
}
