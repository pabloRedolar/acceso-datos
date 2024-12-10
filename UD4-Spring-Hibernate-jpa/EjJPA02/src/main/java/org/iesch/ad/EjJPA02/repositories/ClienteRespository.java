//package org.iesch.ad.EjJPA02.repositories;
//
//import org.iesch.ad.EjJPA02.models.Cliente;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface ClienteRespository extends JpaRepository<Cliente, Long> {
//
////    @Query("SELECT c FROM cliente c, revision r JOIN FETCH c.coches coch JOIN FETCH co.revisiones WHERE c.id = :id")
////    Cliente findByIdMejor(Long id);
//
////    @Query("SELECT DISTINCT c FROM cliente c JOIN c.coches coche WHERE coche.color = :color")
////    List<Cliente> BuscarDiscinctByCocheColor(String colorCoche);
//
////    @Query()
////    Object buscarCochesPrecioMayor(Double precio);
//
//    List<Cliente> findClientesByCochesPrecioGreaterThan(Double precio);
//
//
//    @Query("select c from cliente c where id = (select co.id_cliente from coche co group by id_cliente having count(co.id))")
//    Object buscarClienteConMasCochesDTO();
////    List<Cliente> findByCocheMaxPrecio(Double precio);
//}
