package com.example.api.entidades;

public class Computador {
    private Gabinete gabinete;
    private Processador processador;
    private Memoria memoria;
    private Armazenamento armazenamento;
    private PlacaMae placaMae;
    private PlacaVideo placaVideo;
    private Fonte fonte;


    private Computador (
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

//    public void adicionarPeca(Peca peca) {
//
//    }
}