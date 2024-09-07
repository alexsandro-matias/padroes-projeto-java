package com.example.api.entidades.interfaces;

import com.example.api.entidades.*;

public interface Builder {
    /*
    * ENTIDADES:
    * Armazenamento
    * Fonte
    * Gabinete
    * Memoria
    * Placa-mãe
    * Placa de vídeo
    * Processador
    * */

    void adicionarArmazenamento(Armazenamento armazenamento);
    void adicionarFonte(Fonte fonte);
    void adicionarGabinete(Gabinete gabinete);
    void adicionarMemoria(Memoria memoria);
    void adicionarPlacaMae(PlacaMae placaMae);
    void adicionarPlacaVideo(PlacaVideo placaVideo);
    void adicionarProcessador(Processador processador);
}
