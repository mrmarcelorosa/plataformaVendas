package com.example.vendas.services;

import com.example.vendas.domain.Categoria;
import com.example.vendas.dto.CategoriaDto;
import com.example.vendas.repositories.CategoriaRepository;
import com.example.vendas.services.exceptions.DataIntegrityViolationCustomException;
import com.example.vendas.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository repository;

    public Categoria findById(Integer id){
        Optional<Categoria> categoria = repository.findById(id);
        return categoria.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado "+id + " Tipo: "+ Categoria.class.getName()));
    }

    public Categoria insert(Categoria categoria){
        return repository.save(categoria);
    }

    public Categoria update(Categoria categoria){
        findById(categoria.getId());
        return repository.save(categoria);
    }

    public void delete(Integer id){
        findById(id);
        try {
            repository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityViolationCustomException("Não é possível excluir uma categoria que possui produtos!");
        }
    }

    public List<CategoriaDto> findAll(){
        return repository.findAll().stream().map(obj -> new CategoriaDto(obj)).collect(Collectors.toList());
    }
}
