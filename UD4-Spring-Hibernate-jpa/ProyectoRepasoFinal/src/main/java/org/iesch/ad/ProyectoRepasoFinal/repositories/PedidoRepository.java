package org.iesch.ad.ProyectoRepasoFinal.repositories;

import org.iesch.ad.ProyectoRepasoFinal.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

//    @Query("SELECT p FROM Pedido p JOIN p.platos pla where sum(pla.precio) = (SELECT MAX(sum(pl.precio)) from Pedido ped join ped.platos pl group by ped)")

    //Obtener el pedido más caro realizado por cada cliente.

//    @Query("select p from Pedido p join p.platos pla join p.cliente cl where sum(pla.precio) = (SELECT max(sum(pl.precio)) from p.platos pl)")

    @Query("SELECT p FROM Pedido p WHERE p.platos IS NOT EMPTY GROUP BY p.cliente.id ORDER BY SUM(p.platos) DESC")
    List<Object> pedidoMasCaroCliente();

//    @Query("SELECT p, MAX(:precios) from Pedido p")
//    List<Object> pedidosPrecioMax(Double precios);
}
