package com.example.PruebaTecnicaARVision.model;

import jakarta.persistence.*;

/**
 * Clase POJO Usuario con las propiedades id, nombre, apellido, edad.
 */
@Table(name = "usuarios")
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(columnDefinition = "VARCHAR(25)")
    private String nombre;
    @Column(columnDefinition = "VARCHAR(25)")
    private String apellido;
    @Column
    private int edad;

    /**
     * Constructor de clase por defecto
     */
    public Usuario() {
    }
    /**
     * Constructor de clase por defecto
     * @param nombre, apellido, edad
     */
    public Usuario(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                '}';
    }
}
