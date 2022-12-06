package com.example.vendas.services;

import com.example.vendas.domain.Categoria;
import com.example.vendas.domain.Cliente;
import com.example.vendas.dto.CategoriaDto;
import com.example.vendas.dto.ClienteDto;
import com.example.vendas.repositories.ClienteRepository;
import com.example.vendas.services.exceptions.DataIntegrityViolationCustomException;
import com.example.vendas.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository repository;

    public Cliente findById(Integer id){
        Optional<Cliente> cliente = repository.findById(id);
        return cliente.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado "+id + " Tipo: "+ Cliente.class.getName()));
    }

    public Cliente insert(Cliente cliente){
        return repository.save(cliente);
    }

    public Cliente update(Cliente cliente){
        Cliente clienteDb = findById(cliente.getId());
        updateData(clienteDb, cliente);
        return repository.save(clienteDb);
    }

    public void delete(Integer id){
        findById(id);
        try {
            repository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityViolationCustomException("Não é possível excluir um cliente que possui pedidos e endereços!");
        }
    }

    public List<ClienteDto> findAll(){
        return repository.findAll().stream().map(obj -> new ClienteDto(obj)).collect(Collectors.toList());
    }

    public Page<ClienteDto> findPage(Integer page, Integer linesPage, String orderBy, String direction){
        PageRequest pageRequest = PageRequest.of(page, linesPage, Sort.Direction.valueOf(direction), orderBy);
        return repository.findAll(pageRequest).map(obj -> new ClienteDto(obj));
    }

    public Cliente fromDto(ClienteDto dto){
        return new Cliente(dto.getId(),dto.getNome(),dto.getEmail(),null,null);
    }

    private void updateData(Cliente clienteDb, Cliente cliente){
        clienteDb.setNome(cliente.getNome());
        clienteDb.setEmail(cliente.getEmail());
    }
}
