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

    @Override
    public void adicionarArmazenamento(Armazenamento armazenamento) {
        this.armazenamento = armazenamento;
    }

    @Override
    public void adicionarFonte(Fonte fonte) {
        this.fonte = fonte;
    }

    @Override
    public void adicionarGabinete(Gabinete gabinete) {
        this.gabinete = gabinete;
    }

    @Override
    public void adicionarMemoria(Memoria memoria) {
        this.memoria = memoria;
    }

    @Override
    public void adicionarPlacaMae(PlacaMae placaMae) {
        this.placaMae = placaMae;
    }

    @Override
    public void adicionarPlacaVideo(PlacaVideo placaVideo) {
        this.placaVideo = placaVideo;
    }

    @Override
    public void adicionarProcessador(Processador processador) {
        this.processador = processador;
    }

    public Computador retornarComputadorMontado() {
        return new Computador(
                this.gabinete,
                this.processador,
                this.memoria,
                this.armazenamento,
                this.placaMae,
                this.placaVideo,
                this.fonte
        );
    }
}
