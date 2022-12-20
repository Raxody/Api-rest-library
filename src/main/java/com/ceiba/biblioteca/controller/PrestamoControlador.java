package com.ceiba.biblioteca.controller;


import com.ceiba.biblioteca.model.Prestamo;
import com.ceiba.biblioteca.service.ServicioConsultarPrestamo;
import com.ceiba.biblioteca.service.ServicioCrearPrestamo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PrestamoControlador {

    private ServicioCrearPrestamo servicioCrearPrestamo;
    private ServicioConsultarPrestamo servicioConsultarPrestamo;

    public PrestamoControlador(ServicioCrearPrestamo servicioCrearPrestamo, ServicioConsultarPrestamo servicioConsultarPrestamo) {
        this.servicioCrearPrestamo = servicioCrearPrestamo;
        this.servicioConsultarPrestamo = servicioConsultarPrestamo;
    }

    @PostMapping("/prestamo")
    public ResponseEntity<Object> generarPrestamo(@RequestBody Prestamo prestamo) {
        return new ResponseEntity<>(this.servicioCrearPrestamo.savePrestamo(prestamo), HttpStatus.valueOf(servicioCrearPrestamo.getStatus()));
    }

    @GetMapping("/prestamo/{IdPrestamo}")
    public ResponseEntity<Object> consultarPrestamo(@PathVariable("IdPrestamo") int IdPrestamo) {
        return new ResponseEntity<>(this.servicioConsultarPrestamo.findPrestamo(IdPrestamo), HttpStatus.valueOf(servicioConsultarPrestamo.getStatus()));
    }


}

