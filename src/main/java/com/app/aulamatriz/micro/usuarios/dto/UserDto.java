package com.app.aulamatriz.micro.usuarios.dto;

import lombok.*;

import javax.validation.constraints.*;
import java.util.List;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

        @NotBlank
        @NotEmpty
        @Size(min=5,message = "el rango minimo es 5")
        private String name;

        @NotNull(message = "el mensaje no puede ser null")
        private String lastname;

        private String phoneNumber;

        private String document;

        private String typeDocument;

        private List<SonsDto> sons;
}