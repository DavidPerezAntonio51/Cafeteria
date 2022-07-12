package com.onix.rev.productosService.documentosDB;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 *
 * @author DiosBino
 */
@Document(collection = "Productos")
@Data
@AllArgsConstructor

public class Producto {
    @Id
    private String id; 
    private String nombre;
    private String precio;
    private String clinicaId;
}
