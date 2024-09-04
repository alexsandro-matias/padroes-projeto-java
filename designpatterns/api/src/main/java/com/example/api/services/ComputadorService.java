package com.example.api.services;

import com.example.api.entidades.Computador;
import com.example.api.entidades.ComputadorBuilder;

public class ComputadorService {
    private Computador computador;
    private ComputadorBuilder builder;

//    TODO: analisar se faz sentido ter o computador ou o builder no construtor
    public ComputadorService(Computador computador) {
        this.computador = computador;
    }

//    TODO: montar computador usando o Builder
//    public Computador montarComputador() {
//        return new Computador();
//    }
}
