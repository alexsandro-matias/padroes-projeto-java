package com.example.api.controllers;

import com.example.api.entidades.Computador;
import com.example.api.services.ComputadorService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ComputadorController {
    private ComputadorService computadorService;

    @GetMapping("/")
    public Computador buscarComputador() {
        return computadorService.montarComputador();
    }

    @PostMapping("/peca/{id}")
    public void adicionarPeca(@PathVariable Long id) {
        // add @RequestBody com a peça
    }

    @GetMapping("/peca")
    public void buscarListaPecas(@RequestParam String categoria) {

    }
}
