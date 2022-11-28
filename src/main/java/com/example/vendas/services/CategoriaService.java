package com.example.vendas.services;

import com.example.vendas.domain.Categoria;
import com.example.vendas.repositories.CategoriaRepository;
import com.example.vendas.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository repository;

    public Categoria findById(Integer id){
        Optional<Categoria> categoria = repository.findById(id);
        return categoria.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado "+id + " Tipo: "+ Categoria.class.getName()));
    }
}