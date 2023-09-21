package com.app.aulamatriz.micro.usuarios.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String lastname;

    @Column(name = "phonenumber")
    private String phoneNumber;

    private String document;

    @Column(name = "typedocument")
    private String typeDocument;

}
