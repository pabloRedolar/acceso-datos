package org.iesch.ad.ProyectoConsultasAutomoviles.repositories;

import org.iesch.ad.ProyectoConsultasAutomoviles.model.Cliente;
import org.iesch.ad.ProyectoConsultasAutomoviles.model.DTO.ClienteDTO;
import org.iesch.ad.ProyectoConsultasAutomoviles.model.DTO.ClienteSinCochesDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {


    boolean existsClienteByNif(String nif);

    List<Cliente> findClienteByNombreAndApellidos(String nombre, String apellidos);

    Cliente getClienteById(Long id);

    List<Cliente> findDistinctByCochesColor(String color);

    List<Cliente> findClientesByCochesPrecioGreaterThan(Float precio);

//    @Query("SELECT c " +
//            "FROM Cliente c " +
//            "JOIN c.coches co " +
//            "GROUP BY c.nif, c.nombre, c.ciudad " +
//            "having count(co) = (SELECT MAX(count(co2)) from Cliente c1 JOIN c1.coches co2 group by c1)")

    @Query("SELECT new org.iesch.ad.ProyectoConsultasAutomoviles.model.DTO.ClienteDTO(c.nif, c.nombre, c.ciudad) " + "FROM Cliente c WHERE SIZE(c.coches) = (SELECT MAX(SIZE(cli.coches)) FROM Cliente cli)")
    List<ClienteDTO> getClientesConMasCoches();


    @Query("SELECT c FROM Cliente c JOIN FETCH c.coches co WHERE co.matricula = :matricula")
    Cliente getClientePorMatricula(String matricula);

    @Query("SELECT c FROM Cliente c JOIN FETCH c.coches co JOIN FETCH co.revisiones revs WHERE revs.codigo = :codigoInterno")
    Cliente getClientePorCodigoRevision(String codigoInterno);

//    Realiza una consulta que a partir de un código de revisión como el del ejercicio anterior, sea
//    capaz de devolvernos un cliente, pero sin sus coches, ni las revisiones, pero que incluya el total
//    de coches que posee, y cuanto dinero en total se gastó en todos ellos.


//    @Query("SELECT c.nif FROM Cliente c JOIN c.coches co JOIN co.revisiones rev WHERE rev.codigo = :codigo")

    @Query("SELECT new org.iesch.ad.ProyectoConsultasAutomoviles.model.DTO.ClienteSinCochesDTO(c2.nif, c2.nombre, count(co2), sum(co2.precio))" +
            "FROM Cliente c2 " +
            "JOIN c2.coches co2 " +
            "WHERE c2.nif = (SELECT c.nif " +
                "FROM Cliente c " +
                "JOIN c.coches co " +
                "JOIN co.revisiones rev " +
                "WHERE rev.codigo = :codigo) group by c2")

//            @Query("SELECT new org.iesch.ad.ProyectoConsultasAutomoviles.model.DTO.ClienteSinCochesDTO(c.nif, c.nombre, size(c.coches), sum(co.precio)) " +
//            "FROM Cliente c " +
//            "JOIN c.coches co " +
//            "left JOIN co.revisiones rev " +
//            "WHERE rev.codigo = :codigo " +
//            "GROUP BY co.cliente")


//    @Query("select new org.iesch.ad.Queries.model.dto.ClientDTO(c.nif, c.nombre, c.telefono, c.direccion, c.ciudad)" +
//            " from Cliente c join c.coches co join co.revisiones rev where rev.codigo = :codigo")
//    ClientDTO findClientePorIdRevision(String codigo);
//
//    @Query("select new org.iesch.ad.Queries.model.dto.NumeroDeCochesYsumaDePreciosDTO(size(c.coches), sum(co.precio)) from Cliente c join c.coches co where c.nif = :nif")
//    NumeroDeCochesYsumaDePreciosDTO findNcochesYsumaPrecios(String nif);
//


    ClienteSinCochesDTO getClienteSinCochesPorCodigoRevision(String codigo);
//    ClienteSinCochesDTO getClienteSinCochesPorCodigoRevision(String codigo);
}
