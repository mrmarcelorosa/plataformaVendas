package com.example.vendas.resources;

import com.example.vendas.services.CategoriaService;
import com.example.vendas.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {

    @Autowired
    private PedidoService service;

    @RequestMapping(value ="/{id}" ,method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable Integer id){
        return ResponseEntity.ok().body(service.findById(id));
    }
}
