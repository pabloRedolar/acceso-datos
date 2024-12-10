package org.example.Ej7;

package org.example;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
/*
 * La anotación @Inheritance(strategy = InheritanceType.JOINED) en JPA especifica la estrategia de herencia para las clases de entidad.
 * Cuando se utiliza InheritanceType.JOINED, significa que cada clase en la jerarquía de herencia se mapeará a su propia tabla en la base de datos. La clave primaria de la tabla de la clase base se utilizará como clave foránea en las tablas de las clases derivadas para establecer la relación entre ellas.
 * Esta estrategia proporciona un esquema de base de datos normalizado y evita la redundancia de datos, pero puede resultar en consultas SQL más complejas debido a la necesidad de realizar uniones entre tablas.
 */
public abstract class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nif;
    private String apellidos;
    private String nombre;
    private Date fechaNacimiento;

    // Getters and setters
}
