package com.onix.rev.personalservice.Repositorios;

import com.onix.rev.personalservice.DocumentosDB.Empleado;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioEmpleados extends MongoRepository<Empleado, String>{

    public List<Empleado> findByClinicaId(String id);

    public Empleado findByCorreo(String correo);

}
