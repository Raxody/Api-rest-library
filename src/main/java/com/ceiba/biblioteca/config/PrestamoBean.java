package com.ceiba.biblioteca.config;

import com.ceiba.biblioteca.repository.PrestamoRepository;
import com.ceiba.biblioteca.service.ServicioConsultarPrestamo;
import com.ceiba.biblioteca.service.ServicioCrearPrestamo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PrestamoBean {

    @Bean
    ServicioCrearPrestamo crearPrestamoServiceBean(PrestamoRepository prestamoRepository) {
        return new ServicioCrearPrestamo(prestamoRepository);
    }

    @Bean
    ServicioConsultarPrestamo consultarPrestamoServiceBean(PrestamoRepository prestamoRepository) {
        return new ServicioConsultarPrestamo(prestamoRepository);
    }


}
