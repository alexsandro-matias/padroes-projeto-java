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

    Builder adicionarArmazenamento(Armazenamento armazenamento);
    Builder adicionarFonte(Fonte fonte);
    Builder adicionarGabinete(Gabinete gabinete);
    Builder adicionarMemoria(Memoria memoria);
    Builder adicionarPlacaMae(PlacaMae placaMae);
    Builder adicionarPlacaVideo(PlacaVideo placaVideo);
    Builder adicionarProcessador(Processador processador);
}
