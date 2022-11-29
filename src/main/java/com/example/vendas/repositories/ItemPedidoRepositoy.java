package com.example.vendas.repositories;

import com.example.vendas.domain.ItemPedido;
import com.example.vendas.domain.ItemPedidoPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepositoy extends JpaRepository<ItemPedido, ItemPedidoPK> {
}
