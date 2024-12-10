//package org.iesch.ad.Ejercicios02.ej5EmpresaProyectosDptos.models;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//@Entity
//@Getter
//@Setter
//
//public class Proyecto {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String nombre;
//    private String descripcion;
//    private Boolean dependeDeProyecto;
//
//    @ManyToOne()
//    @JoinColumn(name = "id_departamento")
//    private Departamento departamento;
//}
