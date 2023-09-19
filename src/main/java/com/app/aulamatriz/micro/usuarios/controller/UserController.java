package com.app.aulamatriz.micro.usuarios.controller;


import com.app.aulamatriz.micro.usuarios.dto.UserDto;
import com.app.aulamatriz.micro.usuarios.service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    //private UserService userService = new UserService();

    private final IUserService iUserService;

    public UserController(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    //Get es para obtner informacion en la base datos
    @GetMapping
    public String getAllUsers(){
        return "lista de usuarios";
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
}
