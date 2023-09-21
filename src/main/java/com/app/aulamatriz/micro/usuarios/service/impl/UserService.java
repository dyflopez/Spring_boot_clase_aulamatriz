package com.app.aulamatriz.micro.usuarios.service.impl;

import com.app.aulamatriz.micro.usuarios.dto.UserDto;
import com.app.aulamatriz.micro.usuarios.model.UserEntity;
import com.app.aulamatriz.micro.usuarios.repository.UserRepository;
import com.app.aulamatriz.micro.usuarios.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {


    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String save(UserDto userDto) {
        userDto
                .getSons()
                .stream()
                .forEach(son -> System.out.println(son.getName()));

        //Objeto de Entity

        UserEntity  userEntity = new UserEntity();
        userEntity.setName(userDto.getName());
        userEntity.setLastname(userDto.getLastname());

        userRepository.save(userEntity);

        return "Se guardo el usuario";
    }
}
