package com.onix.rev.cortesservice.reporitorio;

import com.onix.rev.cortesservice.DocumentosDB.Corte;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioCortes extends MongoRepository<Corte, String> {
}
