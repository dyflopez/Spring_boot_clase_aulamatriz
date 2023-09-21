package com.app.aulamatriz.micro.usuarios.service.impl;

import com.app.aulamatriz.micro.usuarios.service.ICalculadoraService;
import org.springframework.stereotype.Service;

@Service
public class CalcladoraService implements ICalculadoraService {

    @Override
    public int sumar(int a, int b) {
        return a+b;
    }
}
