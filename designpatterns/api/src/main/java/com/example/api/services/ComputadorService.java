package com.example.api.services;

import com.example.api.entidades.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComputadorService {
    private ComputadorBuilder builder;

    @Autowired
    public ComputadorService(ComputadorBuilder builder) {
        this.builder = builder;
    }

    public Computador montarComputador() {
        builder.adicionarGabinete(new Gabinete());
        builder.adicionarArmazenamento(new Armazenamento());
        builder.adicionarFonte(new Fonte());
        builder.adicionarMemoria(new Memoria());
        builder.adicionarPlacaMae(new PlacaMae());
        builder.adicionarPlacaVideo(new PlacaVideo());
        builder.adicionarProcessador(new Processador());
        return builder.retornarComputadorMontado();
    }
}
