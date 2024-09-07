package com.example.api.entidades;

public class Computador {
    private final Gabinete gabinete;
    private final Processador processador;
    private final Memoria memoria;
    private final Armazenamento armazenamento;
    private final PlacaMae placaMae;
    private final PlacaVideo placaVideo;
    private final Fonte fonte;

//    public Computador() {
//    }

    public Computador (
            Gabinete gabinete,
            Processador processador,
            Memoria memoria,
            Armazenamento armazenamento,
            PlacaMae placaMae,
            PlacaVideo placaVideo,
            Fonte fonte
    )
    {
        this.gabinete = gabinete;
        this.processador = processador;
        this.memoria = memoria;
        this.armazenamento = armazenamento;
        this.placaMae = placaMae;
        this.placaVideo = placaVideo;
        this.fonte = fonte;
    }

    public Gabinete getGabinete() {
        return gabinete;
    }

    public Processador getProcessador() {
        return processador;
    }

    public Memoria getMemoria() {
        return memoria;
    }

    public Armazenamento getArmazenamento() {
        return armazenamento;
    }

    public PlacaMae getPlacaMae() {
        return placaMae;
    }

    public PlacaVideo getPlacaVideo() {
        return placaVideo;
    }

    public Fonte getFonte() {
        return fonte;
    }
}