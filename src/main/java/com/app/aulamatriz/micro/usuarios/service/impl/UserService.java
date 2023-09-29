package com.app.aulamatriz.micro.usuarios.service.impl;

import com.app.aulamatriz.micro.usuarios.dto.UserDto;
import com.app.aulamatriz.micro.usuarios.exception.MyException;
import com.app.aulamatriz.micro.usuarios.model.UserEntity;
import com.app.aulamatriz.micro.usuarios.repository.UserRepository;
import com.app.aulamatriz.micro.usuarios.service.IUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Slf4j
@Service
@AllArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;

    @Override
    @Transactional //UPDATE  , DELETE, INSERT
    public String save(UserDto userDto) {

        this
           .userRepository
           .findByDocument(userDto.getDocument())
           .ifPresent( user ->
                {
                    throw  new MyException("El usuario esta registrado en la DB actualmente");
                }
            );


        log.info("save() request data \n{}",
                userDto
                );
        userDto
                .getSons()
                .stream()
                .forEach(son -> System.out.println(son.getName()));

        //Objeto de Entity

        UserEntity  userEntity = new UserEntity();
        userEntity.setName(userDto.getName());
        userEntity.setLastname(userDto.getLastname());
        userEntity.setDocument(userDto.getDocument());

        this.userRepository.save(userEntity);
        log.debug("Se guardo correctamente");//Validar
        log.error("fallo la aplicacion");
        return "Se guardo el usuario";
    }

    @Override
    @Transactional(readOnly = true) //SELECT
    public ResponseEntity getAll() {
        var entityList = this.userRepository.findAll();
        if(entityList.size()==0){
            throw new MyException("No existe ningun usuario en la DB");
        }
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
        var user = this
                .userRepository
                .findById(id)
                .orElseThrow(
                        ()-> new MyException("Usuario no existe")
                );


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
