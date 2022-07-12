package com.onix.rev.productosService.repositorio;

import com.onix.rev.productosService.documentosDB.Producto;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author DiosBino
 */
public interface RepositorioProductos extends MongoRepository<Object, String>{
    public List<Producto> findByClinicaId(String clinicaId);
    
}
