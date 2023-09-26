package com.app.aulamatriz.micro.usuarios.controller;


import com.app.aulamatriz.micro.usuarios.dto.UserDto;
import com.app.aulamatriz.micro.usuarios.model.UserEntity;
import com.app.aulamatriz.micro.usuarios.service.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    //private UserService userService = new UserService();

    private final IUserService iUserService;

    public UserController(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @GetMapping
    public ResponseEntity getAllUsers(){
        return this.iUserService.getAll();
    }

    @GetMapping("/document-jpql/{document}")
    public ResponseEntity getUserByDocumentJPQL(@PathVariable String document){
        return  this.iUserService.getByDocumentWithJPQL(document);
    }


    //POST se usa para guardar informacion en la base de datos
    @PostMapping
    public String save(@RequestBody UserDto userDto){
        return  iUserService.save(userDto);
    }

    @PostMapping("/benefits")
    public long saveAndBenefits(@RequestBody UserDto userDto){
        return  userDto
                .getSons()
                .stream()
                .filter(s-> !s.isStatus())
                .count();
    }
    /**
     * Busqueda por Id del usuario
     */

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable long id){
        return this.iUserService.deleteById(id);
    }



    /**
     * Probar el PUT
     */
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable long id,
                                 @RequestBody UserDto userDto){
        return  this.iUserService.updateById(id,userDto);
    }
}
