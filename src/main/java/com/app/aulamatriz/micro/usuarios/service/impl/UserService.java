package com.app.aulamatriz.micro.usuarios.service.impl;

import com.app.aulamatriz.micro.usuarios.dto.UserDto;
import com.app.aulamatriz.micro.usuarios.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Override
    public String save(UserDto userDto) {
        userDto
                .getSons()
                .stream()
                .forEach(son -> System.out.println(son.getName()));

        return "Se guardo el usuario";
    }
}
