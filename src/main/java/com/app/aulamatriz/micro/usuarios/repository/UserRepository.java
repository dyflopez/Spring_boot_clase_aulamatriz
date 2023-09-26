package com.app.aulamatriz.micro.usuarios.repository;

import com.app.aulamatriz.micro.usuarios.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long> {


    //@Query("SELECT  * FROM user u where  s.document =  :valor ") SQL  - NATIVE QUERY
    @Query("SELECT u FROM UserEntity u WHERE  u.document =  ?1 ") //JPQL
    Optional<UserEntity> getUserByDocument (String doc);

    @Modifying
    @Query("UPDATE UserEntity  u SET u.lastname = ?1 WHERE u.document = ?2 ")
    int updateLastnameByDocument(String lastname, String document);


    Optional<UserEntity> findByDocument(String document );

}
