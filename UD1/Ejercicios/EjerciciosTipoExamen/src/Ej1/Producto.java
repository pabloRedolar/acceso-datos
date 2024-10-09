package Ej1;

public class Producto {
    private String id;
    private String nombre;
    private Double precio;
    private Boolean descuento;
    private char tipo;

    public Producto() {
    }

    public Producto(String id, String nombre, Double precio, Boolean descuento, char tipo) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.descuento = descuento;
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Boolean getDescuento() {
        return descuento;
    }

    public void setDescuento(Boolean descuento) {
        this.descuento = descuento;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "\nProducto{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", descuento=" + descuento +
                ", tipo=" + tipo +
                '}';
    }
}
