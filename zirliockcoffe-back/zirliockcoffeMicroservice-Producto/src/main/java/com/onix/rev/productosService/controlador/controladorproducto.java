package com.onix.rev.productosService.controlador;

import com.onix.rev.productosService.Service.servicioProducto;
import com.onix.rev.productosService.documentosDB.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DiosBino
 */

@RestController
@RequestMapping("/productos")
public class controladorproducto {
    
    @Autowired
    private servicioProducto serviceespañolproducto;
    
    @PostMapping("/registrar")
    public ResponseEntity Registrar(@RequestBody Producto prod){//parametros en la url(@param) //@pathvariable es el otro (jaja saludos(va dentro de la ruta)) //para leer el body, es @requestbody 
    
        return null;
    
    }
    
    
    
}