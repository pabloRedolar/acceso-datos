//package org.iesch.ad.Ejercicios02.ej2EmpresaAutomoviles.model;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import jakarta.persistence.*;
//import lombok.Data;
//
//import java.util.HashSet;
//import java.util.Set;
//
//
//@Entity
//@Data
//public class Coche {
//    @Id
//    private String matricula;
//    private String marca;
//    private String modelo;
//    private String color;
//    private double precio;
//
//    @ManyToOne
//    @JoinColumn(name = "cliente_id")
//    @JsonIgnore
//    private Cliente cliente;
//
////    @OneToMany(mappedBy = "coche", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
////    private Set<Revision> revisiones = new HashSet<>();
//
//}
