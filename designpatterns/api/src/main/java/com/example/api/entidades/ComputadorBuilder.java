package com.example.api.entidades;

import com.example.api.entidades.interfaces.Builder;
import org.springframework.stereotype.Component;

@Component
public class ComputadorBuilder implements Builder {
    private Armazenamento armazenamento;
    private Fonte fonte;
    private Gabinete gabinete;
    private Memoria memoria;
    private PlacaMae placaMae;
    private PlacaVideo placaVideo;
    private Processador processador;
    private Computador computador;

    @Override
    public Builder adicionarArmazenamento(Armazenamento armazenamento) {
        this.armazenamento = armazenamento;
        return this;
    }

    @Override
    public Builder adicionarFonte(Fonte fonte) {
        this.fonte = fonte;
        return this;
    }

    @Override
    public Builder adicionarGabinete(Gabinete gabinete) {
        this.gabinete = gabinete;
        return this;
    }

    @Override
    public Builder adicionarMemoria(Memoria memoria) {
        this.memoria = memoria;
        return this;
    }

    @Override
    public Builder adicionarPlacaMae(PlacaMae placaMae) {
        this.placaMae = placaMae;
        return this;
    }

    @Override
    public Builder adicionarPlacaVideo(PlacaVideo placaVideo) {
        this.placaVideo = placaVideo;
        return this;
    }

    @Override
    public Builder adicionarProcessador(Processador processador) {
        this.processador = processador;
        return this;
    }

    public Computador retornarComputadorMontado() {
        return this.computador;
    }
}
