package com.ceiba.biblioteca.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "prestamo")
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdPrestamo;

    private String isbn;
    @Column(name = "IDENTIFICACION_USUARIO")
    private String identificacionUsuario;
    private Integer tipoUsuario;
    private String fechaMaximaDevolucion;

    public Prestamo() {

    }

    public Integer getIdPrestamo() {
        return IdPrestamo;
    }


    public String getIsbn() {
        return isbn;
    }


    public String getIdentificacionUsuario() {
        return identificacionUsuario;
    }


    public Integer getTipoUsuario() {
        return tipoUsuario;
    }

    public String getFechaMaximaDevolucion() {
        return fechaMaximaDevolucion;
    }

    public void setFechaMaximaDevolucion(String fechaMaximaDevolucion) {
        this.fechaMaximaDevolucion = fechaMaximaDevolucion;
    }

}
