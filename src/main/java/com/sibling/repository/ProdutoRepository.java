package com.sibling.repository;

import com.sibling.model.Produto;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProdutoRepository implements PanacheMongoRepository<Produto>  {

}
