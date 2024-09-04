package com.example.api.entidades;

import com.example.api.entidades.interfaces.Peca;

public class Armazenamento implements Peca {

    @Override
    public double getValor() {
        return 0;
    }

    @Override
    public String getDescricao() {
        return "";
    }

    @Override
    public String getMarca() {
        return "";
    }
}
