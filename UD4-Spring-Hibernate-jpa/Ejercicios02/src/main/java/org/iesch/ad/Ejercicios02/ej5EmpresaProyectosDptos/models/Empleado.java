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
//public class Empleado {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String nombre;
//    private String apellidos;
//    private String direccion;
//    private int telefono;
//    private String nif;
//    private String nss;
//    private Boolean isJefe;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "id_departamento")
//
//    private Departamento departamento;
//
//}
