package com.example.api.entidades.interfaces;

public interface Peca {
    double valor = 0;
    long id = 0;
    String marca = "";
    String descricao = "";
    String tipo = "";
    // enum ??????

    double getValor();

    String getDescricao();

    String getMarca();
}
