package com.app.aulamatriz.micro.usuarios.service.impl;

import com.app.aulamatriz.micro.usuarios.dto.UserDto;
import com.app.aulamatriz.micro.usuarios.model.UserEntity;
import com.app.aulamatriz.micro.usuarios.repository.UserRepository;
import com.app.aulamatriz.micro.usuarios.service.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

        this.userRepository.save(userEntity);

        return "Se guardo el usuario";
    }

    @Override
    public ResponseEntity getAll() {
        var entityList = this.userRepository.findAll();
        return ResponseEntity.ok(entityList);
    }

    @Override
    public ResponseEntity deleteById(long id) {
        this.userRepository.deleteById(id);
        return ResponseEntity.ok("Se borro");
    }

    @Override
    public ResponseEntity updateById(long id, UserDto userDto) {
        //Buscar el usuario por ID
        var user =this.userRepository.findById(id).get();
        if(Objects.isNull(user)){
            return ResponseEntity.ok("Usuario no existe");
        }
        user.setName(userDto.getName());
        user.setLastname(userDto.getLastname());
        user.setPhoneNumber(userDto.getPhoneNumber());

        this.userRepository.save(user);

        return ResponseEntity.ok("usuario actualizado");
    }
}
