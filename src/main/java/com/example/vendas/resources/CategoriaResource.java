package com.example.vendas.resources;

import com.example.vendas.domain.Categoria;
import com.example.vendas.dto.CategoriaDto;
import com.example.vendas.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
@Validated
public class CategoriaResource {

    @Autowired
    private CategoriaService service;

    @RequestMapping(value ="/{id}" ,method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable Integer id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert (@Valid @RequestBody CategoriaDto categoriaDto){
        Categoria categoria = service.insert(service.fromDto(categoriaDto));
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(categoria.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody CategoriaDto categoriaDto, @PathVariable Integer id){
        categoriaDto.setId(id);
        Categoria categoria = service.update(service.fromDto(categoriaDto));
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value ="/{id}" ,method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CategoriaDto>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @RequestMapping(value = "/page",method = RequestMethod.GET)
    public ResponseEntity<Page<CategoriaDto>> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction){
        return ResponseEntity.ok().body(service.findPage(page,linesPerPage,orderBy,direction));
    }

}
