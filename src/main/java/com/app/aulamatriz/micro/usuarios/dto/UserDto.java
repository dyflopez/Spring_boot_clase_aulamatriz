package com.app.aulamatriz.micro.usuarios.dto;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

        private String name;
        private String lastname;
        private String phoneNumber;
        private String document;
        private String typeDocument;
        private List<SonsDto> sons;
}