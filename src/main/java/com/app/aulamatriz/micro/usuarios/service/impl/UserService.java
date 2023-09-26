package com.app.aulamatriz.micro.usuarios.service.impl;

import com.app.aulamatriz.micro.usuarios.dto.UserDto;
import com.app.aulamatriz.micro.usuarios.model.UserEntity;
import com.app.aulamatriz.micro.usuarios.repository.UserRepository;
import com.app.aulamatriz.micro.usuarios.service.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class UserService implements IUserService {


    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional //UPDATE  , DELETE, INSERT
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
    @Transactional(readOnly = true) //SELECT
    public ResponseEntity getAll() {
        var entityList = this.userRepository.findAll();
        return ResponseEntity.ok(entityList);
    }

    @Override
    @Transactional
    public ResponseEntity deleteById(long id) {
        this.userRepository.deleteById(id);
        return ResponseEntity.ok("Se borro");
    }

    @Override
    @Transactional
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

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity getByDocumentWithJPQL(String document) {
        var user = this.userRepository.getUserByDocument(document).orElse(new UserEntity());
        return ResponseEntity.ok(user);
    }
    @Override
    @Transactional(readOnly = true)
    public ResponseEntity getByDocumentWithJPARepository(String document) {
        var user = this.userRepository.findByDocument(document).orElse(new UserEntity());
        return ResponseEntity.ok(user);
    }
}
