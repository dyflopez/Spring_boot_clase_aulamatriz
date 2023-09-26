package com.app.aulamatriz.micro.usuarios.service;

import com.app.aulamatriz.micro.usuarios.dto.UserDto;
import com.app.aulamatriz.micro.usuarios.model.UserEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserService {

    String  save(UserDto userDto);

    ResponseEntity getAll();

    ResponseEntity deleteById(long id);

    ResponseEntity updateById(long id , UserDto userDto);

    ResponseEntity getByDocumentWithJPQL(String document);
    ResponseEntity getByDocumentWithJPARepository(String document);

}
