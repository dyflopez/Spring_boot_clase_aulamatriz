package com.app.aulamatriz.micro.usuarios.controller.v1;

import com.app.aulamatriz.micro.usuarios.controller.v1.docs.UserDoc;
import com.app.aulamatriz.micro.usuarios.dto.UserDto;
import com.app.aulamatriz.micro.usuarios.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/user")
public class UserControllerV1 implements UserDoc {

    private final IUserService iUserService;

    @Override
    @PostMapping
    public ResponseEntity create(UserDto userDto) {
        return ResponseEntity
                .status(
                        HttpStatus.CREATED
                )
                .body(this.iUserService.save(userDto));
    }

    @Override
    @GetMapping
    public ResponseEntity getAll() {
        return this.iUserService.getAll();
    }

}
