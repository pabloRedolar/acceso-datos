//package org.iesch.ad.Ejercicios02.ej5EmpresaProyectosDptos.models;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Entity
//@Getter
//@Setter
//
//public class Departamento {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String nombre;
//    private Boolean dependeDepartamento;
//
////    @OneToMany(mappedBy = "departamento", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
////
////    private Set<Empleado> empleados = new HashSet<>();
//
//    @OneToMany(mappedBy = "departamento")
//    private Set<Proyecto> proyectos = new HashSet<>();
//
//}
