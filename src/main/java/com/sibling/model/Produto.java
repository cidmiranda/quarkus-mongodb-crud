package com.sibling.model;

import io.quarkus.mongodb.panache.PanacheMongoEntity;

public class Produto extends PanacheMongoEntity {
    public String nome;
    public double preco;
}
