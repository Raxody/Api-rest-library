package com.ceiba.biblioteca.service;

import com.ceiba.biblioteca.model.Fecha;
import com.ceiba.biblioteca.model.dto.Mensaje;
import com.ceiba.biblioteca.model.Prestamo;
import com.ceiba.biblioteca.model.dto.PrestamoDTO;
import com.ceiba.biblioteca.repository.PrestamoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioCrearPrestamo {

    private final PrestamoRepository prestamoRepository;

    public ServicioCrearPrestamo(PrestamoRepository prestamoRepository) {
        this.prestamoRepository = prestamoRepository;
    }

    private int status;

    public int getStatus() {
        return status;
    }

    private String validarExistenciaPreviaLibroRepetidoYUsuario(Prestamo prestamo) {

        if (prestamo.getIsbn().length() > 10) {
            return "El isbn del libro debe ser menor a 10 ";
        } else if (prestamo.getIdentificacionUsuario().length() > 10) {
            return "El id del usuario debe ser menor a 10 ";
        }
        List<Prestamo> prestamos = this.prestamoRepository.findAll();
        for (int i = 0; i < prestamos.size(); i++) {
            if (prestamos.get(i).getIdentificacionUsuario().equalsIgnoreCase(prestamo.getIdentificacionUsuario()) && prestamos.get(i).getTipoUsuario() == 3) {
                return "El usuario con identificación " + prestamo.getIdentificacionUsuario() + " ya tiene un libro prestado por lo cual no se le puede realizar otro préstamo";
            }
        }
        return "Ok";
    }

    private String validarTipoUsuario(int tipo) {
        if (tipo >= 1 && tipo <= 3) {
            return "Ok";
        }
        status = 400;
        return "Tipo de usuario no permitido en la biblioteca";
    }

    public Object savePrestamo(Prestamo prestamo) {
        if (validarTipoUsuario(prestamo.getTipoUsuario()).equalsIgnoreCase("Tipo de usuario no permitido en la biblioteca")) {
            return new Mensaje("Tipo de usuario no permitido en la biblioteca");
        }
        if (this.validarExistenciaPreviaLibroRepetidoYUsuario(prestamo).equals("Ok")) {
            Fecha fechaDevolucion = new Fecha();
            prestamo.setFechaMaximaDevolucion(fechaDevolucion.calcularFecha(prestamo.getTipoUsuario()));
            this.prestamoRepository.save(prestamo);
            status = 200;
            return new PrestamoDTO(prestamo.getIdPrestamo(), prestamo.getFechaMaximaDevolucion());
        }
        status = 400;
        return new Mensaje(this.validarExistenciaPreviaLibroRepetidoYUsuario(prestamo));
    }

}
