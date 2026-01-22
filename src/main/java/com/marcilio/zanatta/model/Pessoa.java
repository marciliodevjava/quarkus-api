package com.marcilio.zanatta.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

import java.util.List;

@Entity
public class Pessoa extends PanacheEntity {
    public String name;
    public int anoNascimento;

    public static List<Pessoa> findByAnoNascimento(int anoNascimento){
        return find("anoNascimento", anoNascimento).list();
    }
}
