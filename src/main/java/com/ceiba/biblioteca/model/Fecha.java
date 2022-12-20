package com.ceiba.biblioteca.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class Fecha {
    int mes;
    List<Integer> diasHabiles;
    int dias;
    int anio;
    List<Fecha> fecha = new ArrayList<>();

    public Fecha(int mes, List<Integer> diasHabiles, int dias, int anio) {
        this.mes = mes;
        this.diasHabiles = diasHabiles;
        this.dias = dias;
        this.anio = anio;
    }

    public Fecha() {
        fecha.add(new Fecha(1, Arrays.asList(1, 2, 8, 9, 15, 16, 22, 23, 29, 30), 31, 2022)); //Enero
        fecha.add(new Fecha(2, Arrays.asList(5, 6, 12, 13, 19, 20, 26, 27), 28, 2022)); //Febrero
        fecha.add(new Fecha(3, Arrays.asList(5, 6, 12, 13, 19, 20, 26, 27), 31, 2022)); //Marzo
        fecha.add(new Fecha(4, Arrays.asList(2, 3, 9, 10, 16, 17, 23, 24, 30), 30, 2022)); //Abril
        fecha.add(new Fecha(5, Arrays.asList(1, 7, 8, 14, 15, 21, 22, 28, 29), 31, 2022)); //Mayo
        fecha.add(new Fecha(6, Arrays.asList(4, 5, 11, 12, 18, 19, 25, 26), 30, 2022)); //Junio
        fecha.add(new Fecha(7, Arrays.asList(2, 3, 9, 10, 16, 17, 23, 24, 30, 31), 31, 2022)); //Julio
        fecha.add(new Fecha(8, Arrays.asList(6, 7, 13, 14, 20, 21, 27, 28), 31, 2022)); // Agosto
        fecha.add(new Fecha(9, Arrays.asList(3, 4, 10, 11, 17, 18, 24, 25), 30, 2022)); //Septiembre
        fecha.add(new Fecha(10, Arrays.asList(1, 2, 8, 9, 15, 16, 22, 23, 29, 30), 31, 2022)); //Octubre
        fecha.add(new Fecha(11, Arrays.asList(5, 6, 12, 13, 19, 20, 26, 27), 30, 2022)); //Noviembre
        fecha.add(new Fecha(12, Arrays.asList(3, 4, 10, 11, 17, 18, 24, 25, 31), 31, 2022)); //Diciembre
    }

    private String formateador(int valor) {
        if (valor >= 0 && valor <= 9) {
            return "0" + valor;
        }
        return "" + valor;
    }

    private int elegirDiasTipoUsuario(int tipoUsuario) {
        if (tipoUsuario == 1) {
            return 10;
        } else if (tipoUsuario == 2) {
            return 8;
        }
        return 7;
    }


    public String calcularFecha(int tipoUsuario) {

        int diasPrestamo = this.elegirDiasTipoUsuario(tipoUsuario);

        Calendar objF = Calendar.getInstance();
        int dia = objF.get(Calendar.DAY_OF_MONTH);
        int mes = objF.get(Calendar.MONTH);
        int anio = objF.get(Calendar.YEAR);
        for (int i = 0; i < diasPrestamo; i++) {
            if (dia == fecha.get(mes).dias) {
                mes++;
                dia = 0;
            }
            dia++;
            for (int j = 0; j < fecha.get(mes).diasHabiles.size(); j++) {
                if (dia <= fecha.get(mes).dias) {
                    if (fecha.get(mes).diasHabiles.get(j) == dia) {
                        diasPrestamo++;
                        break;
                    }
                }
            }
        }
        mes++;
        return this.formateador(dia) + "/" + this.formateador(mes) + "/" + anio;
    }


}
