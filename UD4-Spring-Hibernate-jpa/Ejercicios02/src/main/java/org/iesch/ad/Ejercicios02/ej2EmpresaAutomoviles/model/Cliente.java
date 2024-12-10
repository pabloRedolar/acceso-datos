//package org.iesch.ad.Ejercicios02.ej2EmpresaAutomoviles.model;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import jakarta.persistence.*;
//import lombok.Data;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Entity
//@Data
//public class Cliente {
//    @Id
//    @GeneratedValue (strategy = GenerationType.IDENTITY)
//    private long id;
//    private String nif;
//    private String nombre;
//    private String apellidos;
//    private String direccion;
//    private String ciudad;
//    private String telefono;
//
//    @OneToMany (mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
//
////    @JoinColumn(name = "cliente_id")
//    //@JsonIgnoreProperties("coches")
//    @JsonIgnore
//    private Set<Coche> coches = new HashSet<>();
//
//}
