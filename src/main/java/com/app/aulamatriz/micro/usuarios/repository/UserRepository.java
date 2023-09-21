package com.app.aulamatriz.micro.usuarios.repository;

import com.app.aulamatriz.micro.usuarios.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
}
