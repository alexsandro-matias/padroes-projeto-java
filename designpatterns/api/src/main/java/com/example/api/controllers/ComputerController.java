package com.example.api.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class ComputerController {

    @GetMapping("/")
    public String getComputer() {
        return "Computer!!!";
    }

    @PostMapping("/part/{id}")
    public void addPart(@PathVariable Long id) {
        // add @RequestBody with the part
    }

    @GetMapping("/part")
    public void getPartList(@RequestParam String category) {

    }
}
