package org.iesch.ad.ProyectoRepasoFinal.repositories;

import org.iesch.ad.ProyectoRepasoFinal.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

//    @Query("SELECT p FROM Pedido p JOIN p.platos pla where sum(pla.precio) = (SELECT MAX(sum(pl.precio)) from Pedido ped join ped.platos pl group by ped)")


//    @Query("select p from Pedido p join p.platos pla join p.cliente cl where sum(pla.precio) = (SELECT max(sum(pl.precio)) from p.platos pl)")

    //Obtener el pedido más caro realizado por cada cliente.

    @Query("SELECT p, p FROM Pedido p join p.platos pla GROUP BY p.cliente.id ORDER BY SUM(pla.precio) DESC")
    List<Object> pedidoMasCaroCliente();

//    @Query("SELECT p, MAX(:precios) from Pedido p")
//    List<Object> pedidosPrecioMax(Double precios);
}
