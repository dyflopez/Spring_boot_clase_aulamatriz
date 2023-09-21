package com.app.aulamatriz.micro.usuarios.controller;

import com.app.aulamatriz.micro.usuarios.service.ICalculadoraService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/v1/calculadora/calculadora-aulamatriz")
public class CalculadoraController {

    private final ICalculadoraService calculadoraService;

    public CalculadoraController(ICalculadoraService calculadoraService) {
        this.calculadoraService = calculadoraService;
    }

    @GetMapping
    public int sumarNumeros(@PathParam("valor1") int valor1,
                            @PathParam("valor2") int valor2)
    {
        return  this.calculadoraService.sumar(valor1,valor2);
    }


}
