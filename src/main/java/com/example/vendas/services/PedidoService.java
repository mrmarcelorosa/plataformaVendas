package com.example.vendas.services;

import com.example.vendas.domain.Categoria;
import com.example.vendas.domain.Pedido;
import com.example.vendas.repositories.CategoriaRepository;
import com.example.vendas.repositories.PedidoRepository;
import com.example.vendas.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository repository;

    public Pedido findById(Integer id){
        Optional<Pedido> pedido = repository.findById(id);
        return pedido.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado "+id + " Tipo: "+ Pedido.class.getName()));
    }
}
