package com.app.aulamatriz.micro.usuarios.controller.v1.docs;

import com.app.aulamatriz.micro.usuarios.dto.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Tag(name = "User",description = "API para interacturar con el USER")
public interface UserDoc {

    @Operation(
            summary = "crear usurio",
            description = "Este api crea un usuario"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
            description = "El usuario fue creado correctamente",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "400",
            description = "Error al crear el usuario",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
    })
    ResponseEntity create(@Valid @RequestBody UserDto userDto);

    @Operation(summary = "listar usuarios",description = "Listar todos los usuarios")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "ok",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "400",
                    description = "Error al buscar",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
    })
    ResponseEntity getAll();

}
