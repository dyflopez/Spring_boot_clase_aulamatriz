package com.app.aulamatriz.micro.usuarios.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SonsDto {

    private String name;
    private String lastName;
    private boolean status;
    private int age;

}
