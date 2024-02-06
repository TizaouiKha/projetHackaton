package com.example.projetHackatonBack.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")

public class ProjetHackatonBackApplicationController {
    @GetMapping("path")
    public String test() {
        return "test";
    }
}
