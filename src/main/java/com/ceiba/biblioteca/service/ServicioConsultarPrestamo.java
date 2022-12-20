package com.ceiba.biblioteca.service;

import com.ceiba.biblioteca.model.Prestamo;
import com.ceiba.biblioteca.model.dto.PrestamoFindDTO;
import com.ceiba.biblioteca.repository.PrestamoRepository;

import java.util.Optional;

public class ServicioConsultarPrestamo {

    private final PrestamoRepository prestamoRepository;
    private int status;

    public ServicioConsultarPrestamo(PrestamoRepository prestamoRepository) {
        this.prestamoRepository = prestamoRepository;
    }

    public int getStatus() {
        return status;
    }

    private boolean validarExistencia(int idPrestamo) {
        if (prestamoRepository.existsById(idPrestamo)) {
            return true;
        }
        return false;
    }

    public Object findPrestamo(int idPrestamo) {
        if (validarExistencia(idPrestamo)) {
            Optional<Prestamo> objPrestamo = prestamoRepository.findById(idPrestamo);
            status = 200;
            return new PrestamoFindDTO(objPrestamo.get().getIdPrestamo(), objPrestamo.get().getIsbn(),
                    objPrestamo.get().getIdentificacionUsuario(), objPrestamo.get().getTipoUsuario(),
                    objPrestamo.get().getFechaMaximaDevolucion());
        }
        status = 400;
        return null;

    }


}
